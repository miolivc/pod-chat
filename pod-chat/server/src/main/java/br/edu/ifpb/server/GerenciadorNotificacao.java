
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Mensagem;
import br.edu.ifpb.shared.domain.Notificacao;
import br.edu.ifpb.shared.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorNotificacao {
    
    private List<Notificacao> notificacoes = new ArrayList<>();
    
    /**
     * Cria notificacao para todos os inscritos em determinado grupo
     * e salva no repositorio
     * 
     * @param mensagem 
     */
    public void criaNotificacao(Mensagem mensagem) {
        for(Usuario usuario : mensagem.getGrupo().getInscritos()) {
            if (usuario.equals(mensagem.getRemetente())) {
                continue;
            }
            Notificacao notificacao = new Notificacao(mensagem, usuario);
            notificacoes.add(notificacao);
        }
    }
    
    /**
     * Remove uma determinada notificacao dada por parametro
     * 
     * @param notificacao 
     */
    public void remove(Notificacao notificacao) {
        Notificacao notif = null;
        for (Notificacao n : notificacoes) {
            if (n.getMensagem().equals(notificacao.getMensagem()) 
                    && n.getInscrito().equals(notificacao.getInscrito())) {
                notif = n;
                break;
            }
        }
        notificacoes.remove(notif);
    }
    
    /**
     * Recupera todas as notificacoes de um determinado grupo 
     * 
     * @param grupo
     * @return 
     */
    public List<Notificacao> recuperaNotificacao(Usuario usuario, Grupo grupo) {
        List<Notificacao> notifies = new ArrayList<>(); 
        notificacoes.stream().filter((n) -> n.getMensagem().getGrupo().equals(grupo)
                && n.getInscrito().equals(usuario))
                    .forEach((n) -> notifies.add(n));
        return notifies;
    }
    
    /**
     * Recupera todas as notificacoes existentes
     * 
     * @return 
     */
    public List<Notificacao> recuperaNotificacao() {
        return notificacoes;
    }
    
    /**
     * Marca a notificacao passada como parametro como entregue ao destino
     * 
     * @param notificacao 
     */
    public void marcaComoEntregue(Notificacao notificacao) {
        notificacoes.stream().filter((n) -> n.equals(notificacao))
                    .forEach((n) -> n.setEntregue(true));
    }
    
}
