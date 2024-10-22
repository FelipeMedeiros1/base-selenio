package sistema.amplis.transacoes.cadastropessoas.renda_fixa.automacao;

import sistema.amplis.transacoes.cadastropessoas.renda_fixa.pagina.PaginaCadastroRendaFixa;
import org.junit.Test;
import webdriver.base.Interagivel;

public class CadastroRendaFixaTest extends Interagivel {
    PaginaCadastroRendaFixa pagina = new PaginaCadastroRendaFixa();

    @Test
    public void testCadastroRendaFixa() {
        acessaPagina();
        preencheAutoComplete(pagina.carteira, "FELIPE - JSM");
        selecionaAba(pagina.negociacao().negociacao);
        selecionaUm(pagina.negociacao().mtm, "Não");
        confirmaOperacao();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
        inserir();
    }
}
