package sistema.dominio.relatorios.patrimonio.carteira_diaria;

import webdriver.base.BaseTest;
import org.junit.Test;

public class CarteiraDiariaTest extends BaseTest {

    private CarteiraDiaria carteiraDiaria;

    @Test
    public void testGerarRelatorioCarteiraDiaria(){
        new CarteiraDiariaUtils("CarteiraDiariaTest").gerarRelatorio(carteiraDiaria,"CD1");
    }
}
