package SISTEMA.transacoes.cadastro_pessoas.pessoa;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.pessoa.PessoaPage;

public class PessoaUtils {
    private final String caminhoPlanilha;

    public PessoaUtils(String nomeDaClasse) {
        this.caminhoPlanilha = nomeDaClasse;
    }
    public PessoaUtils incluir(Pessoa modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(caminhoPlanilha,chavePrimaria,"Pessoa", Pessoa.class);
        PessoaPage pessoa = new PessoaPage();
        pessoa.acessaPaginaPessoas()
                .codigo(modeloDeCadastro.getCodigo())
                .tipoDaPessoa(modeloDeCadastro.getTipoDaPessoa())
                .razaoSocial(modeloDeCadastro.getRazaoSocial())
                .nomeFantasia(modeloDeCadastro.getNomeFantasia())
                .cnpj(modeloDeCadastro.getCnpj())
                .localidade(modeloDeCadastro.getLocalidade())
                .setorDeAtividade(modeloDeCadastro.getSetorDeAtividade())
                .status(modeloDeCadastro.getStatus())
                .confirmaOperacao();
        return this;
    }
}
