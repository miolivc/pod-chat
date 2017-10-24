
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Mensagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorMensagem {
    
    private List<Mensagem> mensagens = new ArrayList<>();
    
    /**
     * Envia uma mensagem para determinado grupo (salva a mensagem)
     * 
     * @param mensagem 
     */
    public void publicar(Mensagem mensagem) {
        mensagens.add(mensagem);
    }
    
    /**
     * Recupera todas as mensagens de um determinado grupo
     * @param grupo
     * @return mensagens
     */
    public List<Mensagem> recuperar(Grupo grupo) {
        List<Mensagem> msgs = new ArrayList<>();
        mensagens.stream()
                 .filter((m) ->  m.getGrupo().equals(grupo))
                 .forEach((m) -> msgs.add(m));
        return msgs;
    }
    
}
