package sistema.amplis.relatorios.patrimonio.carteira_diaria.automacao;

import sistema.servicos.base.BaseTeste;
import org.junit.Test;

public class CarteiraDiariaTest extends BaseTeste {
private String json ="relatorios/patrimonio/carteira_diaria/automacao/CarteiraDiaria.json";
    private CarteiraDiaria carteiraDiaria;

    @Test
    public void testGerarRelatorioCarteiraDiaria(){
        new CarteiraDiariaUtils(json).gerarRelatorio(carteiraDiaria,1);
    }
}
