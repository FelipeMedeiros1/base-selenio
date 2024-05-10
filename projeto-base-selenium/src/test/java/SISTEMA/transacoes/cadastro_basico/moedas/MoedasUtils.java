package SISTEMA.transacoes.cadastro_basico.moedas;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaConsultaPage;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;

public class MoedasUtils {
    private final String caminhoPlanilha;

    public MoedasUtils(String nomeDaClasse) {
        this.caminhoPlanilha = nomeDaClasse;
    }

    public void incluir(Moedas modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorXls.carregarDados(caminhoPlanilha, chavePrimaria, "Moedas", Moedas.class);

        try {
            MoedaPage page = new MoedaPage();
            page.acessaPaginaMoedas();
            page.codigo(modeloDeCadastro.getCodigo());
            page.nome(modeloDeCadastro.getNome());
            evidencia("Moedas", "nome");
            page.simbolo(modeloDeCadastro.getSimbolo());
            evidencia("Moedas", "simbolo");
            page.status(modeloDeCadastro.getStatus());
            page.confirmaOperacao("Moedas");

        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("Moedas");
        }


    }

    public void excluir(String codigoDaPesquisa) {
        try {
            MoedaConsultaPage page = new MoedaConsultaPage();
            page.acessaPaginaMoedasConsulta();
            page.codigoDaPesquisa(codigoDaPesquisa).selecionaGrid(0);
            evidencia("Moedas", "codigoDaPesquisa");
            page.excluir();

        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("Moedas");
        }
    }


}
