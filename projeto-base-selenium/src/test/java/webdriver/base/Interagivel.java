package webdriver.base;

import webdriver.componentes.*;

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

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


import static webdriver.componentes.Assertivas.obterMensagemAtual;
import static webdriver.fabrica.FabricaDeDriver.getDriver;

public abstract class Interagivel {

    public Interagivel() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
        PageFactory.initElements(factory, this);
    }

    public abstract void acessa();


    public String obterTituloDaPagina() {
        return getDriver().getTitle();
    }


    public void inserir() {
        esperaAjaxTerminar();
        clicar("mainForm:addButton");
    }

    public void alterar() {
        esperaAjaxTerminar();
        clicar("mainForm:editButton");
        esperaPor(1000);
    }

    public void excluir() {
        esperaAjaxTerminar();
        clicar("mainForm:removeButton");
        clicar("messageForm:painelMensagensConfirmDialogButton");
        String mensagem =  obterMensagemAtual("messageContent");
        Assert.assertTrue(mensagem.endsWith("sucesso."));

    }


    public void confirma() {
        esperaAjaxTerminar();
        clicar("mainForm:confirmButton");
        esperaPor(1000);
    }

    protected void confirmarDownload() {
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
        confirma();
        String mensagemEsperada = "Operação realizada com sucesso!";
        String mensagemEsperadaChaveDuplicada = "Valor da chave duplicado!";

        String mensagemAtual = obterMensagemAtual("messageContent");

        boolean mensagemCorreta = mensagemAtual.startsWith(mensagemEsperada) || mensagemAtual.startsWith(mensagemEsperadaChaveDuplicada);
        Assert.assertTrue("A mensagem atual não corresponde a nenhuma das mensagens esperadas.", mensagemCorreta);

        clicarBotaoOk();
    }


    protected void selectGrid(int index) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }

    protected void incluirSelecionados(WebElement el) {
        esperaAjaxTerminar();
        clicar(el);
    }


    protected void desmarcarTodods() {
        clicar("mainForm:functionPickList:excludeAll");

    }

    public Interagivel clicar(WebElement elemento) {
        rolarParaBaixoAteEncontrar(elemento);
        esperaAteElementoAparecerNaTela(elemento);
        elemento.click();
        return this;
    }

    protected void clicar(String id) {
        rolarParaBaixoAteEncontrar(id);
        new Espera().esperaElementoSerClicavel(id);
        new Botao().clicar(id);
    }

    protected void clicarBotaoOk() {
        esperaAjaxTerminar();
        clicar("messageForm:painelMensagensOkActionDialogButton");
        esperaPor(500);
    }

    protected void clicarForaDoCampo() {
        clicar("mainForm:headerTransacao");

    }

    protected Aba selecionaAba(WebElement elemento) {
        esperaAjaxTerminar();
        rolarParaCimaAteEncontrar(elemento);
        esperaPor(500);
        clicar(elemento);
        return null;
    }


    public Interagivel preenche(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        esperaAteElementoAparecerNaTela(elemento);
        if (elemento.isEnabled() || !elemento.equals("")) {
            new CampoTexto().preenche(elemento, valor);
            esperaTextoEstarPresente(elemento, valor);
            esperaAjaxTerminar();
        }
        return this;
    }


    public Interagivel preencheAutoComplete(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        preenche(elemento, valor);
        esperaTextoEstarPresente(elemento, valor);
        clicarForaDoCampo();
        return this;
    }

    public Interagivel preencheDevagar(WebElement elemento, String valor) {
        rolarParaBaixoAteEncontrar(elemento);
        esperaAteElementoAparecerNaTela(elemento);
        if (elemento.isEnabled() || !elemento.equals("")) {
        new CampoTexto().preencheDevagar(elemento, valor);
        esperaTextoEstarPresente(elemento, valor);
        clicarForaDoCampo();
        }
        return this;
    }


    public Interagivel selecionaUm(WebElement elemento, String valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        esperaAteElementoAparecerNaTela(elemento);
        if (elemento.isEnabled() || !elemento.equals("")) {
            new ComboBox().seleciona(elemento, valor);
        }
        return this;
    }


    public Interagivel selecionaVarios(WebElement elemento, String... valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        deselecionaTodos();
        esperaPor(1000);
        if (elemento.isEnabled() || !elemento.equals("")) {
            new ComboBox().selecionaVarios(elemento, valor);
            incluirSelecionados();
            esperaPor(2000);
        }
        return this;
    }

    public Interagivel selecionaVarios(WebElement elemento, WebElement incluir, String... valor) {
        esperaAjaxTerminar();
        rolarParaBaixoAteEncontrar(elemento);
        esperaPor(1000);
        if (elemento.isEnabled() || !elemento.equals("")) {
            new ComboBox().selecionaVarios(elemento, valor);
            incluir.click();
            esperaPor(500);
        }
        return this;
    }


    protected void deselecionaTodos() {
        new ComboBox().deselecionaTodos();
    }

    public void selecionaTodos() {
        new ComboBox().selecionaTodos();
    }

    protected void incluirSelecionados() {
        new ComboBox().incluirSelecionados();
    }

    public void selecionaChekBox(WebElement elemento, Boolean boleano) {
        rolarParaBaixoAteEncontrar(elemento);
        new CheckBox().seleciona(elemento, boleano);

    }

    public Interagivel selecionaNaGrid(int indice) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + indice + ":chk");
        clicarGrid();
        return this;
    }
    public Interagivel clicarGrid(){
        clicar("mainForm:filterDataTable:0:coluna_mnemonic");
        return this;
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

    public void validaMensagem(String texto, WebElement elemento) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElementValue(elemento, texto));
        Assert.assertEquals(texto, elemento.getText());
    }

    protected void esperaElementoSerClicavel(WebElement elemento) {
        new Espera().esperaElementoSerClicavel(elemento);
    }

    protected void esperaAjaxTerminar() {
        new Espera().esperaAjaxTerminar();
    }

    public Interagivel esperaPor(int mill) {
        new Espera().esperaPor(mill);
        return this;
    }

    protected void esperaTextoEstarPresente(WebElement elemento, String texto) {
        new Espera().esperaTextoEstarPresente(elemento, texto);
    }

    protected void esperaAteElementoAparecerNaTela(WebElement elemento) {
        new Espera().esperaAteElementoAparecerNaTela(elemento);
    }

    protected boolean verificaSeTextoEstaPresente(String texto) {
        return getDriver().getPageSource().contains(texto);
    }

    public void executarProcessamento(WebElement selecionaGrid) {
        confirma();
        rolarParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirma();
        String mensagemEsperada = "Processamento";
        String mensagemEsperadaDuploControle = "Existe(m) Pendência(s) de Duplo Controle";

        String mensagemAtual = new Assertivas().obterMensagemAtual("messageContent");
        boolean mensagemCorreta = mensagemAtual.startsWith(mensagemEsperada) || mensagemAtual.startsWith(mensagemEsperadaDuploControle);
        Assert.assertTrue("A mensagem atual não corresponde a nenhuma das mensagens esperadas.", mensagemCorreta);
        if (mensagemAtual.startsWith(mensagemEsperada)) {
            clicarBotaoOk();
        } else if (mensagemAtual.startsWith(mensagemEsperadaDuploControle)) {
            clicar("messageForm:painelMensagensConfirmDialogButton");
            clicarBotaoOk();
        }
    }


}

