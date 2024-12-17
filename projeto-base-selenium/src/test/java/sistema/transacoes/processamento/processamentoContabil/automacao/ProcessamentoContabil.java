package sistema.transacoes.processamento.processamentoContabil.automacao;


public record ProcessamentoContabil(
        int id,
        String[] modulos,
        String dataInicial,
        String dataFinal,
        String filtroCarteira,
        String carteira
) {


}
