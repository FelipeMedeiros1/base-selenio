package WEBDRIVER.pageObject.transacoes.processamento.processamento;

import API.transacoes.processamento.Processamento;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProcessamentoPage extends BasePage implements Processamento {
    //region
    @FindBy(id = "mainForm:functionPickList:firstSelect")
    private WebElement selecionaModulos;
    @FindBy(id = "mainForm:functionPickList:includeSelected")
    private WebElement incluirModulos;
    @FindBy(id = "mainForm:evaluationSituationPickList:firstSelect")
    private WebElement selecionaProcessamento;
    @FindBy(id = "mainForm:evaluationSituationPickList:includeSelected")
    private WebElement incluir;
    @FindBy(id = "mainForm:initialDateCalendar:campoInputDate")
    private WebElement inicio;
    @FindBy(id = "mainForm:finalDateCalendar:campoInputDate")
    private WebElement fim;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaOperator:campo")
    private WebElement filtro;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaInputText:campo")
    private WebElement carteira;
    @FindBy(id = "mainForm:dataTable1:0:processPortfolioCheckbox")
    private WebElement selecionaGrid;
    //endregion

    public void acessaPagina() {
        new Acessa().processamento();

    }

    public void modulos(String... valores) {
        selecionaVarios(selecionaModulos, incluirModulos, valores);

    }

    public void tipoDeProcessamento(String... valores) {
        selecionaVarios(selecionaProcessamento, incluir, valores);

    }

    public void dataInicial(String dataInicial) {
        preenche(inicio, dataInicial);

    }

    public void dataFinal(String dataFinal) {
        preenche(fim, dataFinal);

    }

    public void carteira(String valor) {
        selecionaUm(filtro, "Igual");
        preenche(carteira, valor);

    }

    public void executarProcessamento() {
        confirmar();
        scrollParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirmar();
        clicarBotaoOk();
    }

    public void executarProcessamentoComPreview() {
        confirmar();
        scrollParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirmar();
        clicarBotaoOk();
        esperaPor(1000);
        clicarBotaoOk();
    }
}
