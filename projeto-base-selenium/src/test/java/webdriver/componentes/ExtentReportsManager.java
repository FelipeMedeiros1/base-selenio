package webdriver.componentes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class ExtentReportsManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static String diretorioDestino = "target/evidencias/";

    public static void initializeReports() {
        // Cria o diretório se não existir
        File reportDir = new File(diretorioDestino);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        // Configura o ExtentReportsManager
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(diretorioDestino + "/extentReport.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Extent Reports");
        htmlReporter.config().setReportName("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    private static void addScreenshot(String titulo) {
        try {
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotPath = diretorioDestino + "/" + titulo + ".png";
            Files.copy(screenshot.toPath(), Paths.get(screenshotPath), StandardCopyOption.REPLACE_EXISTING);

            // Adiciona a imagem ao relatório
            test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logSucesso(String titulo, String mensagem) {
        test.pass(mensagem, MediaEntityBuilder.createScreenCaptureFromPath(diretorioDestino + "/" + titulo + ".png").build());
    }

    public static void logFalhou(String titulo, String mensagem) {
        test.fail(mensagem, MediaEntityBuilder.createScreenCaptureFromPath(diretorioDestino + "/" + titulo + ".png").build());
    }

    public static void logInfo(String titulo, String mensagem) {
        test.info(mensagem, MediaEntityBuilder.createScreenCaptureFromPath(diretorioDestino + "/" + titulo + ".png").build());
    }

    public static void logAlerta(String titulo, String mensagem) {
        test.warning(mensagem, MediaEntityBuilder.createScreenCaptureFromPath(diretorioDestino + "/" + titulo + ".png").build());
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}