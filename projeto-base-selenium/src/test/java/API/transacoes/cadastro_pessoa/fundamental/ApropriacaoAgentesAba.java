package API.transacoes.cadastro_pessoa.fundamental;

import API.componente.Aba;
import API.componente.EntradaSimples;

public interface ApropriacaoAgentesAba extends Aba {
    EntradaSimples administrador(String valor);
    EntradaSimples gestor(String valor);
    EntradaSimples custodiante(String valor);

  }

