package sistema.amplis.transacoes.cadastropessoas.renda_fixa.automacao;

import webdriver.base.BaseTeste;
import sistema.amplis.transacoes.cadastropessoas.renda_fixa.pagina.PaginaCadastroRendaFixa;
import org.junit.Test;

public class CadastroRendaFixaTest extends BaseTeste {

    @Test
    public void testCadastroRendaFixa() {
        PaginaCadastroRendaFixa paginaCadastroRendaFixa = new PaginaCadastroRendaFixa();
        paginaCadastroRendaFixa.acessa();
        paginaCadastroRendaFixa.carteira("FELIPE - JSM");
        paginaCadastroRendaFixa.negociacao().mtm("Não");
        paginaCadastroRendaFixa.confirmaOperacao();
    }
}
