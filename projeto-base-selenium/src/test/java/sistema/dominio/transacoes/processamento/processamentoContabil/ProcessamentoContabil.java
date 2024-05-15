package sistema.dominio.transacoes.processamento.processamentoContabil;

import lombok.Data;

@Data
public class ProcessamentoContabil {
    private String[] modulos;
    private String dataInicial;
    private String dataFinal;
    private String carteira;

}
