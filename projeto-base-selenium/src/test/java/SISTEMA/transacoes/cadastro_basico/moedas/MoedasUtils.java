package SISTEMA.transacoes.cadastro_basico.moedas;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaConsultaPage;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaPage;

public class MoedasUtils {
    private final String caminhoPlanilha;

    public MoedasUtils(String nomeDaClasse){
        this.caminhoPlanilha = nomeDaClasse;
    }
    public void incluir(Moedas modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(caminhoPlanilha,chavePrimaria,"Moedas", Moedas.class);
        MoedaPage page = new MoedaPage();
        page.acessaPaginaMoedas();
        page.codigo(modeloDeCadastro.getCodigo());
        page.nome(modeloDeCadastro.getNome());
        page.simbolo(modeloDeCadastro.getSimbolo());
        page.status(modeloDeCadastro.getStatus());
        page.confirmaOperacao();

    }
    public void excluir(String codigoDaPesquisa){
        MoedaConsultaPage page = new MoedaConsultaPage();
        page.acessaPaginaMoedasConsulta()
                .codigoDaPesquisa(codigoDaPesquisa).selecionaGrid(0)
                .excluir();
    }


}
