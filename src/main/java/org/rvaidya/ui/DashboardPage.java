package org.rvaidya.ui;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.rvaidya.utilities.jsonUtilities.JsonFile;

public class DashboardPage {
    WebDriver driver;
    static JsonObject dashboardIdentifiers = JsonFile.getJsonFileObject("src/main/resources/dashboardIdentifiers.json");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUpgradeButton() {
        return driver.findElement(By.xpath(dashboardIdentifiers.get("upgradeButtonXpath").getAsString()));

    }

    public WebElement getUserProfileDropdown() {
        return driver.findElement(By.xpath(dashboardIdentifiers.get("userProfileDropdownXpath").getAsString()));
    }

    public WebElement getUserLogout() {
        return driver.findElement(By.linkText("Logout"));
    }

}
