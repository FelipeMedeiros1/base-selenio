package sistema.transacoes.importacoes.fundos.cotacoesDeFundos.automacao;

import org.junit.Test;
import base.BaseTeste;

public class CotacoesDeFundosTest extends BaseTeste {

    private final String json = "amplis/transacoes/importacoes/fundos/cotacoesDeFundos/automacao/CotacoesDeFundos.json";
    private CotacoesDeFundos dados;

    @Test
    public void testImportarCotacoesDeFundos() {
        new CotacoesDeFundosUtils(json).importar(dados, 1);
    }


}
