package sistema.relatorios.renda_fixa.rendimentos.automacao;

import utils.leitorDeArquivo.config_json.LeitorJson;
import sistema.servico.utils.UtilitarioRelatorio;
import sistema.relatorios.renda_fixa.rendimentos.pagina.PaginaRendimentos;

public class RendimentosRelFixUtils extends UtilitarioRelatorio<RendimentosRelFix> {

    public RendimentosRelFixUtils(String nomeArquivo) {
        super(nomeArquivo);
    }

    private final PaginaRendimentos pagina = new PaginaRendimentos();

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
    protected String relatorio() {
        return "Relatórios > Renda Fixa > Rendimentos";
    }


}
