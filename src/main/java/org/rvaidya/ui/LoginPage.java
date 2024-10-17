package org.rvaidya.ui;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.rvaidya.utilities.jsonUtilities.JsonFile;

public class LoginPage {
    WebDriver driver;
    JsonObject loginIdentifiers = JsonFile.getJsonFileObject("src/main/resources/loginIdentifiers.json");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.xpath(loginIdentifiers.get("usernameFieldXpath").toString()));
    }


}
