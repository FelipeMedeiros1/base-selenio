package SISTEMA.transacoes.cadastro_pessoas.pessoa;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.pessoa.PessoaPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;

public class PessoaUtils extends UtilitarioCadastroTestCase<Pessoa, PessoaPage> {

    public PessoaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(PessoaPage page, Pessoa modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Pessoa", Pessoa.class);

        page.codigo(modeloDeCadastro.getCodigo());
        evidencia("Pessoa", "codigo");
        page.tipoDaPessoa(modeloDeCadastro.getTipoDaPessoa());
        evidencia("Pessoa", "tipoDaPessoa");
        page.razaoSocial(modeloDeCadastro.getRazaoSocial());
        evidencia("Pessoa", "razaoSocial");
        page.nomeFantasia(modeloDeCadastro.getNomeFantasia());
        evidencia("Pessoa", "nomeFantasia");
        page.cnpj(modeloDeCadastro.getCnpj());
        evidencia("Pessoa", "cnpj");
        page.localidade(modeloDeCadastro.getLocalidade());
        evidencia("Pessoa", "localidade");
        page.setorDeAtividade(modeloDeCadastro.getSetorDeAtividade());
        page.status(modeloDeCadastro.getStatus());
        evidencia("Pessoa", "status");

    }

    @Override
    public PessoaUtils executarTeste(Pessoa modeloDeCadastro, String chavePrimaria) {
        try {
            PessoaPage page = new PessoaPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.confirmaOperacao("Pessoa");

        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("Pessoa");
        }
        return null;
    }
}
