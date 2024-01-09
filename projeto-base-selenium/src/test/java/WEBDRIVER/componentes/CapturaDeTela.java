package WEBDRIVER.componentes;


import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class CapturaDeTela {

    @Rule
    public static TestName testName = new TestName();

    public static void evidencia() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        BufferedImage image = robot.createScreenCapture(new Rectangle(1230, 550));
        try {
            ImageIO.write(image, "jpg", new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Rule
    public static TestName nomeTeste = new TestName();

    public static void capturaScreenshot() {
        try {
            File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(screenshotFile, new File("target" + File.separator + "screenshot" + File.separator + nomeTeste.getMethodName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void evidencia(String nomeDoArquivo, String nomeDoTeste) {
        WebDriver driver = getDriver();
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File fonte = ts.getScreenshotAs(OutputType.FILE);

            // Caminho do diretório único para cada teste
            String diretorioDestino = "target" + File.separator + "evidencias" + File.separator + nomeDoArquivo + File.separator;

            // Cria o diretório se ele não existir
            File diretorio = new File(diretorioDestino);
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }

            File destino = new File(diretorioDestino + nomeDoTeste + ".png");

            try {
                FileUtils.copyFile(fonte, destino);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





    public static void main(String[] args) {
        // Configurar o WebDriver (neste caso, para o Chrome)
        System.setProperty("webdriver.chrome.driver", "C:\\caminho\\para\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Abrir Leitor página da web desejada
        driver.get("https://exemplo.com");

        // Capturar Leitor tela e salvar
        capturaScreenshot();

        // Fechar o navegador
        driver.quit();
    }
}
