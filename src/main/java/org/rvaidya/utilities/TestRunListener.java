package org.rvaidya.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rvaidya.utilities.reportUtils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.regex.Pattern;

public class TestRunListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.createInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    private static final Logger log = LogManager.getLogger(TestRunListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Started : " + result.getName());
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        String testClassFull[] = result.getInstanceName().split(Pattern.quote("."));
        String testClassName = testClassFull[testClassFull.length - 1];
        test.assignCategory(testClassName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Passed : " + result.getName());
        String logText = "<b>Test method " + result.getMethod().getMethodName() + " Successful</b>";
        Markup mark = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS, mark);

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test Failed : " + result.getName());
        log.error("Error : " + result.getThrowable());
        String exceptionMsg = result.getThrowable().toString();
        extentTest.get().fail("<details><summary><b><font color=red>" + " Exception occurred click to see the details:"
                + "</font></b></summary>" + exceptionMsg.replaceAll(",", "<br>") + "</details> \n");

        String logText = "<b>Test method " + result.getMethod().getMethodName() + " Failed</b>";
        Markup mark = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL, mark);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test Skipped: " + result.getName());
        String logText = "<b>Test method " + result.getMethod().getMethodName() + " Skipped</b>";
        Markup mark = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP, mark);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Starting Test Execution: " + context.getName());
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Finished Test Execution: " + context.getName());
        if (extent != null) extent.flush();
    }
}
