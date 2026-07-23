package config;

import java.io.FileInputStream;
import java.util.Properties;

public class Configreader {

    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/testData/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Unable to find the config properties file", e);
        }

    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }

}
