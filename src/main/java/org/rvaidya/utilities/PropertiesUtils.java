package org.rvaidya.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class PropertiesUtils {
    private static final Logger log = LogManager.getLogger(TestRunListener.class);

    public synchronized static Properties getPropertiesFileInstance(String fileLocation) {
        Properties properties = null;

        File requiredFile = new File(fileLocation);
        try {
            FileInputStream fileInputStream = new FileInputStream(requiredFile);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public synchronized static String getValueForKey(String fileLocation, String key) {

        String data = null;
        try {
            Properties prop = getPropertiesFileInstance(fileLocation);
            data = prop.getProperty(key);

        } catch (Exception otherException) {
            otherException.printStackTrace();
        }
        return data;

    }

    public static synchronized void takeScreenShotOnFailure(WebDriver driver, ITestResult result) {
        int status = result.getStatus();

        if (status == ITestResult.SUCCESS || status == ITestResult.SKIP) {
            return;
        }

        File destnFolder = new File("./Screenshots/");

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destn = new File("./Screenshots/" + result.getName() + "jpg");

        try {
            if (!destnFolder.exists()) destnFolder.mkdir();
            Files.copy(src.toPath(), destn.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }


}
