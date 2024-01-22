package SISTEMA.propriedades.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        URL resource = ConfigReader.class.getClassLoader().getResource("config.properties");
        if (resource == null) {
            throw new RuntimeException("Arquivo config.properties não encontrado no classpath.");
        }

        try (InputStream input = new FileInputStream(resource.getFile())) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getEmail() {
        return properties.getProperty("email");
    }

    public static String getSenha() {
        return properties.getProperty("senha");
    }
}

