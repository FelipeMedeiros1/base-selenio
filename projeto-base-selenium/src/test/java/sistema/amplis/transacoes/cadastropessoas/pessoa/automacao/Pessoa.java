package sistema.amplis.transacoes.cadastropessoas.pessoa.automacao;

public record Pessoa(
        int id,
        String codigo,
        String tipoDaPessoa,

        String razaoSocial,
        String nomeFantasia,
        String cnpj,
        String localidade,
        String setorDeAtividade,
        String status

) {


}
