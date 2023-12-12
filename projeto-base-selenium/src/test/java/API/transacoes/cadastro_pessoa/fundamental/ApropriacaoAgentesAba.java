package API.transacoes.cadastro_pessoa.fundamental;

import API.componente.Aba;

public interface ApropriacaoAgentesAba extends Aba {
    void administrador(String valor);
    void gestor(String valor);
    void custodiante(String valor);

  }

