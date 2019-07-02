package com.aurora.news.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


@Slf4j
public class PropertyReader {

    public String GetProperty(String propertyFileName, String propertyName) throws PropertyException {
        String propertyValue;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File propertyFile = new File(classLoader.getResource(propertyFileName).getFile());

            Properties properties = new Properties();
            try (InputStream inputStream = new FileInputStream(propertyFile)) {
                properties.load(inputStream);
            }
            propertyValue = properties.getProperty(propertyName);
        } catch (Exception exception) {
            throw new PropertyException(exception.getMessage());
        }

        return propertyValue;
    }
}
