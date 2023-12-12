package SISTEMA.transacoes.cadastro_pessoas.patrimonio;

import WEBDRIVER.base.baseTest.BaseTest;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.patrimonio.CadastroPatrimonioPage;
import org.junit.Test;

public class CadastroPatrimonioTest extends BaseTest {
    @Test
    public void testCadastraPatrimonio(){
        CadastroPatrimonioPage page = new CadastroPatrimonioPage();
        page.acessaPaginaPatrimonio()
                .carteira("ATIVOS 60266")
                .valorDaCotaInicial("1.000")
                .confirmaOperacao();

    }


}
