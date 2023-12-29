package WEBDRIVER.pageObject.relatorios.renda_fixa;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.relatorio.renda_fixa.Rendimentos;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RendimentosPage extends BasePage implements Rendimentos {
    //region
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
    private WebElement dataInicial;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
    private WebElement dataFinal;
    @FindBy(id = "mainForm:portfolioPickList:firstSelect")
    private WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")
    private WebElement incluir;
    @FindBy(id = "mainForm:reportExtension:campo")
    private WebElement saida;
    @FindBy(id = "mainForm:reportIdiom:campo")
    private WebElement idioma;
    @FindBy(id = "mainForm:moeda:campo")
    private WebElement moeda;

    //endregion
    @Override
    public void acessaPagina() {
        new Acessa().relRendimentosRendaFixa();
    }

    @Override
    public EntradaSimples dataInicial(String valor) {
        return preenche(dataInicial, valor);
    }

    @Override
    public EntradaSimples dataFinal(String valor) {
        return preenche(dataFinal, valor);
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
    public SelecionaUm moeda(String valor) {
        return selecionaUm(moeda, valor);
    }


}
