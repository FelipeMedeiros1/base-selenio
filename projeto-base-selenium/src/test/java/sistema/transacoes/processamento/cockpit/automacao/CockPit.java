package sistema.transacoes.processamento.cockpit.automacao;

public record CockPit(
        int id,
        String dataProcessamento,
        String tipoProcessamennto,
        String filtroCarteira,
        String carteira,
        String statusProcessamento
) {
}
