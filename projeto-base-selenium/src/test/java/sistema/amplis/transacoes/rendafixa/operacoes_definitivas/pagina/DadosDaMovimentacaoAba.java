package sistema.amplis.transacoes.rendafixa.operacoes_definitivas.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DadosDaMovimentacaoAba extends PaginaOperacoesDefinitivas  {
    //region
    @FindBy(id = "mainForm:tab1:header")
    public WebElement dadosDaMovimentacao;
    @FindBy(id = "mainForm:tradeModality_dropdown:campo")
    public WebElement modalidadeDoMovimento;
    @FindBy(id = "mainForm:transactionDate_calendar:campoInputDate")
    public WebElement dataDoMovimento;
    @FindBy(id = "mainForm:tradeDate_calendar:campoInputDate")
    public WebElement dataDaCompra;
    @FindBy(id = "mainForm:portfolioDropdownInput")
    public WebElement carteira;
    @FindBy(id = "blockedblockedblocked")
    public WebElement autoComplete;
    @FindBy(id = "mainForm:security_dropdown:campo")
    public WebElement titulo;
    @FindBy(id = "mainForm:fixIssue_dropdown:campo")
    public WebElement emissao;
    @FindBy(id = "mainForm:fixAssetSuggestionInput")
    public WebElement estoque;
    @FindBy(id = "mainForm:tradeAssetType_dropdown:campo")
    public WebElement ativaPassiva;
    @FindBy(id = "mainForm:evaluationCriteria_dropdown:campo")
    public WebElement categoria;
    @FindBy(id = "mainForm:riscoBeneficio_dropdown:campo")
    public WebElement riscoBeneficio;
    @FindBy(id = "mainForm:negotiationCondition_dropdown:campo")
    public WebElement condicoesDeNegociacao;
    @FindBy(id = "mainForm:price_textField:campo")
    public WebElement pu;
    @FindBy(id = "mainForm:quantity_textField:campo")
    public WebElement quantidade;
    @FindBy(id = "mainForm:grossValue_textField:campo")
    public WebElement financeiro;

    @FindBy(id = "mainForm:calcButton")
    public WebElement calcular;
    @FindBy(id = "mainForm:irOnYield_dropdown:campo")
    public WebElement rendimento;
    @FindBy(id = "mainForm:eventoEmAtraso_dropdown:campo")
    public WebElement eventoEmAtraso;

    //endregion



}
