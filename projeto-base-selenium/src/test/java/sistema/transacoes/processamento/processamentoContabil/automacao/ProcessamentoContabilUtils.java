package sistema.transacoes.processamento.processamentoContabil.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioProcessamento;
import sistema.transacoes.processamento.processamentoContabil.pagina.PaginaProcessamentoContabil;

public class ProcessamentoContabilUtils extends UtilitarioProcessamento<ProcessamentoContabil> {

    public ProcessamentoContabilUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaProcessamentoContabil pagina = new PaginaProcessamentoContabil();

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
