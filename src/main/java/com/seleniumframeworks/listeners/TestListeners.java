package com.seleniumframeworks.listeners;

import com.seleniumframeworks.annotations.FrameworkAnnotations;
import com.seleniumframeworks.reports.ExtentLogger;
import com.seleniumframeworks.reports.ExtentReportNG;
import com.seleniumframeworks.utils.ELKUtils;
import com.seleniumframeworks.utils.PropertyFileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;

import static com.seleniumframeworks.enums.PropertyFileConstants.PUBLISH_TO_ELK;

public class TestListeners implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReportNG.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReportNG.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportNG.createTestReport(result.getMethod().getMethodName());
        ExtentReportNG.addAuthor(
                result
                        .getMethod()
                        .getConstructorOrMethod()
                        .getMethod()
                        .getAnnotation(FrameworkAnnotations.class)
                        .author()
        );
        ExtentReportNG.addCategory(
                result
                        .getMethod()
                        .getConstructorOrMethod()
                        .getMethod()
                        .getAnnotation(FrameworkAnnotations.class)
                        .category()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("TEST PASSED: "+result.getMethod().getMethodName(), true);

        if(PropertyFileUtils.getValue(PUBLISH_TO_ELK).equalsIgnoreCase("yes"))
            ELKUtils.sendResultsToELK(
                    result.getMethod().getMethodName(),
                    "pass",
                    result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author(),
                    result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("TEST FAILED: "+result.getMethod().getMethodName(), true);
        ExtentLogger.fail("REASON: "+result.getThrowable().getMessage());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

        if(PropertyFileUtils.getValue(PUBLISH_TO_ELK).equalsIgnoreCase("yes"))
            ELKUtils.sendResultsToELK(
                    result.getMethod().getMethodName(),
                    "fail",
                    result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author(),
                    result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
    }
}
