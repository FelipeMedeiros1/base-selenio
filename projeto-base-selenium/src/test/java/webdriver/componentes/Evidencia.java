package webdriver.componentes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static webdriver.fabrica.FabricaDeDriver.getDriver;


public class Evidencia {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> teste = new ThreadLocal<>();

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extentreport.html");
            sparkReporter.config().setTheme(Theme.DARK);
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static void logSucesso(String titulo, String memssagem) {


        teste.get().pass(memssagem);

    }

    public static void logFalhou(String titulo, String memssagem) {


        teste.get().fail(memssagem);

    }

    public static void logInfo(String titulo, String memssagem) {

        teste.get().info(memssagem);

    }

    public static void logAlerta(String titulo, String memssagem) {


        teste.get().warning(memssagem);

    }
    public static void nomeDoTeste(String titulo) {
        teste.set(getExtentReports().createTest(titulo));
    }



    public static void adicionarImagem1(String titulo) {
        if (getDriver() instanceof TakesScreenshot) {
            try {
                // Captura a imagem como um arquivo
                File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

                // Converte o arquivo para Base64 usando FileUtils
                byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);
                String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
                teste.get().addScreenCaptureFromBase64String(titulo, base64Screenshot);
            } catch (IOException e) {
                System.err.println("Erro ao converter imagem para Base64: " + e.getMessage());
            }
        }
    }

    public static void adicionarImagem2(String titulo) {
        if (getDriver() instanceof TakesScreenshot) {
            try {
                // Captura a imagem como um arquivo
                File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

                // Lê a imagem como BufferedImage
                BufferedImage screenshotImage = ImageIO.read(screenshotFile);

                // Converte a imagem para Base64
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(screenshotImage, "png", baos); // Escreve a imagem como PNG
                byte[] screenshotBytes = baos.toByteArray();
                String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
                teste.get().addScreenCaptureFromBase64String(titulo, base64Screenshot);
            } catch (IOException e) {
                System.err.println("Erro ao converter imagem para Base64: " + e.getMessage());
            }
        }
    }
    public static void capturarImagem(String titulo) {
        if (getDriver() instanceof TakesScreenshot) {
            try {
                // Captura a imagem como um array de bytes
                byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                String base64Screenshot = Base64.getEncoder().encodeToString(screenshotBytes);
                teste.get().addScreenCaptureFromBase64String(titulo, base64Screenshot);
            } catch (Exception e) {
                System.err.println("Erro ao converter imagem para Base64: " + e.getMessage());
            }
        }
    }
    public static void liberarRelatorio() {
        extent.flush();
    }
}

