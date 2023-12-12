package SISTEMA.transacoes.cadastro_pessoas.pessoa;

import lombok.Data;

@Data
public class Pessoa {
    private String codigo;
    private String tipoDaPessoa;
    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;
    private String localidade;
    private String setorDeAtividade;
    private String status;


}
