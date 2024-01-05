package WEBDRIVER.base.basePage;

import API.componente.*;
import WEBDRIVER.componentes.CheckBox;
import WEBDRIVER.config.menu.painel_acoes.AcaoMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static WEBDRIVER.fabrica.FabricaDeDriver.getDriver;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
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

    public void confirmar() {
        new AcaoMenu().confirmar();
    }

    public void confirmarDownload() {
        new AcaoMenu().confirmarDownload();
    }

    public void confirmaOperacao() {
        new AcaoMenu().confirmaOperacao();
    }

    protected void clicarBotaoOk() {
        new AcaoMenu().clicarBotaoOk();
    }

    protected void esperaElementoSerClicavel(WebElement elemento) {
        new AcaoMenu().esperaElementoSerClicavel(elemento);
    }

    protected void esperaPor(int miliSegundos) {
        new AcaoMenu().esperaPor(miliSegundos);
    }

    protected EntradaSimples preenche(WebElement input, String texto) {
        new AcaoMenu().preenche(input, texto);
        return null;
    }

    protected EntradaSimples preencheAutoComplete(WebElement input, String texto) {
        new AcaoMenu().preencheAutoComplete(input, texto);
        return null;
    }

    protected SelecionaUm selecionaUm(WebElement elemento, String valor) {
        new AcaoMenu().selecionaUm(elemento, valor);
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

    protected Aba selecionaAba(WebElement nomeAba) {
        new AcaoMenu().selecionaAba(nomeAba);
        return null;
    }

    protected void scrollParaBaixoAteEncontrar(WebElement elemento) {
        new AcaoMenu().scrollParaBaixoAteEncontrar(elemento);
    }

    protected void scrollParaCimaAteEncontrar(WebElement elemento) {
        new AcaoMenu().scrollParaCimaAteEncontrar(elemento);
    }

    public void validaMensagem(String msg, WebElement elemento) {
        new AcaoMenu().validaMensagem(msg, elemento);
    }

}

