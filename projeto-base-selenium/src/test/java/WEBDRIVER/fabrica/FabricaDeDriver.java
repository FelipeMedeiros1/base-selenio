package WEBDRIVER.fabrica;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  FabricaDeDriver {
//    private static WebDriver driver;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){

        protected synchronized WebDriver initialValue(){
            return iniciaDriver();
        }
    };
    private FabricaDeDriver() {}

    public static WebDriver getDriver(){
        return threadDriver.get();

    }


    public static WebDriver iniciaDriver() {
        WebDriver driver =null;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void finalizarDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (threadDriver != null){
            threadDriver.remove();
        }
    }
}
