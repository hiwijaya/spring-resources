package com.hiwijaya.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

/**
 * @author Happy Indra Wijaya
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        ResourceLoaderService loader = context.getBean(ResourceLoaderService.class);
        try {
            loader.printResourceData("https://hiwijaya.com/profile.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
