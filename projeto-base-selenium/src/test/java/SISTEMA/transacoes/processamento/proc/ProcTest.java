package SISTEMA.transacoes.processamento.proc;


import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class ProcTest extends BaseTest {


    private Proc prcessamento;

    @Test
    public void testProc(){
    new ProcUtils("ProcTest").executarTeste(prcessamento,"1");
    }

}
