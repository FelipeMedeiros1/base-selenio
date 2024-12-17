package sistema.transacoes.cadastropessoas.rendaVariavel.pagina;

import webdriver.base.BasePagina;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaCadastroRendaVariavel extends BasePagina {
    //region

    @FindBy(id = "mainForm:carteiraDropdownInput")
    public WebElement inputCarteira;

    // Aba Dados Basicos

    @FindBy(id = "mainForm:lancamentosNoCaixaDropdown:campo")
    public WebElement selectDemonstracaoLancamentosCaixaCPR;

    @FindBy(id = "mainForm:repasseParticipanteLiquidacaoDropdown:campo")
    public WebElement selectRepassePNPPL;

    @FindBy(id = "mainForm:igualaCustoMercadoDropdown:campo")
    public WebElement selectIgualaCustoMercado;

    @FindBy(id = "mainForm:dataIgualaCustoMercadoDropdown:campo")
    public WebElement selectMesAdequacaoCustoMercado;

    @FindBy(id = "mainForm:ccorretoraObrigatorioBloqueioCotasDropdown:campo")
    public WebElement selectCorretoraObrigatorioBloqueioRendaVariavel;

    @FindBy(id = "mainForm:clienteQualificadoDropdown:campo")
    public WebElement selectClienteQualificado;

    @FindBy(id = "mainForm:serie1Dropdown:campo")
    public WebElement selectSerie1;

    @FindBy(id = "mainForm:serie2Dropdown:campo")
    public WebElement selectSerie2;

    // Aba Dados Basicos - A Vista

    @FindBy(id = "mainForm:vendasDescobertoDropdown:campo")
    public WebElement selectShortVista;

    @FindBy(id = "mainForm:bloqueadaDisponivelDropdown:campo")
    public WebElement selectPermitevenderPosicaoBloqueada;

    // Aba Dados basicos - Day Trade

    @FindBy(id = "mainForm:permiteDayTradeDropdown:campo")
    public WebElement selectPermiteDayTrade;

    @FindBy(id = "mainForm:dayTradeAutoDropdown:campo")
    public WebElement selectAutomatico;

    @FindBy(id = "mainForm:tipoArredondamentoDayTradeField")
    public WebElement selectTipoArredondamento;

    // Aba Dados Basicos - Termo

    @FindBy(id = "mainForm:apropriacaoTermoDropdown:campo")
    public WebElement selectApropriaTermo;

    @FindBy(id = "mainForm:dataApropriacaoCompraVistaVendaTermoDropdown:campo")
    public WebElement selectApropriacaoCompraVistaVendaTermo;

    // Aba Dados Basicos - Custodiantes

    @FindBy(id = "mainForm:formaCalculoDropdown:campo")
    public WebElement selectCustodianteCentralizador;

    // Aba Dados Basicos - Empréstimo de Ações - Taxas

    @FindBy(id = "mainForm:permissaoEmprestimoDropdown:campo")
    public WebElement selectEmprestimoAcoes;

    @FindBy(id = "mainForm:estoqueEletronicoDropdown:campo")
    public WebElement selectEstoqueEletronicoD1;

    @FindBy(id = "mainForm:annualRateExpressionGeneralField")
    public WebElement selectApropriacaoContagemDias;

    @FindBy(id = "mainForm:emprestimoDescobertoDropdown:campo")
    public WebElement selectShortEmprestimoAcoes;

    // Aba dados Basicos - Cota a Mercado

    @FindBy(id = "mainForm:negCotaMercadoDropdown:campoo")
    public WebElement selectCotaNegociadaMercado;

    @FindBy(id = "mainForm:cotaMercadoShortDropdown:campo")
    public WebElement selectShortCotaMercado;

    @FindBy(id = "mainForm:cotaMercadoBloqueadaDropdown:campo")
    public WebElement selectPermiteVenderPosicaoBloqueada;

    // Aba Dados Basicos - Exercício Automático de Opções

    @FindBy(id = "mainForm:exercicioAutomaticoOpcoesDropdown:campo")
    public WebElement selectExercicioAutomaticoOpcoes;

    @FindBy(id = "mainForm:exercicioAutomaticoOpcoesPosicaoDropdown:campo")
    public WebElement selectExercicioAutomaticoOpcoesPosicao;

    // Aba Cotação - Preços

    @FindBy(id = "mainForm:tab2:header")
    public WebElement clicarAbaCotacao;

    @FindBy(id = "mainForm:precosAcoesDropdown:campo")
    public WebElement selectAcoes;

    @FindBy(id = "mainForm:precosOpcoesDropdown:campo")
    public WebElement selectOpcoes;

    @FindBy(id = "mainForm:precosCotaMercadoDropdown:campo")
    public WebElement selectCotaFundoMercado;

    @FindBy(id = "mainForm:precosEmprestimosDropdown:campo")
    public WebElement selectEmprestimoAcoesTaxas;

    @FindBy(id = "mainForm:precoEmprestimoMercadoDropdown:campo")
    public WebElement selectEmprestimoAcoesMercado;

    @FindBy(id = "mainForm:cotacaoLiquidacaoDropdown:campo")
    public WebElement selectCotacaoParaLiquidacaoEmprestimo;

    // Aba Corretagem/Emolumentos/Taxas

    @FindBy(id = "mainForm:calculoEmolumentosDropdown:campo")
    public WebElement selectCalculosEmolumentos;

    @FindBy(id = "mainForm:refaturamentoDropdown:campo")
    public WebElement selectRefaturamento;

    @FindBy(id = "mainForm:refaturadorDropdown:campo")
    public WebElement selectRefaturador;

    @FindBy(id = "mainForm:associaLocalNegociacaoDropdown:campo")
    public WebElement selectAssociadoLocalNegociacao;

    // Aba Corretagem/Emolumentos/Taxas - Taxa de Custódia

    @FindBy(id = "mainForm:taxaSaldoCustodiaDropdown:campo")
    public WebElement selectTaxaSobreSaldoCustodia;

    @FindBy(id = "mainForm:apropriacaoTaxaCustodiaDropdown:campo")
    public WebElement selectApropriacao;

    @FindBy(id = "mainForm:baseAnoDropdown:campo")
    public WebElement selectBaseAnual;

    @FindBy(id = "mainForm:formaDropdown:campo")
    public WebElement selectFormaApropriacao;

    @FindBy(id = "mainForm:apropriacaoDropdown:campo")
    public WebElement selectBaseMensalApropriacao;

    // Aba Proventos

    @FindBy(id = "mainForm:proventosDropdown:campo")
    public WebElement selectCustoAcao;

    @FindBy(id = "mainForm:custoBonificacaoDropdown:campo")
    public WebElement selectCustoBonificacao;

    // Aba Proventos - Repasse de Proventos

    @FindBy(id = "mainForm:repasseDividendosDropdown:campo")
    public WebElement selectRepasseDividendos;

    @FindBy(id = "mainForm:diasUteisRepasseDividendosInput:campo")
    public WebElement selectDiasUteisParaRepasseDividendos;

    @FindBy(id = "mainForm:repasseRendimentosDropdown:campo")
    public WebElement selectRepasseRendimentos;

    @FindBy(id = "mainForm:diasUteisRepasseRendimentosInput:campo")
    public WebElement selectDiasUteisParaRepasseRendimentos;

    @FindBy(id = "mainForm:repasseJurosCapitalDropdown:campo")
    public WebElement selectRepasseJurosCapital;

    @FindBy(id = "mainForm:diasUteisRepasseJurosSemCapitalInput:campo")
    public WebElement selectDiasUteisParaRepasseJurosSobreCapital;

    // Aba Códigos De Custódia

    @FindBy(id = "mainForm:agenteDeCustodiaDropdownInput")
    public WebElement inputAgenteDeCustodia;

    @FindBy(id = "mainForm:codigoDeCustodiaDropdownInput")
    public WebElement inputCodigoDeCustodia;

    @FindBy(id = "mainForm:negCotaMercadoDropdown:campo")
    public WebElement selectCotaNegociadaAMercado;

    @FindBy(id = "mainForm:cotaMercadoShortDropdown:campo")
    public WebElement selectCotaShort;

    @FindBy(id = "mainForm:cotaMercadoBloqueadaDropdown:campo")
    public WebElement selectPermitirVenderPosicaoBloqueada;

    //endregion

}
