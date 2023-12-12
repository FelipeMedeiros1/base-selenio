package SISTEMA.transacoes.processamento.cockpit;

import lombok.Data;

@Data
public class CockPit {
    private String dataProcessamento;
    private String tipoProcessamennto;
    private String carteira;
    private String statusProcessamento;

}
