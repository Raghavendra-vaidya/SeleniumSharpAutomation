package org.rvaidya.LoginTest;

import org.openqa.selenium.WebDriver;
import org.rvaidya.ui.LoginPage;
import org.rvaidya.utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = setUpDriver("Chrome");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Verify page title")
    public void testPageTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @Test(description = "Verify username field is displayed")
    public void testUsernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getUsernameField().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        clearDriver();
    }
}
