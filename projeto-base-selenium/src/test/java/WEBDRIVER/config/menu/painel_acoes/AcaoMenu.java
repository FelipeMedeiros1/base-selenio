package WEBDRIVER.config.menu.painel_acoes;

import API.componente.Aba;
import WEBDRIVER.componentes.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class AcaoMenu {
    public void inserir() {
        espereAteOElementoFicarInvisivel();
        new Botao().clicar("mainForm:addButton");
    }

    public void alterar() {
        espereAteOElementoFicarInvisivel();
        new Botao().clicar("mainForm:editButton");
        new Espera().esperaPor(1000);
    }

    public void excluir() {
        espereAteOElementoFicarInvisivel();
        Botao b = new Botao();
        b.clicar("mainForm:removeButton");
        b.clicar("messageForm:painelMensagensConfirmDialogButton");
        Assert.assertEquals("1 remoção(ões) realizada(s) com sucesso.", new ResultadoMensagem().validaMensagem("messageContent"));
    }

    public void confirmar() {
        espereAteOElementoFicarInvisivel();
        new Botao().clicar("mainForm:confirmButton");
        esperaPor(1000);
    }
    public void confirmarDownload() {
        espereAteOElementoFicarInvisivel();
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("arquivos-gerados", "C:\\Projetos\\ws_robo\\projeto-base-selenium\\target");
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        WebElement linkDownload = driver.findElement(By.id("mainForm:confirmButton"));
        linkDownload.click();
        esperaPor(1000);


    }

    public void confirmaOperacao() {
        espereAteOElementoFicarInvisivel();
        confirmar();
        Assert.assertEquals("Operação realizada com sucesso!", new ResultadoMensagem().validaMensagem("messageContent"));
        clicarBotaoOk();
    }

    public void selectGrid(int index) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }

    public void incluirSelecionados(WebElement el) {
        espereAteOElementoFicarInvisivel();
        clicar(el);
    }

    public void desmarqueTodods() {
        new Botao().clicar("mainForm:functionPickList:excludeAll");
    }

    public void clicar(WebElement el) {
        esperaElementoSerClicavel(el);
        new Botao().clicar(el);
    }

    public void clicarBotaoOk() {
        espereAteOElementoFicarInvisivel();
        new Botao().clicar("messageForm:painelMensagensOkActionDialogButton");
        esperaPor(500);
    }

    public Aba selecionaAba(WebElement elemento) {
        espereAteOElementoFicarInvisivel();
        scrollParaCimaAteEncontrar(elemento);
        esperaPor(1000);
        elemento.click();
        return null;
    }


    public AcaoMenu preenche(WebElement input, String texto) {
        scrollParaBaixoAteEncontrar(input);
        espereAteOElementoFicarInvisivel();
        if (input.isEnabled()) {
            input.clear();
            esperaPor(500);
            input.sendKeys(texto);
            espereOTextoEstarPresente(input, texto);
        }
        return this;
    }

    public AcaoMenu preencheAutoComplete(WebElement input, String text) {
        scrollParaBaixoAteEncontrar(input);
        espereAteOElementoFicarInvisivel();
        esperaElementoSerClicavel(input);
        if (input.isEnabled()) {
            input.clear();
            input.sendKeys(text.trim());
            espereOTextoEstarPresente(input, text);
            inserir();
        }
        return this;
    }

    public AcaoMenu selecionaUm(WebElement element, String value) {
        scrollParaBaixoAteEncontrar(element);
        espereAteOElementoFicarInvisivel();
        esperaElementoSerClicavel(element);
        if (element.isEnabled()) {
            new ComboBox().seleciona(element, value);
            esperaPor(1000);
        }
        return this;
    }

    public String[] selecionaVarios(WebElement element, WebElement include, String... values) {
        scrollParaBaixoAteEncontrar(element);
        espereAteOElementoFicarInvisivel();
        if (element.isEnabled()) {
            esperaElementoSerClicavel(element);
            element.click();
            Select combo = new Select(element);

            combo.deselectAll();
            new Actions(getDriver()).keyDown(Keys.CONTROL);

            for (String value : values) {
                combo.selectByVisibleText(value);
            }
            incluirSelecionados(include);
            esperaPor(1000);
        }
        return values;
    }

    public boolean selecionaChekBox(WebElement chk, Boolean bool) {
        scrollParaBaixoAteEncontrar(chk);
        if (bool == true) {
            espereAteOElementoFicarInvisivel();
            if (!chk.isSelected()) {
                chk.click();
            }
        }
        if (bool == false) {
            espereAteOElementoFicarInvisivel();
            if (chk.isSelected()) {
                chk.click();
            }
        }
        esperaPor(1000);
        return false;
    }

    public void scrollParaBaixo() {
        new JS().executarScript("window.scrollTo(0, document.documentElement.scrollHeight)");
    }

    public void scrollToSpecificPoint(int yOffset) {
        new JS().executarScript("window.scrollTo(0, " + yOffset + ")");
    }

    public void scrollParaBaixoAteEncontrar(WebElement elemento) {
        espereAteOElementoFicarInvisivel();
        esperaPor(500);
        new JS().executarScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void scrollParaCimaAteEncontrar(WebElement elemento) {
        espereAteOElementoFicarInvisivel();
        new JS().executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().y++);
    }

    public void validaMensagem(String texto, WebElement input) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElementValue(input, texto));
        Assert.assertEquals(texto, input.getText());
    }

    public void esperaElementoSerClicavel(WebElement elemento) {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public void espereAteOElementoFicarInvisivel() {
        new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("mensagemAguarde")));
    }

    public void esperaPor(int mill) {
        try {
            new Thread().sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void espereOTextoEstarPresente(WebElement elemento, String texto) {
        new JS().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
    }

}
