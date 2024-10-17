package org.rvaidya.utilities;

import java.util.Properties;

public class ConfigLoader {

    private String appUrl;

    private String implicitWaitTimeOut;

    private String explicitWaitTimeOut;

    public ConfigLoader() {
        Properties projectProperties = PropertiesUtils.getPropertiesFileInstance("src/main/resources/projectConfig.properties");
        this.appUrl = projectProperties.getProperty("URL");
        this.explicitWaitTimeOut = projectProperties.getProperty("explicitWaitTime");
        this.implicitWaitTimeOut = projectProperties.getProperty("implicitWaitTime");
    }

    public String getAppUrl() {
        return appUrl;
    }

    public String getImplicitWaitTimeOut() {
        return implicitWaitTimeOut;
    }

    public String getExplicitWaitTimeOut() {
        return explicitWaitTimeOut;
    }
}
