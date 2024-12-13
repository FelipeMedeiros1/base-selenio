package amplis.transacoes.cadastropessoas.pessoa.automacao;

public record Pessoa(
        int id,
        String codigo,
        String tipoDaPessoa,

        String razaoSocial,
        String nomeFantasia,
        String cnpjCpf,
        String localidade,
        String setorDeAtividade,
        String status

) {


}
