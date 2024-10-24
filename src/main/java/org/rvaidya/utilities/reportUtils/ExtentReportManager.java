package org.rvaidya.utilities.reportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.rvaidya.configuration.ConfigLoader;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;
    static ConfigLoader config = new ConfigLoader();

    public static ExtentReports createInstance() {
        String reportFolder = config.getReportFolderName();
        final String directory = System.getProperty("user.dir") + "/" + reportFolder + "/";
        new File(directory).mkdirs();
        String path = directory + config.getReportName() + ".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Automation Reports");
        sparkReporter.config().setReportName("OrangeHRM Demo Test Results");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimelineEnabled(false);
        sparkReporter.viewConfigurer()
                .viewOrder()
                .as(new ViewName[]{
                        ViewName.DASHBOARD,
                        ViewName.CATEGORY,
                        ViewName.TEST,
                        ViewName.EXCEPTION
                })
                .apply();

        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "rvaidya");
        extent.setSystemInfo("Scope", "OrangeHRM UI Tests");
        extent.setSystemInfo("Docker Image: Chrome", "selenium/standalone-chromium");
        extent.setSystemInfo("Docker Image: Chrome", "selenium/standalone-firefox");
        extent.attachReporter(sparkReporter);
        return extent;
    }
}