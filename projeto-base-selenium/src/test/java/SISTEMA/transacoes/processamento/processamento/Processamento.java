package SISTEMA.transacoes.processamento.processamento;

import lombok.Data;

@Data
public class Processamento {
    private String[] modulos;
    private String[] tipoDeProcessamento;
    private String dataInicial ;
    private String dataFinal;
    public String filtroCarteira;
    private String carteira;

}
