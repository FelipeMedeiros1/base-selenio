package sistema.dominio.transacoes.cadastro_pessoas.fundamental;

import lombok.Data;

@Data
public class Fundamental {
    private String pessoa;
    private String codigo;
    private String localidade;
    private String grupoDeCarteiras;
    private String administrador;
    private String gestor;
    private String custodiante;

}
