package com.cydeo.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {
            FileInputStream inputStream = new FileInputStream("configuration.properties");

            properties.load(inputStream);

            inputStream.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error occured while reading configuration file");
        }
    }

    public static String getProperty(String key) {
        /**
         * Method is used to read value from a configuration.properties file
         * @param key -> key name in properties file
         * @return -> value for the key. returns null if key not found
         * EX: driver.get( ConfigurationReader.getProperty("url") ) ;
         */
        return properties.getProperty(key);
    }
}
