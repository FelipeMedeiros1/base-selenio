package SISTEMA.relatorios.renda_fixa.rendimentos;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class RendimentosTest extends BaseTest {
    private Rendimentos relRendimentos;

    @Test
    public void gerarRelatorioRendimentos(){
        new RendimentosUtils("RendimentosTest").gerarRelatorio(relRendimentos,"R1");
    }
}
