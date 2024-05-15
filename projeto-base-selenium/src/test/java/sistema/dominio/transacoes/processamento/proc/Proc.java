package sistema.dominio.transacoes.processamento.proc;

import lombok.Data;
@Data
public class Proc {
        private String[] modulos;
        private String[] tipoDeProcessamento;
        private String dataInicial ;
        private String dataFinal;
        private String filtroCarteira;
        private String carteira;

    }