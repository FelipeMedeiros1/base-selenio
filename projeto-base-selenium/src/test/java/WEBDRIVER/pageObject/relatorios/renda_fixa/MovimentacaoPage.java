package WEBDRIVER.pageObject.relatorios.renda_fixa;

import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovimentacaoPage extends BasePage {
    //region
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")private WebElement dataInicio ;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")private WebElement dataFinal;
    @FindBy(id = "mainForm:modalityPickList:firstSelect")private WebElement modalidadeDeMovimento;
    @FindBy(id = "mainForm:modalityPickList:includeSelected")private WebElement incluirModalidade;
    @FindBy(id = "mainForm:security_dropdown:campo")private WebElement titulo;
    @FindBy(id = "mainForm:issue_dropdown:campo")private WebElement emissao;
    @FindBy(id = "mainForm:portfolioPickList:firstSelect")private WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")private WebElement incluirCarteira;
    @FindBy(id = "mainForm:reportExtension:campo")private WebElement saida;
    @FindBy(id = "mainForm:reportIdiom:campo")private WebElement idioma;
    @FindBy(id = "mainForm:reportCurrency:campo")private WebElement moeda;
    @FindBy(id = "mainForm:reportType:campo")private WebElement tipoRelatorio;
    //endregion

    public void acessaPaginaRelMovimentacao(){ new Acessa().relMovimentacaoRendaFixa();}
    public void dataInicio(String valor){ preenche(dataInicio,valor);}
    public void dataFinal(String valor){ preenche(dataFinal,valor);}
    public void modalidadeDeMovimento(String... valores){selecionaVarios(modalidadeDeMovimento,incluirModalidade,valores);}
    public void titulo(String valor){ selecionaUm(titulo,valor);}
    public void emissao(String valor){ selecionaUm(emissao,valor);}
    public void carteira(String... valores){selecionaVarios(carteira,incluirCarteira,valores);}
    public void saida(String valor){selecionaUm(saida,valor);}
    public void idioma(String valor){selecionaUm(idioma,valor);}
    public void moeda(String valor){selecionaUm(moeda,valor);}
    public void tipoRelatorio(String valor){selecionaUm(tipoRelatorio,valor);}

}
