package SISTEMA.transacoes.cadastro_basico.moedas;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.componentes.CapturaDeTela;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaConsultaPage;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaPage;
import org.openqa.selenium.TakesScreenshot;

import static WEBDRIVER.componentes.CapturaDeTela.*;

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
        evidencia("Moedas","nome");
        page.simbolo(modeloDeCadastro.getSimbolo());
        evidencia("Moedas","simbolo");
        page.status(modeloDeCadastro.getStatus());
        page.confirmaOperacao("Moedas");

    }
    public void excluir(String codigoDaPesquisa){
        MoedaConsultaPage page = new MoedaConsultaPage();
        page.acessaPaginaMoedasConsulta()
                .codigoDaPesquisa(codigoDaPesquisa).selecionaGrid(0);
        evidencia("Moedas","codigoDaPesquisa");
                page.excluir();
    }


}
