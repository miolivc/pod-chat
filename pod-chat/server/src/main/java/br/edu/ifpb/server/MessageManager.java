
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Mensagem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 13/10/2017
 */

public class MessageManager {
    
    private final List<Mensagem> mensagens = new ArrayList<>();

    public void adicionarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }
    
    public List<Mensagem> listaMensagens() {
        return Collections.unmodifiableList(mensagens);
    }
    
    public void removeMensagem(Mensagem mensagem) {
        mensagens.remove(mensagem);
    }
    
    public Mensagem recuperaMensagem(int id) {
        Mensagem mensagem = null;
        for(Mensagem m : mensagens) {
            if(m.getId() == id) {
                mensagem = m;
                break;
            }
        }
        return mensagem;
    }
}
