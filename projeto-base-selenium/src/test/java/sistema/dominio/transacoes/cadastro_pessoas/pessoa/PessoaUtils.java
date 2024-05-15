package sistema.dominio.transacoes.cadastro_pessoas.pessoa;


import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import webdriver.pages.transacoes.cadastro_pessoas.pessoa.PessoaPage;


public class PessoaUtils extends UtilitarioCadastroTestCase<Pessoa, PessoaPage> {

    public PessoaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(PessoaPage page, Pessoa modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Pessoa", Pessoa.class);
        page.codigo(modeloDeCadastro.getCodigo());
        page.tipoDaPessoa(modeloDeCadastro.getTipoDaPessoa());
        page.razaoSocial(modeloDeCadastro.getRazaoSocial());
        page.nomeFantasia(modeloDeCadastro.getNomeFantasia());
        page.cnpj(modeloDeCadastro.getCnpj());
        page.localidade(modeloDeCadastro.getLocalidade());
        page.setorDeAtividade(modeloDeCadastro.getSetorDeAtividade());
        page.status(modeloDeCadastro.getStatus());

    }

    @Override
    public PessoaUtils executarTeste(Pessoa modeloDeCadastro, String chavePrimaria) {
        PessoaPage page = new PessoaPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao("Pessoa");

        return null;
    }
}
