package webdriver.pages.transacoes.renda_fixa.operacoes_definitivas;

import api.componente.Aba;
import api.componente.Click;
import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.transacoes.renda_fixa.operacoes_definitivas.DadosDaMovimentacaoAba;
import webdriver.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DadosDaMovimentacaoAbaImpl extends BasePage implements DadosDaMovimentacaoAba {
    //region
    @FindBy(id = "mainForm:tab1:header")
    private WebElement dadosDaMovimentacao;
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
    @FindBy(id = "mainForm:grossValue_textField:campo")
    private WebElement financeiro;

    @FindBy(id = "mainForm:calcButton")
    private WebElement calcular;
    @FindBy(id = "mainForm:irOnYield_dropdown:campo")
    private WebElement rendimento;
    @FindBy(id = "mainForm:eventoEmAtraso_dropdown:campo")
    private WebElement evento;

    //endregion
    @Override
    public Aba seleciona() {
        return selecionaAba(dadosDaMovimentacao);
    }

    @Override
    public SelecionaUm modalidadeDoMovimento(String valor) {
        return selecionaUm(modalidade, valor);
    }

    @Override
    public EntradaSimples dataDoMovimento(String valor) {
        return preenche(dataMov, valor);
    }

    @Override
    public EntradaSimples dataDaCompra(String valor) {
        return preenche(dataCompra, valor);
    }

    @Override
    public EntradaSimples carteira(String valor) {
        esperaPor(4000);
        return preencheAutoComplete(carteira, valor);
    }

    @Override
    public SelecionaUm titulo(String valor) {
        esperaPor(4000);
        return selecionaUm(titulo, valor);
    }

    @Override
    public SelecionaUm emissao(String valor) {
        esperaPor(4000);
        return selecionaUm(emissao, valor);
    }

    @Override
    public SelecionaUm estoque(String valor) {
        return selecionaUm(estoque, valor);
    }

    @Override
    public SelecionaUm ativaPassiva(String valor) {
        return selecionaUm(ativaPassiva, valor);
    }

    @Override
    public SelecionaUm categoria(String valor) {
        return selecionaUm(categoria, valor);
    }

    @Override
    public SelecionaUm riscoBeneficio(String valor) {
        return selecionaUm(riscoBeneficio, valor);
    }

    @Override
    public SelecionaUm condicoesDeNegociacao(String valor) {
        return selecionaUm(negociacao, valor);
    }

    @Override
    public EntradaSimples pu(String valor) {
        esperaPor(2000);
        return preenche(pU, valor);
    }

    @Override
    public EntradaSimples quantidade(String valor) {
        return preenche(qdt, valor);
    }

    @Override
    public EntradaSimples financeiro(String valor) {
        return preenche(financeiro, valor);
    }

    @Override
    public Click calcular() {
        esperaPor(2000);
        return clicar(calcular);
    }

    @Override
    public SelecionaUm rendimento(String valor) {
        return selecionaUm(rendimento, valor);
    }

    @Override
    public SelecionaUm eventoEmAtraso(String valor) {
        return selecionaUm(evento, valor);
    }

}
