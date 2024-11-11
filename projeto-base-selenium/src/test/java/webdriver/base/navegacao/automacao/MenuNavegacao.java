package webdriver.base.navegacao.automacao;

import org.openqa.selenium.WebElement;
import webdriver.base.navegacao.pagina.PaginaMenuNavegacao;

public class MenuNavegacao extends PaginaMenuNavegacao {

    private Navegacao navegacao;

    //region
    public void transacoesCadastroBasico(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, cadastroBasico, pagina);
    }

    public void transacoesCadastroDePessoas(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, cadastroDePessoas, pagina);
    }

    public void transacoesRendaFixa(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, rendaFixa, pagina);
    }

    public void transacoesFundos(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, fundos, pagina);
    }

    public void transacoesProcessamento(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, processamento, pagina);
    }

    public void transacoesImportacao(WebElement pagina) {
        navegacao().navegarParaPagina(menuTransacoes, importacoes, pagina);
    }

    public void relatoriosPatrimonio(WebElement pagina) {
        navegacao().navegarParaPagina(menuRelatorios, relPatrimonio, pagina);
    }

    public void relatoriosRendaFixa(WebElement pagina) {
        navegacao().navegarParaPagina(menuRelatorios, relRendaFixa, pagina);
    }
    //endregion

    public Navegacao navegacao() {
        if (navegacao == null) {
            navegacao = new Navegacao();
        }
        return navegacao;
    }




}
