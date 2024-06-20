package webdriver.componentes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class DSL {

    /********* TextField e TextArea ************/

    public void preenche(By by, String texto) {
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void preenche(String id_campo, String texto) {
        preenche(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    /********* Radio e Flag ************/

    public void selecionarRadio(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isRadioSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void selecionarCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckSelecionado(String id) {
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public void selecionarComboBox(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarComboBox(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorComboBox(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresComboBox(String id) {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int obterQuantidadeOpcoesComboBox(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcaoComboBox(String id, String opcao) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    /********* Interagivel
     * @return************/

    public void clicarBotao(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public void clicarBotaoLink(String link) {
        getDriver().findElement(By.className(link)).click();
    }

    public String obterValorDoElemento(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("valor");
    }

    /********* LinkText ************/

    public void clicarLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    /********* Text ************/

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    /********* Alertas ************/

    public String alertaObterTexto() {
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceita() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENega() {
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertaPreenche(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames e Janelas ************/

    public void entrarFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void sairFrame() {
        getDriver().switchTo().defaultContent();
    }

    public void trocarJanela(String id) {
        getDriver().switchTo().window(id);
    }

    /************** JS *********************/

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    public void encontraBotao(WebElement element) {
        executarJS("window.scrollBy(0,arguments[0])", element.getLocation().y);

    }

    /************** espera elemento *********************/

    public void esperaElementoAparecerNaTela() {
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void finalizaEspera() {
        getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

//    public void esperaAteElementoAparecerNaTela(String id) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
//    }

//    public void esperaAteElementoDesaparecerDaTela(String imgId) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 30,30);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(imgId)));
//    }

}
