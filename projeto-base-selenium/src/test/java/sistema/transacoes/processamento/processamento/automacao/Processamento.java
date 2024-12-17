package sistema.transacoes.processamento.processamento.automacao;
public record Processamento(
        int id,
        String[] modulos,
        String[] tipoDeProcessamento,
        String dataInicial,
        String dataFinal,
        String filtroCarteira,
        String carteira
) {
}
