package sistema.servicos.navegacao;


import webdriver.base.Interagivel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class Acessa extends Interagivel {
//region
    /**
     * ELEMENTOS TRANSAÇÕES MÓDULOS
     */
    @FindBy(id = "menuButton")
    static WebElement transacoes;
    @FindBy(linkText = "Renda Fixa")
    static WebElement rendaFixa;
    @FindBy(linkText = "Processamento")
    static WebElement processamento;
    @FindBy(linkText = "Cadastros de Pessoas")
    static WebElement cadastroDePessoas;
    @FindBy(linkText = "Fundos")
    static WebElement fundos;
    @FindBy(linkText = "Cadastros Básicos")
    static WebElement cadastroBasico;


    /**
     * ELEMENTOS RELATÓRIOS MÓDULOS
     */
    @FindBy(id = "menuRelatoriosButtonSpan")
    static WebElement relatorios;
    @FindBy(linkText = "Patrimônio")
    static WebElement relPatrimonio;
    @FindBy(linkText = "Renda Fixa")
    static WebElement relRendaFixa;

    //endregion
    public void transacoesCadastroBasico(WebElement pagina) {
        navegarParaPagina(transacoes, cadastroBasico, pagina);
    }
    public void transacoesCadastroDePessoas(WebElement pagina) {
        navegarParaPagina(transacoes, cadastroDePessoas, pagina);
    }
    public void transacoesRendaFixa(WebElement pagina) {
        navegarParaPagina(transacoes, rendaFixa, pagina);
    }
    public void transacoesFundos(WebElement pagina) {
        navegarParaPagina(transacoes, fundos, pagina);
    }
    public void transacoesProcessamento(WebElement pagina) {
        navegarParaPagina(transacoes, processamento, pagina);
    }
    public void relatoriosPatrimonio(WebElement pagina) {
        navegarParaPagina(relatorios, relPatrimonio, pagina);
    }
    public void relatoriosRendaFixa(WebElement pagina) {
        navegarParaPagina(relatorios, relRendaFixa, pagina);
    }
    private void navegarParaPagina(WebElement menu, WebElement modulo, WebElement pagina) {
        Actions acoes = new Actions(getDriver());
        esperaElementoSerClicavel(menu);
        acoes.moveToElement(menu).perform();
        acoes.moveToElement(modulo).perform();
        acoes.click(pagina).perform();
        esperaPor(1500);
    }
    @Override
    public void acessa() {

    }

}
