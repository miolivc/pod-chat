
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
 * @since 13/10/2017
 */

public class GerenciadorNotificacoes {
    
    private GerenciadorGrupo gerenciador = null;
    private List<Notificacao> notificacoes = new ArrayList<>();
    
    public GerenciadorNotificacoes(GerenciadorGrupo gerenciador) {
        this.gerenciador = gerenciador;
    }
    
    public void criaNotificacao(Mensagem mensagem, List<Usuario> usuarios) {
        Notificacao notificacao = new Notificacao();
        notificacao.setMensagem(mensagem);
        Grupo grupo = gerenciador.getGrupo(mensagem.getGrupo().getNome());
        grupo.getInscritos().stream()
             .filter((usuario) -> !(mensagem.getRemetente().equals(usuario)))
             .forEachOrdered((usuario) -> notificacao.getInscritos().add(usuario));
    }
    
    public List<Notificacao> notificacoesDoUsuario(Usuario usuario) {
        List<Notificacao> notificacoesUsuario = new ArrayList<>();
        for(Notificacao notificacao: notificacoes) {
            for (Usuario user : notificacao.getInscritos()) {
                if (user.equals(usuario)) {
                    notificacoesUsuario.add(notificacao);
                    break;
                }
            }
        }
    return notificacoesUsuario;
    }
    
    public void removeNotificacoesDoUsuario(Usuario usuario) {
        for(Notificacao notificacao: notificacoes) {
            for (Usuario user : notificacao.getInscritos()) {
                if (user.equals(usuario)) {
                    notificacao.getInscritos().remove(user);
                    break;
                }
            }
        }
    }
    
    
}
