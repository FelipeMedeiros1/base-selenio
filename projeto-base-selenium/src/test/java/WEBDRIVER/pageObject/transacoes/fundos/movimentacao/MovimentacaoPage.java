package WEBDRIVER.pageObject.transacoes.fundos.movimentacao;

import API.componente.EntradaSimples;
import API.componente.SelecionaUm;
import API.transacoes.fundos.movimentacao.Movimentacao;
import WEBDRIVER.base.BasePage;
import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovimentacaoPage extends BasePage implements Movimentacao {
    //region
    @FindBy(id = "mainForm:dataMovimentacaoCalendar:campoInputDate")
    private WebElement dataDoMovimento;
    @FindBy(id = "mainForm:carteiraDropdownInput")
    private WebElement carteira;

    @FindBy(id = "mainForm:fundoDropdownInput")
    private WebElement fundo;
    @FindBy(id = "mainForm:modalidadeMovimentoDropdown:campo")
    private WebElement modalidadeDoMovimento;
    @FindBy(id = "mainForm:subSegmentosPREVICDropdown:campo")
    private WebElement subsegmentoPREVIC;
    @FindBy(id = "mainForm:dataAplicacaoCalendar:campoInputDate")
    private WebElement dataDaAplicacao;
    @FindBy(id = "mainForm:dataCotizacaoCalendar:campoInputDate")
    private WebElement dataDeCotizacao;
    @FindBy(id = "mainForm:dataLiquidacaoCalendar:campoInputDate")
    private WebElement liquidacaoDoMovimento;
    @FindBy(id = "mainForm:estoqueSuggestionInput")
    private WebElement estoque;
    @FindBy(id = "mainForm:quantidadeTextField:campo")
    private WebElement quantidade;
    @FindBy(id = "mainForm:financeiroTextField:campo")
    private WebElement financeiro;

    //endregion
    @Override
    public void acessaPagina() {
        new Acessa().movimentacaoFundos();
        inserir();
    }

    @Override
    public EntradaSimples dataDoMovimento(String valor) {
        return preenche(dataDoMovimento, valor);
    }

    @Override
    public EntradaSimples carteira(String valor) {
        return preencheAutoComplete(carteira, valor);
    }

    @Override
    public EntradaSimples fundo(String valor) {
        esperaPor(1000);
        return preencheAutoComplete(fundo, valor);
    }

    @Override
    public SelecionaUm modalidadeDoMovimento(String valor) {
        return selecionaUm(modalidadeDoMovimento, valor);
    }

    @Override
    public SelecionaUm subsegmentoPREVIC(String valor) {
        return selecionaUm(subsegmentoPREVIC, valor);
    }

    @Override
    public EntradaSimples dataDaAplicacao(String valor) {
        return preenche(dataDaAplicacao, valor);
    }

    @Override
    public EntradaSimples dataDeCotizacao(String valor) {
        return preenche(dataDeCotizacao, valor);
    }

    @Override
    public EntradaSimples liquidacaoDoMovimento(String valor) {
        return preenche(liquidacaoDoMovimento, valor);
    }

    @Override
    public EntradaSimples estoque(String valor) {
        return preenche(estoque, valor);
    }

    @Override
    public EntradaSimples quantidade(String valor) {
        return preenche(quantidade, valor);
    }

    @Override
    public EntradaSimples financeiro(String valor) {
        return preenche(financeiro, valor);
    }
}
