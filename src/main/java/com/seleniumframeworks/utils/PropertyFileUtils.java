package com.seleniumframeworks.utils;

import com.seleniumframeworks.constants.Constants;
import com.seleniumframeworks.enums.PropertyFileConstants;
import com.seleniumframeworks.exceptions.PropertyFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyFileUtils {
    private PropertyFileUtils(){}

    private static Properties properties = new Properties();
    private static Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream(Constants.getConfigPropertyFilePath())) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        properties.forEach((key, value) -> CONFIGMAP.put(String.valueOf(key), String.valueOf(value)));
    }

    public static String getValue(PropertyFileConstants key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase())))
            throw new PropertyFileException("Property "+key+" was not found. Please check config.properties file");

        return properties.getProperty(key.toString().toLowerCase());
    }
}
