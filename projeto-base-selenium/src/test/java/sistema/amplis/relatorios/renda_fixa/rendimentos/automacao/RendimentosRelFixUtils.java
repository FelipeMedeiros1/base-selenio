package sistema.amplis.relatorios.renda_fixa.rendimentos.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioRelatorio;
import sistema.amplis.relatorios.renda_fixa.rendimentos.pagina.PaginaRendimentos;

public class RendimentosRelFixUtils extends UtilitarioRelatorio<RendimentosRelFix> {

    public RendimentosRelFixUtils(String nomeArquivo) {
        super(nomeArquivo);
    }

    private PaginaRendimentos pagina = new PaginaRendimentos();

    @Override
    protected void preencheDados(RendimentosRelFix dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, RendimentosRelFix.class);
        preenche(pagina.dataInicial, dados.dataInicial());
        preenche(pagina.dataFinal, dados.dataFinal());
        selecionaPickList(pagina.carteira, dados.carteira());
        selecionaUm(pagina.saida, dados.saida());
        selecionaUm(pagina.moeda, dados.moeda());
    }


    public RendimentosRelFixUtils gerarRelatorio(RendimentosRelFix dados, int posicao) {
        acessaPagina();
        preencheDados(dados, posicao);
        confirma();
        return this;
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
    }


}