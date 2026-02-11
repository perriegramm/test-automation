package framework.config;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found in test resources");
            }

            PROPERTIES.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        return Objects.requireNonNull(
                PROPERTIES.getProperty(key),
                "Property not found: " + key
        );
    }
}
