package sistema.amplis.transacoes.cadastropessoas.fundos.automacao;

import webdriver.base.BaseTeste;
import sistema.amplis.transacoes.cadastropessoas.fundos.pagina.PaginaCadastroFundos;
import org.junit.Test;

public class CadastroFundosTest extends BaseTeste {
    @Test
    public void testCadastrarFundos(){
        PaginaCadastroFundos paginaCadastroFundos = new PaginaCadastroFundos();
        paginaCadastroFundos.acessa();
        paginaCadastroFundos.carteira("FELIPE - JSM");
        paginaCadastroFundos.formaDeCondominio("Aberto");
        paginaCadastroFundos.tipoDeFundos("Fundo de Investimento");
        paginaCadastroFundos.confirmaOperacao();
    }
}
