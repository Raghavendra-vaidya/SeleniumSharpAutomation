package org.rvaidya.ui;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.rvaidya.utilities.jsonUtilities.JsonFile;

public class LoginPage {
    WebDriver driver;
    static JsonObject loginIdentifiers = JsonFile.getJsonFileObject("src/main/resources/loginIdentifiers.json");

    /* Constructor */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /* Elements */
    public synchronized WebElement getHeaderTextElement() {
        return driver.findElement(By.cssSelector(loginIdentifiers.get("headerCss").getAsString()));
    }

    public synchronized WebElement getUsernameFieldLabel() {
        return driver.findElement(By.xpath(loginIdentifiers.get("usernameLabelXpath").getAsString()));
    }

    public synchronized WebElement getPasswordFieldLabel() {
        return driver.findElement(By.xpath(loginIdentifiers.get("passwordFieldXpath").getAsString()));
    }

    public synchronized WebElement getUsernameField() {
        return driver.findElement(By.xpath(loginIdentifiers.get("usernameFieldXpath").getAsString()));
    }

    public synchronized WebElement getPassworField() {
        return driver.findElement(By.xpath(loginIdentifiers.get("passwordFieldXpath").getAsString()));
    }

    public synchronized WebElement getLoginButton() {
        return driver.findElement(By.xpath(loginIdentifiers.get("loginButtonXpath").getAsString()));
    }

    public synchronized WebElement getForgotPasswordLink() {
        return driver.findElement(By.xpath(loginIdentifiers.get("forgotPasswordLinkXpath").getAsString()));
    }

    /* Action */

    public synchronized void setUsername(String username) {
        getUsernameField().sendKeys(username);
    }

    public synchronized void setPassword(String password) {
        getPassworField().sendKeys(password);
    }

    public synchronized void clickOnLogin() {
        getLoginButton().click();
    }

    public static void main(String[] args) {
        System.out.println(loginIdentifiers.get("forgotPasswordLinkXpath").getAsString());
    }


}
