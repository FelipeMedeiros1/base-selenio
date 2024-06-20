package sistema.amplis.transacoes.cadastropessoas.renda_variavel.automacao;

import webdriver.base.BaseTeste;
import sistema.amplis.transacoes.cadastropessoas.renda_variavel.pagina.PaginaCadastroRendaVariavel;
import org.junit.Test;

public class CadastroRendaVariavelTest extends BaseTeste {

    @Test
    public void testCadastroRendaVariavel(){
        PaginaCadastroRendaVariavel paginaCadastroRendaVariavel = new PaginaCadastroRendaVariavel();
        paginaCadastroRendaVariavel.acessa();
        paginaCadastroRendaVariavel.carteira("");
        paginaCadastroRendaVariavel .confirmaOperacao();
    }
}
