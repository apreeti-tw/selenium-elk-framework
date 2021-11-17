package com.seleniumframeworks.constants;

import com.seleniumframeworks.enums.PropertyFileConstants;
import com.seleniumframeworks.utils.PropertyFileUtils;

public final class Constants {
    private Constants(){}

    private static final String PATH_TO_RESOURCES = System.getProperty("user.dir")+"/src/test/resources/";
    private static final String CHROME_DRIVER_PATH = PATH_TO_RESOURCES+"executables/chromedriver";
    private static final String FIREFOX_DRIVER_PATH = PATH_TO_RESOURCES+"executables/geckodriver";
    private static final String CONFIG_PROPERTY_FILE_PATH = PATH_TO_RESOURCES+"config/config.properties";
    private static final String EXTENT_REPORT_FOLDER_PATH = PATH_TO_RESOURCES+"reports/";
    private static final String EXCEL_FILE_PATH = PATH_TO_RESOURCES+"test-data/test-data.xlsx";
    private static final int EXPLICIT_WAIT_TIMEOUT = 10;
    private static String EXTENT_REPORT_FILE_PATH;

    public static void createFile(){
        if(PropertyFileUtils.getValue(PropertyFileConstants.OVERRIDE).equalsIgnoreCase("yes")){
            EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH+System.currentTimeMillis()+"_index.html";
        } else EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH+"index.html";
    }

    public static String getChromeDriverPath() {
        return CHROME_DRIVER_PATH;
    }

    public static String getFirefoxDriverPath() {
        return FIREFOX_DRIVER_PATH;
    }

    public static String getConfigPropertyFilePath() {
        return CONFIG_PROPERTY_FILE_PATH;
    }

    public static String getExtentReportFilePath() {
        return EXTENT_REPORT_FILE_PATH;
    }

    public static String getExcelFilePath() {
        return EXCEL_FILE_PATH;
    }

    public static int getExplicitWaitTimeout() {
        return EXPLICIT_WAIT_TIMEOUT;
    }
}
