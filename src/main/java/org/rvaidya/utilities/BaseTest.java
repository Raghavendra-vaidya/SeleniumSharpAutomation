package org.rvaidya.utilities;

import org.openqa.selenium.WebDriver;
import org.rvaidya.configuration.CreateBrowser;

public class BaseTest {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

    public synchronized static WebDriver setUpDriver(String browser) {
        driverThreadLocal.set(CreateBrowser.instance(browser));
        return driverThreadLocal.get();
    }

    public synchronized static void clearDriver() {
        driverThreadLocal.remove();
    }
}
