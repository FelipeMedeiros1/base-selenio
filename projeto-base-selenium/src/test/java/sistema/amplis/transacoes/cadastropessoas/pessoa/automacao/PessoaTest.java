package sistema.amplis.transacoes.cadastropessoas.pessoa.automacao;

import sistema.servicos.base.BaseTeste;
import org.junit.Test;

public class PessoaTest extends BaseTeste {
    private String json ="transacoes/cadastropessoas/pessoa/automacao/Pessoa.json";
    private Pessoa pessoa;

    @Test
    public void testIncluirPessoa(){
        new PessoaUtils(json).incluir(pessoa,1);
    }
}
