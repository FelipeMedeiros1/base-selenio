package WEBDRIVER.pageObject.transacoes.processamento.processamento;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.transacoes.processamento.Processamento;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.componentes.CapturaDeTela;
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
    private WebElement tipoDeProcessamento;
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



    public SelecionaVarios modulos(String... valores) {
        return selecionaVarios(selecionaModulos, incluirModulos, valores);

    }

    public SelecionaVarios tipoDeProcessamento(String... valores) {
        return selecionaVarios(tipoDeProcessamento, incluir, valores);

    }

    public EntradaSimples dataInicial(String dataInicial) {
        return preenche(inicio, dataInicial);

    }

    public EntradaSimples dataFinal(String dataFinal) {
        return preenche(fim, dataFinal);

    }

    @Override
    public SelecionaUm filtroCarteira(String valor) {
        return selecionaUm(filtro, "Igual");
    }

    public EntradaSimples carteira(String valor) {
        return preenche(carteira, valor);

    }

    public void executarProcessamento() {
        confirmar();
        scrollParaBaixoAteEncontrar(selecionaGrid);
        selecionaGrid.click();
        confirmar();
        new CapturaDeTela().evidencia("processamento","Finalizando-teste");
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
