package sistema.dominio.transacoes.cadastro_basico.moedas;


import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import webdriver.pages.transacoes.cadastros_basicos.moedas.MoedaConsultaPage;
import webdriver.pages.transacoes.cadastros_basicos.moedas.MoedaPage;


public class MoedasUtils {
    private final String caminhoPlanilha;

    public MoedasUtils(String nomeDaClasse) {
        this.caminhoPlanilha = nomeDaClasse;
    }

    public void incluir(Moedas modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorXls.carregarDados(caminhoPlanilha, chavePrimaria, "Moedas", Moedas.class);
        MoedaPage page = new MoedaPage();
        page.acessaPaginaMoedas();
        page.codigo(modeloDeCadastro.getCodigo());
        page.nome(modeloDeCadastro.getNome());
        page.simbolo(modeloDeCadastro.getSimbolo());
        page.status(modeloDeCadastro.getStatus());
        page.confirmaOperacao("Moedas");
    }

    public void excluir(String codigoDaPesquisa) {
        MoedaConsultaPage page = new MoedaConsultaPage();
        page.acessaPaginaMoedasConsulta();
        page.codigoDaPesquisa(codigoDaPesquisa).selecionaGrid(0);
        page.excluir();
    }
}
