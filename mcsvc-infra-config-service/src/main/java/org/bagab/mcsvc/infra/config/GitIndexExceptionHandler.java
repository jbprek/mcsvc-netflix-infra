package org.bagab.mcsvc.infra.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.config.server.environment.JGitEnvironmentRepository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.File;
import java.nio.file.Paths;

/**
 * Handle the issue where a corrupt index may cause the config server to never send config
 * <p/> On the first call IllegalStateException will be thrown and this code will delete the file.
 * <p/>On the new call the service will recreate the index
 */
@ControllerAdvice
@ConditionalOnProperty(prefix="spring.cloud.config.server.git", value="uri")
public class GitIndexExceptionHandler extends ResponseEntityExceptionHandler {

    private final JGitEnvironmentRepository jGitEnvironmentRepository;

    public GitIndexExceptionHandler(JGitEnvironmentRepository jGitEnvironmentRepository) {
        this.jGitEnvironmentRepository = jGitEnvironmentRepository;
    }

    @ExceptionHandler(value = IllegalStateException.class)
    void fixCorruptedGitIndex(IllegalStateException ex){
        File baseDir = jGitEnvironmentRepository.getBasedir();
        File indexFile = Paths.get(baseDir.getAbsolutePath(), ".git", "index").toFile();

        if (indexFile.exists() && indexFile.length() < 12) {
            boolean deleted = indexFile.delete();
            if (deleted){
                logger.info("Deleting corrupt git index at:" + indexFile.getAbsolutePath());
            } else {
                logger.error("Failed to delete corrupt git index at:" + indexFile.getAbsolutePath());
            }
        }
        throw ex;
    }

}
