package WEBDRIVER.config.menu.painel_acoes;

import API.componente.Aba;
import API.componente.SelecionaUm;
import WEBDRIVER.componentes.*;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public class AcaoMenu {
    public void inserir() {
        esperaAjaxTerminar();
        new Botao().clicar("mainForm:addButton");
    }

    public void alterar() {
        esperaAjaxTerminar();
        new Botao().clicar("mainForm:editButton");
        new Espera().esperaPor(1000);
    }

    public void excluir() {
        esperaAjaxTerminar();
        Botao b = new Botao();
        b.clicar("mainForm:removeButton");
        b.clicar("messageForm:painelMensagensConfirmDialogButton");
        Assert.assertEquals("1 remoção(ões) realizada(s) com sucesso.", new ResultadoMensagem().validaMensagem("messageContent"));
    }

    public void confirmar() {
        esperaAjaxTerminar();
        new Botao().clicar("mainForm:confirmButton");
        esperaPor(1000);
    }

    public void confirmarDownload() {
        esperaAjaxTerminar();
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
        esperaAjaxTerminar();
        confirmar();

        String mensagemEsperada = "Operação realizada com sucesso!";
        String mensagemAtual = new ResultadoMensagem().validaMensagem("messageContent");

        Assert.assertTrue(mensagemAtual.startsWith(mensagemEsperada));

        clicarBotaoOk();
    }

    public void selectGrid(int index) {

        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }

    public void incluirSelecionados(WebElement el) {
        esperaAjaxTerminar();
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
        esperaAjaxTerminar();
        new Botao().clicar("messageForm:painelMensagensOkActionDialogButton");
        esperaPor(500);
    }

    private void clicarForaDoCampo() {
        esperaAjaxTerminar();
        new Botao().clicar("mainForm:headerTransacao");
    }

    public Aba selecionaAba(WebElement elemento) {
        esperaAjaxTerminar();
        scrollParaCimaAteEncontrar(elemento);
        esperaPor(500);
        elemento.click();
        return null;
    }

    public AcaoMenu preenche(WebElement input, String texto) {
        esperaAjaxTerminar();
        scrollParaBaixoAteEncontrar(input);
        if (input.isEnabled()) {
            new PreencheDados().preenche(input, texto);
            espereOTextoEstarPresente(input, texto);
        }
        return this;
    }

    public AcaoMenu preencheAutoComplete(WebElement input, String texto) {
        esperaAjaxTerminar();
        scrollParaBaixoAteEncontrar(input);
        esperaElementoSerClicavel(input);
        if (input.isEnabled()) {
            new PreencheDados().preenche(input, texto);
            espereOTextoEstarPresente(input, texto);
            clicarForaDoCampo();
        }
        return this;
    }

    public SelecionaUm selecionaUm(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        scrollParaBaixoAteEncontrar(elemento);
        esperaElementoSerClicavel(elemento);
        if (elemento.isEnabled()) {
            new ComboBox().seleciona(elemento, valor);
        }
        return null;
    }

    public String[] selecionaVarios(WebElement elemento, WebElement incluir, String... valor) {
        scrollParaBaixoAteEncontrar(elemento);
        new ComboBox().selecionaVarios(elemento, valor);
        incluirSelecionados(incluir);
        esperaAjaxTerminar();
        esperaPor(500);
        return new String[0];
    }

    public boolean selecionaChekBox(WebElement chk, Boolean aBoolean) {
        scrollParaBaixoAteEncontrar(chk);
        new CheckBox().seleciona(chk, aBoolean);

        return false;
    }

    public void scrollParaBaixo() {
        new JS().executarScript("window.scrollTo(0, document.documentElement.scrollHeight)");
    }

    public void scrollToSpecificPoint(int yOffset) {
        new JS().executarScript("window.scrollTo(0, " + yOffset + ")");
    }

    public void scrollParaBaixoAteEncontrar(WebElement elemento) {
        esperaAjaxTerminar();
        esperaPor(500);
        new JS().executarScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void scrollParaCimaAteEncontrar(WebElement elemento) {
        esperaAjaxTerminar();
        new JS().executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().y++);
    }

    public void validaMensagem(String texto, WebElement input) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElementValue(input, texto));
        Assert.assertEquals(texto, input.getText());
    }

    public void esperaElementoSerClicavel(WebElement elemento) {
        new WebDriverWait(getDriver(), 15).until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public ExpectedCondition<Boolean> esperaAjaxTerminar() {
//        esperaPor(500);
//        WebElement ajax = getDriver().findElement(By.id("j_id__v_0:javax.faces.ViewState:2"));
//        new WebDriverWait(getDriver(), 15)
//                .until(ExpectedConditions.invisibilityOf(ajax));


        return new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver d) {
                WebElement element = d.findElement(By.className("rf-st-start"));
                WebElement element2 = d.findElement(By.id("j_id__v_0:javax.faces.ViewState:2"));
                if (element.isDisplayed() && element2.isDisplayed()) {
                    return (boolean) ((JavascriptExecutor) d).executeScript("return jQuery.active == 0;") & Boolean.FALSE;
                }
                return (boolean) ((JavascriptExecutor) d).executeScript("return jQuery.active == 0;") & Boolean.TRUE;
            }
        };


    }

    public void esperaPor(int mill) {
        try {
            new Thread().sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement espereOTextoEstarPresente(WebElement elemento, String texto) {
        new JS().executarScript("arguments[0].value = arguments[1];", elemento, texto);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        if (texto.equals(elemento.getAttribute("value"))) {
            return elemento;
        }
        return null;
    }

    public boolean verificaSeTextoEstaPresente(String texto) {
        return getDriver().getPageSource().contains(texto);
    }

}
