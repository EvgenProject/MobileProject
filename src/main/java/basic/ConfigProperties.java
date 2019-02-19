package basic;

import java.net.URL;
import java.util.Properties;

public class ConfigProperties {

    private static Properties PROPERTIES = null;

    static {
        PROPERTIES = new Properties();
        URL props = java.lang.ClassLoader.getSystemResource("application.properties");
    }
}
