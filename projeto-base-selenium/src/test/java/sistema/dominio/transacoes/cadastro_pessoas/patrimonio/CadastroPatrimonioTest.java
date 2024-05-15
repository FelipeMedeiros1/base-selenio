package sistema.dominio.transacoes.cadastro_pessoas.patrimonio;

import webdriver.base.BaseTest;
import webdriver.pages.transacoes.cadastro_pessoas.patrimonio.CadastroPatrimonioPage;
import org.junit.Test;

public class CadastroPatrimonioTest extends BaseTest {
    @Test
    public void testCadastraPatrimonio(){
        CadastroPatrimonioPage page = new CadastroPatrimonioPage();
        page.acessaPaginaPatrimonio()
                .carteira("ATIVOS 60266")
                .valorDaCotaInicial("1.000")
                .confirmaOperacao("Cadastro-patrimonio");

    }


}
