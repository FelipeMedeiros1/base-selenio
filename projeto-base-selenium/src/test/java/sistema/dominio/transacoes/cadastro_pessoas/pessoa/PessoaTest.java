package sistema.dominio.transacoes.cadastro_pessoas.pessoa;

import webdriver.base.BaseTest;
import org.junit.Test;

public class PessoaTest extends BaseTest {
    private Pessoa pessoa;

    @Test
    public void testIncluirPessoa(){
        new PessoaUtils("PessoaTest").executarTeste(pessoa,"PS1");
    }
}
