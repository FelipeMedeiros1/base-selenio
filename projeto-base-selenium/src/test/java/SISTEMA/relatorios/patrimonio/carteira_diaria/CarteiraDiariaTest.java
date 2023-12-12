package SISTEMA.relatorios.patrimonio.carteira_diaria;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class CarteiraDiariaTest extends BaseTest {

    private CarteiraDiaria carteiraDiaria;

    @Test
    public void gerarRelatorioCarteiraDiaria(){
        new CarteiraDiariaUtils("CarteiraDiariaTest").gerarRelatorio(carteiraDiaria,"CD1");
    }
}
