package sistema.amplis.transacoes.cadastropessoas.fundamental.automacao;

public record Fundamental(
        int id,
        String filtroConsulta,
        String codigoConsulta,
        String pessoa,
        String codigo,
        String localidade,
        String status,
        String grupoDeCarteiras,
        String administrador,
        String gestor,
        String custodiante

) {

}
