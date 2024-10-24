package org.rvaidya.LoginTest;

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

public class LoginTest extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        driver = setUpDriver("Chrome");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(description = "Verify fields are visible in the login page")
    public void testFieldsAreVisible() {
        Assert.assertTrue(loginPage.getHeaderTextElement().isDisplayed());
        Assert.assertTrue(loginPage.getUsernameFieldLabel().isDisplayed());
        Assert.assertTrue(loginPage.getPasswordFieldLabel().isDisplayed());
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
        Assert.assertTrue(loginPage.getPassworField().isDisplayed());
        Assert.assertTrue(loginPage.getForgotPasswordLink().isDisplayed());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test(description = "Verify user can successfully login")
    public void testValidLogin() {
        JsonObject loginCreds = JsonFile.getJsonFileObject("src/test/resources/loginData.json").get("valid_creds").getAsJsonObject();
        loginPage.setUsername(loginCreds.get("username").getAsString());
        loginPage.setPassword(loginCreds.get("password").getAsString());
        loginPage.clickOnLogin();
        dashboardPage.getUserLogout().click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertTrue(dashboardPage.getUpgradeButton().isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        clearDriver();
    }
}
