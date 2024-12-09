package amplis.transacoes.processamento.processamentoContabil.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;
import amplis.transacoes.processamento.processamentoContabil.pagina.PaginaProcessamentoContabil;
import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioProcessamento;

public class ProcessamentoContabilUtils extends UtilitarioProcessamento<ProcessamentoContabil> {

    public ProcessamentoContabilUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaProcessamentoContabil pagina = new PaginaProcessamentoContabil();

    @Override
    protected void preencheDados(ProcessamentoContabil dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, ProcessamentoContabil.class);
        selecionaPickList(pagina.modulos, dados.modulos());
        preenche(pagina.dataInicial, dados.dataInicial());
        preenche(pagina.dataFinal, dados.dataFinal());
        selecionaUm(pagina.filtroCarteira, dados.filtroCarteira());
        preenche(pagina.carteira, dados.carteira());
    }


    @Override
    protected String transacao() {
        return "Transações > Processamento > Contábil > Processamento";
    }


}
