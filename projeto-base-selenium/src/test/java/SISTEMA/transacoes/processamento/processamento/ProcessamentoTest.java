package SISTEMA.transacoes.processamento.processamento;

import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class ProcessamentoTest extends BaseTest {
    private Processamento processamento;

    private String json = "C:\\Users\\felipem.medeiros\\Documents\\cursos\\SELENIUM\\base-selenio\\projeto-base-selenium\\src\\test\\resources\\Processamento.json";
    private String xls = "ProcessamentoTest";

    @Test
    public void testProcessarCarteira() {

        new ProcessamentoUtils(json).executarTeste(processamento, 1);

        new ProcessamentoUtils(xls).executarTeste(processamento, "P2");

    }
}
