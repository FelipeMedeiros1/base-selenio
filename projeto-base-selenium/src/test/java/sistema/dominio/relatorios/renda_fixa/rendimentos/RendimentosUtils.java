package sistema.dominio.relatorios.renda_fixa.rendimentos;


import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioRelatorioTestCase;
import webdriver.pages.relatorios.renda_fixa.rendimentos.RendimentosPage;

public class RendimentosUtils extends UtilitarioRelatorioTestCase<Rendimentos,RendimentosPage> {

    public RendimentosUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(RendimentosPage page, Rendimentos modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(),chavePrimaria,"Rendimentos",Rendimentos.class);
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.carteira(modeloDeCadastro.getCarteira());
        page.saida(modeloDeCadastro.getSaida());
        page.moeda(modeloDeCadastro.getMoeda());
    }


    public RendimentosUtils gerarRelatorio(Rendimentos modeloDeCadastro, String chavePrimaria){
        RendimentosPage page = new RendimentosPage();
        page.acessaPagina();
        preencheDados(page,modeloDeCadastro,chavePrimaria);
        page.confirmar();

        return this;
    }
}
