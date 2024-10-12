package org.rvaidya.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GetData {


    public synchronized static String fromPropertiesFile(String fileLocation, String key) {

        String data = null;
        Properties prop;

        File propertiesFile = new File(fileLocation);
        try {
            FileInputStream fis = new FileInputStream(propertiesFile);
            prop = new Properties();
            prop.load(fis);
            data = prop.getProperty(key);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception otherException) {
            otherException.printStackTrace();
        }
        return data;

    }
}
