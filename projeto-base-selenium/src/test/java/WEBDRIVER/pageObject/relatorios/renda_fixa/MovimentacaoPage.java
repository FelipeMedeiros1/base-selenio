package WEBDRIVER.pageObject.relatorios.renda_fixa;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.relatorio.renda_fixa.Movimentacao;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovimentacaoPage extends BasePage implements Movimentacao {
    //region
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
    private WebElement dataInicio;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
    private WebElement dataFinal;
    @FindBy(id = "mainForm:modalityPickList:firstSelect")
    private WebElement modalidadeDeMovimento;
    @FindBy(id = "mainForm:modalityPickList:includeSelected")
    private WebElement incluirModalidade;
    @FindBy(id = "mainForm:security_dropdown:campo")
    private WebElement titulo;
    @FindBy(id = "mainForm:issue_dropdown:campo")
    private WebElement emissao;
    @FindBy(id = "mainForm:portfolioPickList:firstSelect")
    private WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")
    private WebElement incluirCarteira;
    @FindBy(id = "mainForm:reportExtension:campo")
    private WebElement saida;
    @FindBy(id = "mainForm:reportIdiom:campo")
    private WebElement idioma;
    @FindBy(id = "mainForm:reportCurrency:campo")
    private WebElement moeda;
    @FindBy(id = "mainForm:reportType:campo")
    private WebElement tipoRelatorio;

    //endregion
    @Override
    public void acessaPagina() {
        new Acessa().relMovimentacaoRendaFixa();
    }

    @Override
    public EntradaSimples dataInicio(String valor) {
        return preenche(dataInicio, valor);
    }

    @Override
    public EntradaSimples dataFinal(String valor) {
        return preenche(dataFinal, valor);
    }

    @Override
    public SelecionaVarios modalidadeDeMovimento(String... valores) {
        return selecionaVarios(modalidadeDeMovimento, valores);
    }

    @Override
    public SelecionaUm titulo(String valor) {
        return selecionaUm(titulo, valor);
    }

    @Override
    public SelecionaUm emissao(String valor) {
        return selecionaUm(emissao, valor);
    }

    @Override
    public SelecionaVarios carteira(String... valores) {
        return selecionaVarios(carteira, valores);
    }

    @Override
    public SelecionaUm saida(String valor) {
        return selecionaUm(saida, valor);
    }

    @Override
    public SelecionaUm idioma(String valor) {
        return selecionaUm(idioma, valor);
    }

    @Override
    public SelecionaUm moeda(String valor) {
        return selecionaUm(moeda, valor);
    }

    @Override
    public SelecionaUm tipoRelatorio(String valor) {
        return selecionaUm(tipoRelatorio, valor);
    }
}
