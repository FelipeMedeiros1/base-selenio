package sistema.amplis.transacoes.cadastropessoas.patrimonio.automacao;

import webdriver.base.BaseTeste;
import sistema.amplis.transacoes.cadastropessoas.patrimonio.pagina.PaginaCadastroPatrimonio;
import org.junit.Test;

public class CadastroPatrimonioTest extends BaseTeste {
    @Test
    public void testCadastraPatrimonio(){
        PaginaCadastroPatrimonio paginaCadastroPatrimonio = new PaginaCadastroPatrimonio();
        paginaCadastroPatrimonio.acessa();
        paginaCadastroPatrimonio.carteira("ATIVOS 60266");
        paginaCadastroPatrimonio.valorDaCotaInicial("1.000");
        paginaCadastroPatrimonio.confirmaOperacao();

    }


}
