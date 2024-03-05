package WEBDRIVER.base.basePage;

import API.componente.*;
import WEBDRIVER.componentes.CheckBox;
import WEBDRIVER.config.menu.painel_acoes.AcaoMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public abstract class BasePage {
    public BasePage() {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
        PageFactory.initElements(factory, this);
    }

    public String obterTituloDaPagina() {
        return getDriver().getTitle();
    }

    public void inserir() {
        new AcaoMenu().inserir();
    }

    public void alterar() {
        new AcaoMenu().alterar();
    }

    public void excluir() {
        new AcaoMenu().excluir();
    }

    public void excluir(String nomeDoArquivo) {
        new AcaoMenu().excluir(nomeDoArquivo);
    }

    public void confirmar() {
        new AcaoMenu().confirmar();
    }

    public void confirmar(String nomeDoTeste) {
        new AcaoMenu().confirmar(nomeDoTeste);
    }

    public void confirmarDownload() {
        new AcaoMenu().confirmarDownload();
    }

    public void confirmaOperacao() {
        new AcaoMenu().confirmaOperacao();
    }

    public void confirmaOperacao(String nomeDoArquivo) {
        new AcaoMenu().confirmaOperacao(nomeDoArquivo);
    }

    public void executarProcessamento(WebElement selecinaGrid, String processmento) {
        new AcaoMenu().executarProcessamento(selecinaGrid, processmento);
    }

    public void executarProcessamento(String selecinaGrid, String processmento) {
        new AcaoMenu().executarProcessamento(selecinaGrid, processmento);
    }

    protected void clicarBotaoOk() {
        new AcaoMenu().clicarBotaoOk();
    }

    protected void esperaElementoSerClicavel(WebElement elemento) {
        new AcaoMenu().esperaElementoSerClicavel(elemento);
    }

    protected void esperaElementoSerClicavel(String id) {
        new AcaoMenu().esperaElementoSerClicavel(id);
    }

    protected void esperaPor(int miliSegundos) {
        new AcaoMenu().esperaPor(miliSegundos);
    }

    protected EntradaSimples preenche(WebElement input, String texto) {
        new AcaoMenu().preenche(input, texto);
        return null;
    }

    protected EntradaSimples preenche(String id, String texto) {
        new AcaoMenu().preenche(id, texto);
        return null;
    }

    protected EntradaSimples preencheAutoComplete(WebElement input, String texto) {
        new AcaoMenu().preencheAutoComplete(input, texto);
        return null;
    }

    protected EntradaSimples preencheAutoComplete(String id, String texto) {
        new AcaoMenu().preencheAutoComplete(id, texto);
        return null;
    }

    protected SelecionaUm selecionaUm(WebElement elemento, String valor) {
        new AcaoMenu().selecionaUm(elemento, valor);
        return null;
    }

    protected SelecionaUm selecionaUm(String id, String valor) {
        new AcaoMenu().selecionaUm(id, valor);
        return null;
    }

    protected SelecionaVarios selecionaVarios(WebElement elemento, String... valores) {
        new AcaoMenu().selecionaVarios(elemento, valores);
        return null;
    }


    protected SelecionaVarios selecionaVarios(WebElement elemento, WebElement incluir, String... valores) {
        new AcaoMenu().selecionaVarios(elemento, incluir, valores);
        return null;
    }

    protected SelecionaVarios selecionaVarios(String id, String incluir, String... valores) {
        new AcaoMenu().selecionaVarios(id, incluir, valores);
        return null;
    }


    protected void selecionaNaGrid(int index) {
        new CheckBox().seleciona("mainForm:filterDataTable:" + index + ":chk");
    }


    protected void selecionaChekBox(WebElement chk, boolean boleano) {
        new AcaoMenu().selecionaChekBox(chk, boleano);
    }

    protected Click clicar(WebElement el) {
        new AcaoMenu().clicar(el);
        return null;
    }

    protected Click clicar(String id) {
        new AcaoMenu().clicar(id);
        return null;
    }

    protected Aba selecionaAba(WebElement nomeAba) {
        new AcaoMenu().selecionaAba(nomeAba);
        return null;
    }

    protected Aba selecionaAba(String nomeAba) {
        new AcaoMenu().selecionaAba(nomeAba);
        return null;
    }

    protected void rolarParaBaixoAteEncontrar(WebElement elemento) {
        new AcaoMenu().rolarParaBaixoAteEncontrar(elemento);
    }

    protected void rolarParaBaixoAteEncontrar(String id) {
        new AcaoMenu().rolarParaBaixoAteEncontrar(id);
    }

    protected void scrollParaCimaAteEncontrar(WebElement elemento) {
        new AcaoMenu().rolarParaCimaAteEncontrar(elemento);
    }

    public void validaMensagem(String msg, WebElement elemento) {
        new AcaoMenu().validaMensagem(msg, elemento);
    }

}

