package lojinha.automacao;

import base.BaseTeste;
import org.junit.Test;
import utils.DescricaoCenario;

public class LojinhaTest extends BaseTeste {

    private String json = "lojinha/recursos/Lojinha.json";
    private UtilitarioLojinha<Lojinha> utils = new LojinhaUtils(json);
    private Lojinha lojinha;
@DescricaoCenario("O teste daverá acessar a Lojinha cadastrar um produto e adicionar componente.")
    @Test
    public void testeLojinha() {
        utils.executarLogin();
        utils.incluir(lojinha , 1);


    }

}
