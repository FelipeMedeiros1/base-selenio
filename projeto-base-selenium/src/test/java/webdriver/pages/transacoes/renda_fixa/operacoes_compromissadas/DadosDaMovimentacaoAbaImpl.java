package webdriver.pages.transacoes.renda_fixa.operacoes_compromissadas;

import api.componente.Aba;
import api.componente.Click;
import api.componente.EntradaSimples;
import api.componente.SelecionaUm;
import api.transacoes.renda_fixa.operacoes_compromissadas.DadosDaMovimentacaoAba;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DadosDaMovimentacaoAbaImpl extends OperacoesCompromissadasPage implements DadosDaMovimentacaoAba {
    //region
    @FindBy(id = "")
    private WebElement dadosDaMovimentacao;
    @FindBy(id = "")
    private WebElement modalidadeDoMovimento;
    @FindBy(id = "")
    private WebElement dataDoMovimento;
    @FindBy(id = "")
    private WebElement dataDaOperacaoOriginal;
    @FindBy(id = "")
    private WebElement dataDeVencimento;
    @FindBy(id = "")
    private WebElement carteira;
    @FindBy(id = "")
    private WebElement titulo;
    @FindBy(id = "")
    private WebElement estoque;
    @FindBy(id = "")
    private WebElement moeda;
    @FindBy(id = "")
    private WebElement categoria;
    @FindBy(id = "")
    private WebElement riscoBeneficio;
    @FindBy(id = "")
    private WebElement condicoesDeNegociacao;
    @FindBy(id = "")
    private WebElement serie;
    @FindBy(id = "")
    private WebElement porcentagemDaSerie;
    @FindBy(id = "")
    private WebElement puInicio;
    @FindBy(id = "")
    private WebElement quantidade;
    @FindBy(id = "")
    private WebElement financeiroDeIda;
    @FindBy(id = "")
    private WebElement calcular;
    @FindBy(id = "")
    private WebElement rendimento;
    @FindBy(id = "")
    private WebElement eventoEmAtraso;
    @FindBy(id = "")
    private WebElement livreMovimentacao;

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
    public EntradaSimples dataDaOperacaoOriginal(String valor) {
        return preenche(dataDaOperacaoOriginal, valor);
    }

    @Override
    public EntradaSimples dataDeVencimento(String valor) {
        return preenche(dataDeVencimento, valor);
    }

    @Override
    public EntradaSimples carteira(String valor) {
        return preenche(carteira, valor);
    }

    @Override
    public SelecionaUm titulo(String valor) {
        return selecionaUm(titulo, valor);
    }

    @Override
    public SelecionaUm estoque(String valor) {
        return selecionaUm(estoque, valor);
    }

    @Override
    public SelecionaUm moeda(String valor) {
        return selecionaUm(moeda, valor);
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
        return selecionaUm(condicoesDeNegociacao, valor);
    }

    @Override
    public EntradaSimples serie(String valor) {
        return preenche(serie, valor);
    }

    @Override
    public EntradaSimples porcentagemDaSerie(String valor) {
        return preenche(porcentagemDaSerie, valor);

    }

    @Override
    public EntradaSimples puInicio(String valor) {
        return preenche(puInicio, valor);
    }

    @Override
    public EntradaSimples quantidade(String valor) {
        return preenche(quantidade, valor);
    }

    @Override
    public EntradaSimples financeiroDeIda(String valor) {
        return preenche(financeiroDeIda, valor);
    }

    @Override
    public Click calcular() {
        return clicar(calcular);
    }

    @Override
    public SelecionaUm rendimento(String valor) {
        return selecionaUm(rendimento, valor);
    }

    @Override
    public SelecionaUm eventoEmAtraso(String valor) {
        return selecionaUm(eventoEmAtraso, valor);
    }

    @Override
    public SelecionaUm livreMovimentacao(String valor) {
        return selecionaUm(livreMovimentacao, valor);
    }
}
