package sistema.relatorios.patrimonio.carteira_diaria.automacao;

import base.BaseTeste;
import org.junit.Test;

public class CarteiraDiariaTest extends BaseTeste {
private final String json ="relatorios/patrimonio/carteira_diaria/automacao/CarteiraDiaria.json";
    private CarteiraDiaria carteiraDiaria;

    @Test
    public void testGerarRelatorioCarteiraDiaria(){
        new CarteiraDiariaUtils(json).gerarRelatorio(carteiraDiaria,1);
    }
}
