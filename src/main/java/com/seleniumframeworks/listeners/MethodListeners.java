package com.seleniumframeworks.listeners;

import com.seleniumframeworks.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class MethodListeners implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        BiPredicate<String,String> isEqual = String::equalsIgnoreCase;
        ToIntFunction<String> parseInt = Integer::parseInt;

        List<Map<String,String>> listOfData = ExcelUtils.getTestData("RunManager");
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> listOfDatum : listOfData) {
                if (isEqual.test(method.getMethod().getMethodName(),listOfDatum.get("testname")) && isEqual.test(listOfDatum.get("execute"),"Y")) {
                    setTestMetadata(m -> m.setInvocationCount(parseInt.applyAsInt(listOfDatum.get("count"))), method);
                    setTestMetadata(m -> m.setPriority(parseInt.applyAsInt(listOfDatum.get("priority"))), method);
                    setTestMetadata(m -> m.setDescription(listOfDatum.get("testdescription")), method);
                    result.add(method);
                }
            }
        }
        return result;
    }

    public void setTestMetadata(Consumer<ITestNGMethod> methodConsumer, IMethodInstance method){
        methodConsumer.accept(method.getMethod());
    }
}
