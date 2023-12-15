package SISTEMA.transacoes.renda_fixa.operacoestermo;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.jupiter.api.Test;

public class OperacoesATermoTest  extends BaseTest {
    private OperacoesATermo OpTermo;
    @Test
    public void teste01(){
    new OperacoesATermoUtils("OperacoesATermoTest").incluir(OpTermo,"OT1");


    }
}
