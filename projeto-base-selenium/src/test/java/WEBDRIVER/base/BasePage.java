package WEBDRIVER.base;

import API.componente.*;
import WEBDRIVER.componentes.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;
import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public abstract class BasePage {

    public BasePage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
        PageFactory.initElements(factory, this);
    }
    public abstract void acessaPagina();

    public String obterTituloDaPagina() {
        return getDriver().getTitle();
    }


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
        Assert.assertEquals("1 remoção(ões) realizada(s) com sucesso.", new Assertivas().validaMensagem("messageContent"));
    }

    public void excluir(String nomeDoArquivo) {
        esperaAjaxTerminar();
        Botao b = new Botao();
        b.clicar("mainForm:removeButton");
        evidencia(nomeDoArquivo, "Teste-finalizado");
        b.clicar("messageForm:painelMensagensConfirmDialogButton");
        Assert.assertEquals("1 remoção(ões) realizada(s) com sucesso.", new Assertivas().validaMensagem("messageContent"));
    }

    public void confirmar() {
        esperaAjaxTerminar();
        new Botao().clicar("mainForm:confirmButton");
        esperaPor(1000);
    }

    public void confirmar(String nomeDoTeste) {
        esperaAjaxTerminar();
        evidencia(nomeDoTeste, "Teste-finalizado");
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
        confirmar();
        String mensagemEsperada = "Operação realizada com sucesso!";
        String mensagemAtual = new Assertivas().validaMensagem("messageContent");
        Assert.assertTrue(mensagemAtual.startsWith(mensagemEsperada));
        clicarBotaoOk();
    }

    public void confirmaOperacao(String nomeDoTeste) {
        esperaAjaxTerminar();
        confirmar();
        evidencia(nomeDoTeste, "Teste-finalizado");
        String mensagemEsperada = "Operação realizada com sucesso!";
        String mensagemAtual = new Assertivas().validaMensagem("messageContent");
        Assert.assertTrue(mensagemAtual.startsWith(mensagemEsperada));
        clicarBotaoOk();
    }

    protected void selectGrid(int index) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }

    protected void incluirSelecionados(WebElement el) {
        esperaAjaxTerminar();
        clicar(el);
    }

    protected void incluirSelecionados(String id) {
        esperaAjaxTerminar();
        clicar(id);
    }

    protected void desmarcarTodods() {
        new Botao().clicar("mainForm:functionPickList:excludeAll");

    }

    protected Click clicar(WebElement el) {
        rolarParaBaixoAteEncontrar(el);
        esperaElementoSerClicavel(el);
        new Botao().clicar(el);
        return null;
    }

    protected Click clicar(String id) {
        rolarParaBaixoAteEncontrar(id);
        esperaElementoSerClicavel(id);
        new Botao().clicar(id);
        return null;
    }

    protected void clicarBotaoOk() {
        esperaAjaxTerminar();
        new Botao().clicar("messageForm:painelMensagensOkActionDialogButton");
        esperaPor(500);
    }

    protected void clicarForaDoCampo() {
        esperaAjaxTerminar();
        new Botao().clicar("mainForm:headerTransacao");
    }

    protected Aba selecionaAba(WebElement elemento) {
        esperaAjaxTerminar();
        rolarParaCimaAteEncontrar(elemento);
        esperaPor(500);
        new Botao().clicar(elemento);
        return null;
    }

    protected Aba selecionaAba(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        esperaAjaxTerminar();
        rolarParaCimaAteEncontrar(elemento);
        esperaPor(500);
        new Botao().clicar(elemento);
        return null;
    }

    protected EntradaSimples preenche(WebElement elemento, String texto) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        if (elemento.isEnabled()) {
            new CampoTexto().preenche(elemento, texto);
            esperaTextoEstarPresente(elemento, texto);
        }
        return null;
    }

    protected EntradaSimples preenche(String id, String texto) {
        WebElement elemento = getDriver().findElement(By.id(id));
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        if (elemento.isEnabled()) {
            new CampoTexto().preenche(elemento, texto);
            esperaTextoEstarPresente(elemento, texto);

        }
        return null;
    }

    protected EntradaSimples preencheAutoComplete(String id, String texto) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(id);
        esperaElementoSerClicavel(id);
        new CampoTexto().preenche(id, texto);
        esperaTextoEstarPresente(id, texto);
        clicarForaDoCampo();
        esperaAjaxTerminar();
        return null;
    }

    protected EntradaSimples preencheAutoComplete(WebElement elemento, String texto) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        esperaElementoSerClicavel(elemento);
        if (elemento.isEnabled()) {
            new CampoTexto().preenche(elemento, texto);
            esperaTextoEstarPresente(elemento, texto);
            clicarForaDoCampo();
            esperaAjaxTerminar();
        }
        return null;
    }

    protected SelecionaUm selecionaUm(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        esperaElementoSerClicavel(elemento);
        if (elemento.isEnabled()) {
            new ComboBox().seleciona(elemento, valor);
        }
        return null;
    }

    protected SelecionaUm selecionaUm(String id, String valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(id);
        esperaElementoSerClicavel(id);
        new ComboBox().seleciona(id, valor);
        return null;
    }

    protected SelecionaVarios selecionaVarios(WebElement elemento, String... valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        deselecionaTodos();
        esperaPor(1000);
        new ComboBox().selecionaVarios(elemento, valor);
        incluirSelecionados();
        esperaPor(2000);
        return null;
    }

    protected SelecionaVarios selecionaVarios(WebElement elemento, WebElement incluir, String... valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        esperaPor(1000);
        new ComboBox().selecionaVarios(elemento, valor);
        incluir.click();
        esperaPor(500);
        return null;
    }

    protected String[] selecionaVarios(String id, String idIncluir, String... valor) {
        WebElement incluir = getDriver().findElement(By.id(idIncluir));
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(id);
        esperaPor(1000);
        new ComboBox().selecionaVarios(id, valor);
        incluir.click();
        esperaPor(500);
        return new String[0];
    }

    protected void deselecionaTodos() {
        By selector = By.cssSelector("[id$='excludeAll']");
        WebElement elemento = getDriver().findElement(selector);
        elemento.click();
    }

    protected void incluirSelecionados() {
        By selector = By.cssSelector("[id$='includeSelected']");
        WebElement elemento = getDriver().findElement(selector);
        elemento.click();
    }

    protected boolean selecionaChekBox(WebElement chk, Boolean boleano) {
        rolarParaBaixoAteEncontrar(chk);
        new CheckBox().seleciona(chk, boleano);
        return false;
    }

    protected void selecionaNaGrid(int index) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }


    protected void rolarParaBaixo() {
        new JS().executarScript("window.scrollTo(0, document.documentElement.scrollHeight)");
    }

    protected void scrollToSpecificPoint(int yOffset) {
        new JS().executarScript("window.scrollTo(0, " + yOffset + ")");
    }

    protected void rolarParaBaixoAteEncontrar(WebElement elemento) {
        esperaAjaxTerminar();
        esperaPor(500);
        new JS().executarScript("arguments[0].scrollIntoView(true);", elemento);
    }

    protected void rolarParaBaixoAteEncontrar(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        esperaAjaxTerminar();
        esperaPor(500);
        new JS().executarScript("arguments[0].scrollIntoView(true);", elemento);
    }

    protected void rolarParaCimaAteEncontrar(WebElement elemento) {
        esperaAjaxTerminar();
        new JS().executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().y++);
        esperaPor(500);
    }


    protected void rolarParaCimaAteEncontrar(String id) {
        WebElement elemento = getDriver().findElement(By.id(id));
        esperaAjaxTerminar();
        new JS().executarScript("window.scrollBy(0,arguments[0])", elemento.getLocation().y++);
    }

    public void validaMensagem(String texto, WebElement elemento) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        Assert.assertEquals(texto, elemento.getText());
    }

    protected void esperaElementoSerClicavel(WebElement elemento) {
        new Espera().esperaElementoSerClicavel(elemento);
    }

    protected void esperaElementoSerClicavel(String id) {
        new Espera().esperaElementoSerClicavel(id);
    }

    protected void esperaAjaxTerminar() {
        new Espera().esperaAjaxTerminar();
    }

    protected void esperaPor(int mill) {
        new Espera().esperaPor(mill);
    }

    protected void esperaTextoEstarPresente(WebElement elemento, String texto) {
        new Espera().esperaTextoEstarPresente(elemento, texto);
    }

    protected void esperaTextoEstarPresente(String id, String texto) {
        new Espera().esperaTextoEstarPresente(id, texto);
    }

    protected boolean verificaSeTextoEstaPresente(String texto) {
        return getDriver().getPageSource().contains(texto);
    }

    public void executarProcessamento(WebElement selecionaGrid, String processamento) {
        confirmar();
        rolarParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirmar();
        evidencia(processamento, "teste-finalizado");
        clicarBotaoOk();
    }

    public void executarProcessamento(String selecionaGrid, String processamento) {
        confirmar();
        rolarParaBaixoAteEncontrar(selecionaGrid);
        clicar(selecionaGrid);
        confirmar();
        evidencia(processamento, "teste-finalizado");
        clicarBotaoOk();
    }


}
//    public BasePage() {
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
//        PageFactory.initElements(factory, this);
//    }
//
//    public String obterTituloDaPagina() {
//        return getDriver().getTitle();
//    }
//
//    public void inserir() {
//        new BasePage().inserir();
//    }
//
//    public void alterar() {
//        new BasePage().alterar();
//    }
//
//    public void excluir() {
//        new BasePage().excluir();
//    }
//
//    public void excluir(String nomeDoArquivo) {
//        new BasePage().excluir(nomeDoArquivo);
//    }
//
//    public void confirmar() {
//        new BasePage().confirmar();
//    }
//
//    public void confirmar(String nomeDoTeste) {
//        new BasePage().confirmar(nomeDoTeste);
//    }
//
//    public void confirmarDownload() {
//        new BasePage().confirmarDownload();
//    }
//
//    public void confirmaOperacao() {
//        new BasePage().confirmaOperacao();
//    }
//
//    public void confirmaOperacao(String nomeDoArquivo) {
//        new BasePage().confirmaOperacao(nomeDoArquivo);
//    }
//
//    public void executarProcessamento(WebElement selecinaGrid, String processmento) {
//        new BasePage().executarProcessamento(selecinaGrid, processmento);
//    }
//
//    public void executarProcessamento(String selecinaGrid, String processmento) {
//        new BasePage().executarProcessamento(selecinaGrid, processmento);
//    }
//
//    protected void clicarBotaoOk() {
//        new BasePage().clicarBotaoOk();
//    }
//
//    protected void esperaElementoSerClicavel(WebElement elemento) {
//        new BasePage().esperaElementoSerClicavel(elemento);
//    }
//
//    protected void esperaElementoSerClicavel(String id) {
//        new BasePage().esperaElementoSerClicavel(id);
//    }
//
//    protected void esperaPor(int miliSegundos) {
//        new BasePage().esperaPor(miliSegundos);
//    }
//
//    protected EntradaSimples preenche(WebElement input, String texto) {
//        new BasePage().preenche(input, texto);
//        return null;
//    }
//
//    protected EntradaSimples preenche(String id, String texto) {
//        new BasePage().preenche(id, texto);
//        return null;
//    }
//
//    protected EntradaSimples preencheAutoComplete(WebElement input, String texto) {
//        new BasePage().preencheAutoComplete(input, texto);
//        return null;
//    }
//
//    protected EntradaSimples preencheAutoComplete(String id, String texto) {
//        new BasePage().preencheAutoComplete(id, texto);
//        return null;
//    }
//
//    protected SelecionaUm selecionaUm(WebElement elemento, String valor) {
//        new BasePage().selecionaUm(elemento, valor);
//        return null;
//    }
//
//    protected SelecionaUm selecionaUm(String id, String valor) {
//        new BasePage().selecionaUm(id, valor);
//        return null;
//    }
//
//    protected SelecionaVarios selecionaVarios(WebElement elemento, String... valores) {
//        new BasePage().selecionaVarios(elemento, valores);
//        return null;
//    }
//
//
//    protected SelecionaVarios selecionaVarios(WebElement elemento, WebElement incluir, String... valores) {
//        new BasePage().selecionaVarios(elemento, incluir, valores);
//        return null;
//    }
//
//    protected SelecionaVarios selecionaVarios(String id, String incluir, String... valores) {
//        new BasePage().selecionaVarios(id, incluir, valores);
//        return null;
//    }
//
//
//    protected void selecionaNaGrid(int index) {
//        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
//    }
//
//
//    protected void selecionaChekBox(WebElement chk, boolean boleano) {
//        new BasePage().selecionaChekBox(chk, boleano);
//    }
//
//    protected Click clicar(WebElement el) {
//        new BasePage().clicar(el);
//        return null;
//    }
//
//    protected Click clicar(String id) {
//        new BasePage().clicar(id);
//        return null;
//    }
//
//    protected Aba selecionaAba(WebElement nomeAba) {
//        new BasePage().selecionaAba(nomeAba);
//        return null;
//    }
//
//    protected Aba selecionaAba(String nomeAba) {
//        new BasePage().selecionaAba(nomeAba);
//        return null;
//    }
//
//    protected void rolarParaBaixoAteEncontrar(WebElement elemento) {
//        new BasePage().rolarParaBaixoAteEncontrar(elemento);
//    }
//
//    protected void rolarParaBaixoAteEncontrar(String id) {
//        new BasePage().rolarParaBaixoAteEncontrar(id);
//    }
//
//    protected void scrollParaCimaAteEncontrar(WebElement elemento) {
//        new BasePage().rolarParaCimaAteEncontrar(elemento);
//    }
//
//    public void validaMensagem(String msg, WebElement elemento) {
//        new BasePage().validaMensagem(msg, elemento);
//    }
//
//}

