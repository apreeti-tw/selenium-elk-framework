package com.seleniumframeworks.utils;

public final class DynamicPathUtils {
    private DynamicPathUtils(){}

    public static String getXpath(String xpath, String value){
        return String.format(xpath,value);
    }
}
