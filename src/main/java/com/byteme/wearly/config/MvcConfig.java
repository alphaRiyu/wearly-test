package com.byteme.wearly.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project wearly
 * @created Mar 04, 2022 10:09 AM
 */
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("user-profile", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDIr = Paths.get(dirName);
        String uploadPath = uploadDIr.toFile().getAbsolutePath();
        if (dirName.startsWith("../")) {
            dirName = dirName.replace("../", "");
        }
        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
    }
}
