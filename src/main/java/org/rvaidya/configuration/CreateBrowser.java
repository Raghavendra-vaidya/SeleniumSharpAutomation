package org.rvaidya.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class CreateBrowser {


    public static WebDriver driver;
    static ConfigLoader config = new ConfigLoader();

    static String webUrl = config.getAppUrl();
    static String implicitWaitTime = config.getImplicitWaitTimeOut();
    static Integer implicitWait = Integer.valueOf(implicitWaitTime);

    public synchronized static WebDriver instance(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            driver = new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait)); // need to read this from file and pass here
        driver.get(webUrl);
        return driver;

    }


}
