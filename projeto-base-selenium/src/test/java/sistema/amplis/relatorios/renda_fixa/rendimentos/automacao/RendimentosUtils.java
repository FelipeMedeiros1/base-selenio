package sistema.amplis.relatorios.renda_fixa.rendimentos.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioRelatorioTestCase;
import sistema.amplis.relatorios.renda_fixa.rendimentos.pagina.PaginaRendimentos;

public class RendimentosUtils extends UtilitarioRelatorioTestCase<Rendimentos> {

    public RendimentosUtils(String nomeArquivo) {
        super(nomeArquivo);
    }

    private PaginaRendimentos pagina = new PaginaRendimentos();

    @Override
    protected void preencheDados(Rendimentos dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Rendimentos.class);
        pagina.preenche(pagina.dataInicial, dados.dataInicial());
        pagina.preenche(pagina.dataFinal, dados.dataFinal());
        pagina.selecionaVarios(pagina.carteira, pagina.incluirCarteira, dados.carteira());
        pagina.selecionaUm(pagina.saida, dados.saida());
        pagina.selecionaUm(pagina.moeda, dados.moeda());
    }


    public RendimentosUtils gerarRelatorio(Rendimentos dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.confirma();
    }
}
