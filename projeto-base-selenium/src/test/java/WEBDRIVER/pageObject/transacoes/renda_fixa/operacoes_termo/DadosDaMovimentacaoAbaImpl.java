package WEBDRIVER.pageObject.transacoes.renda_fixa.operacoes_termo;

import API.componente.Aba;
import API.componente.Click;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.transacoes.renda_fixa.operacoes_termo.DadosDeMovimentacaoAba;
import WEBDRIVER.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DadosDaMovimentacaoAbaImpl extends BasePage implements DadosDeMovimentacaoAba {
    //region
    @FindBy(id = "mainForm:tab1:header")
    private WebElement dadosDaMovimentacao;
    @FindBy(id = "mainForm:tradeModality_dropdown:campo")
    private WebElement modalidadeDoMovimento;
    @FindBy(id = "mainForm:forwardSettlementDate_calendar:campoInputDate")
    private WebElement dataDoMovimento;
    @FindBy(id = "mainForm:originalTransactionDate_calendar:campoInputDate")
    private WebElement dataDaCompra;
    @FindBy(id = "mainForm:forwardSettlementDate_calendar:campoInputDate")
    private WebElement dataDoVencimentoDoTermo;
    @FindBy(id = "mainForm:portfolioDropdownInput")
    private WebElement cateira;
    @FindBy(id = "mainForm:security_dropdown:campo")
    private WebElement titulo;
    @FindBy(id = "mainForm:fixIssue_dropdown:campo")
    private WebElement emissao;
    @FindBy(id = "mainForm:subSegmentosPREVICDropdown:campo")
    private WebElement subsegmentoPrevic;
    @FindBy(id = "mainForm:fixAssetSuggestionInput")
    private WebElement estoque;
    @FindBy(id = "  mainForm:riskLevel_dropdown:campo")
    private WebElement nivelDeRisco;
    @FindBy(id = "mainForm:tradeAssetType_dropdown:campo")
    private WebElement ativaPassiva;
    @FindBy(id = "mainForm:evaluationCriteria_dropdown:campo")
    private WebElement categoria;
    @FindBy(id = "mainForm:riscoBeneficio_dropdown:campo")
    private WebElement riscoBeneficio;
    @FindBy(id = "mainForm:negotiationCondition_dropdown:campo")
    private WebElement condicaoDeNegociacao;
    @FindBy(id = "mainForm:rate_textField:campo")
    private WebElement taxaDeNegociacao;
    @FindBy(id = "mainForm:price_textField:campo")
    private WebElement pu;
    @FindBy(id = "mainForm:quantity_textField:campo")
    private WebElement quantidade;
    @FindBy(id = "mainForm:calcButton")
    private WebElement calcular;
    @FindBy(id = "mainForm:irOnYield_dropdown:campo")
    private WebElement rendimento;
    @FindBy(id = "mainForm:IRValue_textField:campo")
    private WebElement irDaOperacao;
    @FindBy(id = "mainForm:IOFValue_textField:campo")
    private WebElement iofDaOperacao;
    @FindBy(id = "mainForm:eventoEmAtraso_dropdown:campo")
    private WebElement eventoEmAtraso;

    //endregion
    @Override
    public Aba seleciona() {
        return selecionaAba(dadosDaMovimentacao);
    }

    @Override
    public SelecionaUm modalidadeDoMovimento(String valor) {
        return selecionaUm(modalidadeDoMovimento, valor);
    }

    @Override
    public EntradaSimples dataDoMovimento(String valor) {
        return preenche(dataDoMovimento, valor);
    }

    @Override
    public EntradaSimples dataDaCompra(String valor) {
        return preenche(dataDaCompra, valor);
    }

    @Override
    public EntradaSimples dataDoVencimentoDoTermo(String valor) {
        return preenche(dataDoVencimentoDoTermo, valor);
    }

    @Override
    public EntradaSimples carteira(String valor) {
        return preenche(cateira, valor);
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
    public SelecionaUm subsegmentoPrevic(String valor) {
        return selecionaUm(subsegmentoPrevic, valor);
    }

    @Override
    public EntradaSimples estoque(String valor) {
        return preenche(estoque, valor);
    }

    @Override
    public SelecionaUm nivelDeRisco(String valor) {
        return selecionaUm(nivelDeRisco, valor);
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
    public SelecionaUm condicaoDeNegociacao(String valor) {
        return selecionaUm(condicaoDeNegociacao, valor);
    }

    @Override
    public EntradaSimples taxaDeNegociacao(String valor) {
        return preenche(taxaDeNegociacao, valor);
    }

    @Override
    public EntradaSimples pu(String valor) {
        return preenche(pu, valor);
    }

    @Override
    public EntradaSimples quantidade(String valor) {
        return preenche(quantidade, valor);
    }

    @Override
    public Click calcular() { return clicar(calcular); }

    @Override
    public SelecionaUm rendimento(String valor) {
        return selecionaUm(rendimento, valor);
    }

    @Override
    public EntradaSimples irDaOperacao(String valor) {
        return preenche(irDaOperacao, valor);
    }

    @Override
    public EntradaSimples iofDaOperacao(String valor) {
        return preenche(iofDaOperacao, valor);
    }

    @Override
    public SelecionaUm eventoEmAtraso(String valor) {
        return selecionaUm(eventoEmAtraso, valor);
    }
}
