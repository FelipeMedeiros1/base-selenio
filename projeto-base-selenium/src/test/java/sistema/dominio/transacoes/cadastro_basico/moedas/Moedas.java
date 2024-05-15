package sistema.dominio.transacoes.cadastro_basico.moedas;

import lombok.Data;

@Data
public class Moedas {
    private String codigo;
    private String nome;
    private String simbolo;
    private String status;

}
