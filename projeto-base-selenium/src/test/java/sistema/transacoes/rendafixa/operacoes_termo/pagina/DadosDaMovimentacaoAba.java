package sistema.transacoes.rendafixa.operacoes_termo.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DadosDaMovimentacaoAba extends PaginaOperacoesATermo  {
    //region
    @FindBy(id = "mainForm:tab1:header")
    public WebElement dadosDaMovimentacao;
    @FindBy(id = "mainForm:tradeModality_dropdown:campo")
    public WebElement modalidadeDoMovimento;
    @FindBy(id = "mainForm:forwardSettlementDate_calendar:campoInputDate")
    public WebElement dataDoMovimento;
    @FindBy(id = "mainForm:originalTransactionDate_calendar:campoInputDate")
    public WebElement dataDaCompra;
    @FindBy(id = "mainForm:forwardSettlementDate_calendar:campoInputDate")
    public WebElement dataDoVencimentoDoTermo;
    @FindBy(id = "mainForm:portfolioDropdownInput")
    public WebElement carteira;
    @FindBy(id = "mainForm:security_dropdown:campo")
    public WebElement titulo;
    @FindBy(id = "mainForm:fixIssue_dropdown:campo")
    public WebElement emissao;
    @FindBy(id = "mainForm:subSegmentosPREVICDropdown:campo")
    public WebElement subsegmentoPrevic;
    @FindBy(id = "mainForm:fixAssetSuggestionInput")
    public WebElement estoque;
    @FindBy(id = "  mainForm:riskLevel_dropdown:campo")
    public WebElement nivelDeRisco;
    @FindBy(id = "mainForm:tradeAssetType_dropdown:campo")
    public WebElement ativaPassiva;
    @FindBy(id = "mainForm:evaluationCriteria_dropdown:campo")
    public WebElement categoria;
    @FindBy(id = "mainForm:riscoBeneficio_dropdown:campo")
    public WebElement riscoBeneficio;
    @FindBy(id = "mainForm:negotiationCondition_dropdown:campo")
    public WebElement condicaoDeNegociacao;
    @FindBy(id = "mainForm:rate_textField:campo")
    public WebElement taxaDeNegociacao;
    @FindBy(id = "mainForm:price_textField:campo")
    public WebElement pu;
    @FindBy(id = "mainForm:quantity_textField:campo")
    public WebElement quantidade;
    @FindBy(id = "mainForm:calcButton")
    public WebElement calcular;
    @FindBy(id = "mainForm:irOnYield_dropdown:campo")
    public WebElement rendimento;
    @FindBy(id = "mainForm:IRValue_textField:campo")
    public WebElement irDaOperacao;
    @FindBy(id = "mainForm:IOFValue_textField:campo")
    public WebElement iofDaOperacao;
    @FindBy(id = "mainForm:eventoEmAtraso_dropdown:campo")
    public WebElement eventoEmAtraso;

    //endregion

}
