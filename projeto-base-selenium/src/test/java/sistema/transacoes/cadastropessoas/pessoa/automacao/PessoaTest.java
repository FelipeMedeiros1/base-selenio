package sistema.transacoes.cadastropessoas.pessoa.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class PessoaTest extends BaseTeste {
    private final String json ="amplis/transacoes/cadastropessoas/pessoa/automacao/Pessoa.json";
    private Pessoa pessoa;

    @Test
    public void testIncluirPessoa(){
        new PessoaUtils(json)
                .incluir(pessoa,1)
                .alterar(pessoa,2)
                .excluir(pessoa,3);

    }
}
