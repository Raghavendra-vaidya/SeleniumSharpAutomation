package org.rvaidya.DashboardTest;

import com.google.gson.JsonObject;
import org.openqa.selenium.WebDriver;
import org.rvaidya.ui.DashboardPage;
import org.rvaidya.ui.LoginPage;
import org.rvaidya.utilities.BaseTest;
import org.rvaidya.utilities.jsonUtilities.JsonFile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    JsonObject loginCreds = JsonFile.getJsonFileObject("src/test/resources/loginData.json").get("valid_creds").getAsJsonObject();

    @BeforeMethod
    public void setUp() {
        driver = setUpDriver("Chrome");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.setUsername(loginCreds.get("username").getAsString());
        loginPage.setPassword(loginCreds.get("password").getAsString());
        loginPage.clickOnLogin();
    }

    @Test(description = "Verify dashboard has upgrade button visible")
    public void verifyUpgradeButton() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertTrue(dashboardPage.getUpgradeButton().isDisplayed());
    }

    @Test(description = "Verify dashboard logout button is visible")
    public void verifyUserLogoutVisible() {
        dashboardPage.getUserProfileDropdown().click();
        Assert.assertTrue(dashboardPage.getUserLogout().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        clearDriver();
    }


}
