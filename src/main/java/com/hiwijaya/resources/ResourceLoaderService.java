package com.hiwijaya.resources;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Happy Indra Wijaya
 */
@Component
public class ResourceLoaderService implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getResourceByURL(String url){
        return resourceLoader.getResource(url);
    }

    public void printResourceData(String source) throws IOException {
        Resource resource = resourceLoader.getResource(source);
        InputStream in = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while (true) {
            String line = reader.readLine();
            if (line == null){
                break;
            }
            System.out.println(line);
        } reader.close();
    }

}
