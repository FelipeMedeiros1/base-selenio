package sistema.amplis.transacoes.processamento.processamento.automacao;

import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;


import sistema.amplis.transacoes.processamento.processamento.pagina.PaginaProcessamento;
import sistema.servicos.utils.UtilitarioProcessamentoTestCase;


public class ProcessamentoUtils extends UtilitarioProcessamentoTestCase<Processamento> {
    public ProcessamentoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    private final PaginaProcessamento pagina = new PaginaProcessamento();

    protected void preencheDados(Processamento dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Processamento.class);
        pagina.selecionaVarios(pagina.modulos, pagina.incluirModulos, dados.modulos());
        pagina.selecionaVarios(pagina.tipoDeProcessamento, pagina.incluirTipo, dados.tipoDeProcessamento());
        pagina.preenche(pagina.dataInicial, dados.dataInicial());
        pagina.preenche(pagina.dataFinal, dados.dataFinal());
        pagina.selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        pagina.preenche(pagina.carteira, dados.carteira());
    }

    public ProcessamentoUtils executar(Processamento dadosProcessamento, int posicao) {
        acessa();
        preencheDados(dadosProcessamento, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.executarProcessamento(pagina.selecionaGrid);
    }
}


