package SISTEMA.transacoes.cadastro_pessoas.fundamental;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundamental.FundamentalPage;

public class FundamentalUtils {
    private final String nomeDaPlanilhaTeste;

    public FundamentalUtils(String nomeDaPlanilhaTeste){
        this.nomeDaPlanilhaTeste = nomeDaPlanilhaTeste;
    }
    public FundamentalUtils incluir(Fundamental modeloDeCadastro,String chavePrimaria){
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(nomeDaPlanilhaTeste,chavePrimaria,"Fundamental", Fundamental.class);
        FundamentalPage page = new FundamentalPage();
        page.aceesaPaginaFundamental();
        page.pessoa(modeloDeCadastro.getPessoa());
        page.codigo(modeloDeCadastro.getCodigo());
        page.localidade(modeloDeCadastro.getLocalidade());
        page.grupoDeCarteiras(modeloDeCadastro.getGrupoDeCarteiras());
        page.apropriacao().seleciona();
        page.apropriacao().administrador(modeloDeCadastro.getAdministrador());
        page.apropriacao().gestor(modeloDeCadastro.getGestor());
        page.apropriacao().custodiante(modeloDeCadastro.getCustodiante());
        page.confirmaOperacao();
        return this;
    }
}
