package com.seleniumframeworks.utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {

    @DataProvider(name = "DataContainer", parallel = true)
    public static Object[] getData(Method method){
        List<Map<String,String>> listOfData = ExcelUtils.getTestData("Data");

        return listOfData
                .parallelStream()
                .filter(val -> val.get("testname").equalsIgnoreCase(method.getName()) && val.get("execute").equalsIgnoreCase("Y"))
                .toArray();
    }
}
