package WEBDRIVER.pageObject.relatorios.patrimonio;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.componente.SelecionaVarios;
import API.relatorio.patrimonio.CarteiraDiaria;
import WEBDRIVER.base.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarteiraDiariaPage extends BasePage implements CarteiraDiaria {
    //region
    @FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
    private WebElement inicio;
    @FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
    private WebElement fim;
    @FindBy(id = "mainForm:headerValuePositionType:excludeAll")
    private WebElement deseleciona;
    @FindBy(id = "mainForm:headerValuePositionType:firstSelect")
    private WebElement seleciona;
    @FindBy(id = "mainForm:headerValuePositionType:includeSelected")
    private WebElement incluir;
    @FindBy(id = "mainForm:tipoDeConsolidacao:campo")
    private WebElement consolidacao;
    @FindBy(id = "mainForm:tipoCustoMedio:campo")
    private WebElement custo;
    @FindBy(id = "mainForm:portfolioPickList:firstSelect")
    private WebElement carteira;
    @FindBy(id = "mainForm:portfolioPickList:includeSelected")
    private WebElement incluirCarteira;
    @FindBy(id = "mainForm:tipoRelatorio:campo")
    private WebElement tipoRelatorio;
    @FindBy(id = "mainForm:saida:campo")
    private WebElement saida;

    //endregion
    @Override
    public void acessaPagina() {
        new Acessa().relCarteiraDiaria();
    }


    @Override
    public EntradaSimples dataInicio(String valor) {
        return preenche(inicio, valor);
    }

    @Override
    public EntradaSimples dataFinal(String valor) {
        return preenche(fim, valor);
    }

    @Override
    public SelecionaVarios tipoDePosicao(String... valores) {
        deseleciona.click();
        return selecionaVarios(seleciona, incluir, valores);
    }

    @Override
    public SelecionaUm tipoDeConsolidacao(String valor) {
        return selecionaUm(consolidacao, valor);
    }

    @Override
    public SelecionaUm custoMedio(String valor) {
        return selecionaUm(custo, valor);
    }

    @Override
    public SelecionaVarios carteira(String... valores) {
        return selecionaVarios(carteira, incluirCarteira, valores);
    }

    @Override
    public SelecionaUm tipoDoRelatorio(String valor) {
        return selecionaUm(tipoRelatorio, valor);
    }

    @Override
    public SelecionaUm saida(String valor) {
        return selecionaUm(saida, valor);
    }
}
