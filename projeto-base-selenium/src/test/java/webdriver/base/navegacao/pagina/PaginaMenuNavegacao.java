package webdriver.base.navegacao.pagina;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.base.BasePagina;

public class PaginaMenuNavegacao extends BasePagina {
//region
    /**
     * TRANSAÇÕES MÓDULOS
     */
    //region
    @FindBy(id = "menuButtonSpan")
    public WebElement menuTransacoes;
    @FindBy(linkText = "Segurança")
    public WebElement segurança;
    @FindBy(linkText = "Duplo Controle")
    public WebElement duploControle;
    @FindBy(linkText = "Auditoria")
    public WebElement auditoria;
    @FindBy(linkText = "Cadastros Básicos")
    public WebElement cadastroBasico;
    @FindBy(linkText = "Taxas")
    public WebElement taxas;
    @FindBy(linkText = "Tributos")
    public WebElement tributos;
    @FindBy(linkText = "Cadastros de Pessoas")
    public WebElement cadastroDePessoas;
    @FindBy(linkText = "Dados de Mercado")
    public WebElement dadosDeMercado;
    @FindBy(linkText = "Renda Fixa")
    public WebElement rendaFixa;
    @FindBy(linkText = "Renda Variável")
    public WebElement rendaVariavel;
    @FindBy(linkText = "Derivativos")
    public WebElement derivativos;
    @FindBy(linkText = "Fundos")
    public WebElement fundos;
    @FindBy(linkText = "Outros Ativos")
    public WebElement outrosAtivos;
    @FindBy(linkText = "ETF – Módulo de Arquivos")
    public WebElement Etf;
    @FindBy(linkText = "Patrimônio")
    public WebElement patrimonio;
    @FindBy(linkText = "Contábil")
    public WebElement contabil;
    @FindBy(linkText = "Importações")
    public WebElement importacoes;
    @FindBy(linkText = "Exportações")
    public WebElement exportacoes;
    @FindBy(linkText = "Processamento")
    public WebElement processamento;
    @FindBy(linkText = "Calculadora")
    public WebElement calculadora;
    @FindBy(linkText = "Administração de Processamento")
    public WebElement administracaoDeProcessamento;

//endregion

      /**
     * RELATÓRIOS MÓDULOS
     */
    //region
    @FindBy(id = "menuRelatoriosButtonSpan")
    public WebElement menuRelatorios;
    @FindBy(linkText = "Auditoria")
    public WebElement Auditoria;
    @FindBy(linkText = "Renda Fixa\n")
    public WebElement relRendaFixa;
    @FindBy(linkText = "Patrimônio")
    public WebElement relPatrimonio;
    @FindBy(linkText = "Renda Variável")
    public WebElement relRendaVariavel;
    @FindBy(linkText = "Derivativos")
    public WebElement relDerivativos;
    @FindBy(linkText = "Fundos")
    public WebElement relFundos;
    @FindBy(linkText = "Outros Ativos")
    public WebElement relOutrosAtivos;
    @FindBy(linkText = "Câmbio, Forward e NDF")
    public WebElement relCâmbioForwardENDF;
    @FindBy(linkText = "Personalizados")
    public WebElement relPersonalizados;
    @FindBy(linkText = "Cadastros de Pessoas")
    public WebElement relCadastrosDePessoas;
    @FindBy(linkText = "Contábil")
    public WebElement relContabil;
    @FindBy(linkText = "Taxas")
    public WebElement relTaxas;
    @FindBy(linkText = "Tributos")
    public WebElement relTributos;
    @FindBy(linkText = "TIR")
    public WebElement relTIR;
    @FindBy(linkText = "Duplo Controle")
    public WebElement relDuploControle;

    //endregion


}
