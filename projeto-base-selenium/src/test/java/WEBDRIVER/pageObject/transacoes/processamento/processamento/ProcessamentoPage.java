package WEBDRIVER.pageObject.transacoes.processamento.processamento;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.transacoes.processamento.Processamento;
import WEBDRIVER.base.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProcessamentoPage extends BasePage implements Processamento {
    //region
    @FindBy(id = "mainForm:functionPickList:firstSelect")
    private WebElement modulos;
    @FindBy(id = "mainForm:functionPickList:includeSelected")
    private WebElement incluirModulos;
    @FindBy(id = "mainForm:evaluationSituationPickList:firstSelect")
    private WebElement tipoDeProcessamento;
    @FindBy(id = "mainForm:evaluationSituationPickList:includeSelected")
    private WebElement incluir;
    @FindBy(id = "mainForm:initialDateCalendar:campoInputDate")
    private WebElement dataInicial;
    @FindBy(id = "mainForm:finalDateCalendar:campoInputDate")
    private WebElement dataFinal;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaOperator:campo")
    private WebElement filtroCarteira;
    @FindBy(id = "mainForm:portfolioMnemonicCriteria:criteriaInputText:campo")
    private WebElement carteira;
    @FindBy(id = "mainForm:dataTable1:0:processPortfolioCheckbox")
    private WebElement selecionaGrid;
    //endregion

    public void acessaPagina() {
        new Acessa().processamento();
    }

    public SelecionaVarios modulos(String... valores) {
        return selecionaVarios(modulos, incluirModulos, valores);
    }

    public SelecionaVarios tipoDeProcessamento(String... valores) {
        return selecionaVarios(tipoDeProcessamento, incluir, valores);
    }

    public EntradaSimples dataInicial(String valor) {
        return preenche(dataInicial, valor);

    }

    public EntradaSimples dataFinal(String valor) {
        return preenche(dataFinal, valor);

    }

    @Override
    public SelecionaUm filtroCarteira(String valor) {
        return selecionaUm(filtroCarteira, "Igual");
    }

    public EntradaSimples carteira(String valor) {
        return preenche(carteira, valor);

    }

    public void executar() {
        executarProcessamento(selecionaGrid, "Processamento");
    }

    public void executarComPreview() {

        confirmar();
        rolarParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirmar();
        clicarBotaoOk();
        esperaPor(1000);
        clicarBotaoOk();
    }
}
