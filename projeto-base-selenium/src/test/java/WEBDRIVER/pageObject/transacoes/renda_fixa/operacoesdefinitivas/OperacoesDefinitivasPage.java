package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoesdefinitivas;

import API.transacoes.renda_fixa.operacoesdefinitivas.OperacoesDefinitivas;
import WEBDRIVER.base.basePage.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperacoesDefinitivasPage extends BasePage implements OperacoesDefinitivas {
    //region
    @FindBy(id = "mainForm:tradeModality_dropdown:campo")
    private WebElement modalidade;
    @FindBy(id = "mainForm:transactionDate_calendar:campoInputDate")
    private WebElement dataMov;
    @FindBy(id = "mainForm:tradeDate_calendar:campoInputDate")
    private WebElement dataCompra;
    @FindBy(id = "mainForm:portfolioDropdownInput")
    private WebElement carteira;
    @FindBy(id = "blockedblockedblocked")
    private WebElement autoComplete;
    @FindBy(id = "mainForm:security_dropdown:campo")
    private WebElement titulo;
    @FindBy(id = "mainForm:fixIssue_dropdown:campo")
    private WebElement emissao;
    @FindBy(id = "mainForm:fixAssetSuggestionInput")
    private WebElement estoque;
    @FindBy(id = "mainForm:tradeAssetType_dropdown:campo")
    private WebElement ativaPassiva;
    @FindBy(id = "mainForm:evaluationCriteria_dropdown:campo")
    private WebElement categoria;
    @FindBy(id = "mainForm:riscoBeneficio_dropdown:campo")
    private WebElement riscoBeneficio;
    @FindBy(id = "mainForm:evaluationCriteria_dropdown:campo")
    private WebElement negociacao;
    @FindBy(id = "mainForm:price_textField:campo")
    private WebElement pU;
    @FindBy(id = "mainForm:quantity_textField:campo")
    private WebElement qdt;
    @FindBy(id = "mainForm:calcButton")
    private WebElement calcular;
    @FindBy(id = "mainForm:irOnYield_dropdown:campo")
    private WebElement rendimento;
    @FindBy(id = "mainForm:eventoEmAtraso_dropdown:campo")
    private WebElement evento;
    //endregion

    public void acessaPagina() {
        new Acessa().operacoesDefinitivas();
        inserir();

    }

    public void modalidadeDoMovimento(String valor) {
        selecionaUm(modalidade, valor);

    }

    public void dataDoMovimento(String valor) {
        preenche(dataMov, valor);

    }

    public void dataDaCompra(String valor) {
        preenche(dataCompra, valor);

    }

    public void carteira(String valor) {
        preencheAutoComplete(carteira, valor);
        selecionaUm(autoComplete, valor);

    }

    public void titulo(String valor) {
        selecionaUm(titulo, valor);

    }

    public void emissao(String valor) {
        selecionaUm(emissao, valor);

    }

    public void estoque(String valor) {
        preencheAutoComplete(estoque, valor);

    }

    public void ativaPassiva(String valor) {
        selecionaUm(ativaPassiva, valor);

    }

    public void categoria(String valor) {
        selecionaUm(categoria, valor);

    }

    public void riscoBeneficio(String valor) {
        selecionaUm(riscoBeneficio, valor);

    }

    public void condicoesDeNegociacao(String valor) {
        selecionaUm(negociacao, valor);

    }

    public void pu(String valor) {
        preenche(pU, valor);

    }

    public void quantidade(String valor) {
        preenche(qdt, valor);
        clicar(calcular);

    }

    public void rendimento(String valor) {
        selecionaUm(rendimento, valor);

    }

    public void eventoEmAtraso(String valor) {
        selecionaUm(evento, valor);

    }

}
