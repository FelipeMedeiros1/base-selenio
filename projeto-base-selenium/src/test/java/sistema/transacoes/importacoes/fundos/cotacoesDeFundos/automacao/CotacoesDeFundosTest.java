package amplis.transacoes.importacoes.fundos.cotacoesDeFundos.automacao;

import org.junit.Test;
import servico.base.BaseTeste;

public class CotacoesDeFundosTest extends BaseTeste {

    private String json = "amplis/transacoes/importacoes/fundos/cotacoesDeFundos/automacao/CotacoesDeFundos.json";
    private CotacoesDeFundos dados;

    @Test
    public void testImportarCotacoesDeFundos() {
        new CotacoesDeFundosUtils(json).importar(dados, 1);
    }


}
