package webdriver.base.navegacao.automacao;

import org.openqa.selenium.WebElement;
import webdriver.base.navegacao.pagina.PaginaMenuNavegacao;

public class MenuNavegacao extends PaginaMenuNavegacao {

    private Navegacao navegacao;

    //region
    public void transacoesCadastroBasico(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, cadastroBasico, pagina);
    }

    public void transacoesCadastroBasico(String id) {
        navegacao().navegarParaPagina(menuTransacoes, cadastroBasico, id);
    }

    public void transacoesTaxas(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, taxas, pagina);
    }

    public void transacoesTaxas(String id) {
        navegacao().navegarParaPagina(menuTransacoes, taxas, id);
    }

    public void transacoesCadastroDePessoas(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, cadastroDePessoas, pagina);
    }

    public void transacoesCadastroDePessoas(String id) {
        navegacao().navegarParaPagina(menuTransacoes, cadastroDePessoas, id);
    }

    public void transacoesRendaFixa(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, rendaFixa, pagina);
    }

    public void transacoesRendaFixa(String id) {
        navegacao().navegarParaPagina(menuTransacoes, rendaFixa, id);
    }

    public void transacoesFundos(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, fundos, pagina);
    }

    public void transacoesFundos(String id) {
        navegacao().navegarParaPagina(menuTransacoes, fundos, id);
    }

    public void transacoesProcessamento(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, processamento, pagina);
    }

    public void transacoesProcessamento(String id) {
        navegacao().navegarParaPagina(menuTransacoes, processamento, id);
    }

    public void transacoesImportacao(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, importacoes, pagina);
    }

    public void transacoesImportacao(String id) {
        navegacao().navegarParaPagina(menuTransacoes, importacoes, id);
    }

    public void relatoriosPatrimonio(WebElement pagina) {
        navegacao().navegarParaPagina(menuRelatorios, relPatrimonio, pagina);
    }

    public void relatoriosPatrimonio(String id) {
        navegacao().navegarParaPagina(menuRelatorios, relPatrimonio, id);
    }


    public void relatoriosRendaFixa(WebElement pagina) {
        navegacao().navegarParaPagina(menuRelatorios, relRendaFixa, pagina);
    }

    public void relatoriosRendaFixa(String id) {
        navegacao().navegarParaPagina(menuRelatorios, relRendaFixa, id);
    }
    //endregion

    public Navegacao navegacao() {
        if (navegacao == null) {
            navegacao = new Navegacao();
        }
        return navegacao;
    }


}
