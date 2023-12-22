package SISTEMA.transacoes.cadastro_pessoas.pessoa;

import SISTEMA.base.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.pessoa.PessoaPage;

public class PessoaUtils extends UtilitarioCadastroTestCase<Pessoa, PessoaPage> {

    public PessoaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(PessoaPage page, Pessoa modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Pessoa", Pessoa.class);

        page.codigo(modeloDeCadastro.getCodigo())
                .tipoDaPessoa(modeloDeCadastro.getTipoDaPessoa())
                .razaoSocial(modeloDeCadastro.getRazaoSocial())
                .nomeFantasia(modeloDeCadastro.getNomeFantasia())
                .cnpj(modeloDeCadastro.getCnpj())
                .localidade(modeloDeCadastro.getLocalidade())
                .setorDeAtividade(modeloDeCadastro.getSetorDeAtividade())
                .status(modeloDeCadastro.getStatus());

    }

    @Override
    public PessoaUtils iniciarTeste(Pessoa modeloDeCadastro, String chavePrimaria) {
        PessoaPage page = new PessoaPage();
        page.acessaPaginaPessoas();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao();
        return this;
    }
}
