package org.rvaidya.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

    public synchronized static Properties getPropertiesFileInstance(String fileLocation) {
        Properties properties = null;

        File requiredFile = new File(fileLocation);
        try {
            FileInputStream fileInputStream = new FileInputStream(requiredFile);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public synchronized static String getValueForKey(String fileLocation, String key) {

        String data = null;
        try {
            Properties prop = getPropertiesFileInstance(fileLocation);
            data = prop.getProperty(key);

        } catch (Exception otherException) {
            otherException.printStackTrace();
        }
        return data;

    }


}
