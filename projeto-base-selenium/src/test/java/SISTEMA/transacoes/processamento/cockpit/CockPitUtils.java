package SISTEMA.transacoes.processamento.cockpit;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.processamento.cockpit.CockPitPage;

public class CockPitUtils {
    private final String caminhoPlanilha;

    public CockPitUtils(String planilhaTeste){
        this.caminhoPlanilha = planilhaTeste;
    }
    public CockPitUtils consultar(CockPit modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(caminhoPlanilha,chavePrimaria,"CockPit", CockPit.class);
        CockPitPage ckp = new CockPitPage();
        ckp.acessaPaginaCockPit()
                .dataProcessamento(modeloDeCadastro.getDataProcessamento())
                .tipoProcessamennto(modeloDeCadastro.getTipoProcessamennto())
                .carteira(modeloDeCadastro.getCarteira())
                .statusProcessamento(modeloDeCadastro.getStatusProcessamento())
                .pesquisaResultado();

    return this;
    }

}
