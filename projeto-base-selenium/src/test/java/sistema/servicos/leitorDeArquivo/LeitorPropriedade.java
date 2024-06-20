package sistema.servicos.leitorDeArquivo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class LeitorPropriedade {
    private static Properties properties;

    static {
        URL resource = LeitorPropriedade.class.getClassLoader().getResource("config.propriedades");
        if (resource == null) {
            throw new RuntimeException("Arquivo config.propriedades não encontrado no classpath.");
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

    public static String getLogin() {
        return properties.getProperty("login");
    }

    public static String getSenha() {
        return properties.getProperty("senha");
    }
}

