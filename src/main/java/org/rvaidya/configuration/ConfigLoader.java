package org.rvaidya.configuration;

import org.rvaidya.utilities.PropertiesUtils;

import java.util.Properties;

public class ConfigLoader {

    private String appUrl;

    private String implicitWaitTimeOut;

    private String explicitWaitTimeOut;

    private String reportFolderName;

    private String reportName;

    public ConfigLoader() {
        Properties projectProperties = PropertiesUtils.getPropertiesFileInstance("src/main/resources/projectConfig.properties");
        this.appUrl = projectProperties.getProperty("URL");
        this.explicitWaitTimeOut = projectProperties.getProperty("explicitWaitTime");
        this.implicitWaitTimeOut = projectProperties.getProperty("implicitWaitTime");
        this.reportFolderName = projectProperties.getProperty("reportFolderName");
        this.reportName = projectProperties.getProperty("reportName");
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

    public String getReportFolderName() {
        return reportFolderName;
    }

    public String getReportName() {
        return reportName;
    }
}
