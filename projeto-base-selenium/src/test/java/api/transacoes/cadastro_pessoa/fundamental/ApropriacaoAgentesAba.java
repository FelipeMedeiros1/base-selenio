package api.transacoes.cadastro_pessoa.fundamental;

import api.componente.Aba;
import api.componente.EntradaSimples;

public interface ApropriacaoAgentesAba extends Aba {
    EntradaSimples administrador(String valor);
    EntradaSimples gestor(String valor);
    EntradaSimples custodiante(String valor);

  }

