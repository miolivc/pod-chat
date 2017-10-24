
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Chat;
import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Notificacao;
import br.edu.ifpb.shared.domain.Subscriber;
import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorChat extends UnicastRemoteObject implements Chat {
    
    private GerenciadorUsuario gUsuario = new GerenciadorUsuario();
    private GerenciadorGrupo gGrupo = new GerenciadorGrupo();
    private GerenciadorMensagem gMensagem = new GerenciadorMensagem(); 
    private GerenciadorNotificacao gNotificacao = new GerenciadorNotificacao();

    public GerenciadorChat() throws RemoteException {
        this.gGrupo.criar(new Grupo("Grupo1"));
        this.gGrupo.criar(new Grupo("Grupo2"));
        this.gGrupo.criar(new Grupo("Grupo3"));
    }
    
    @Override
    public Usuario inscrever(Usuario usuario) {
        if (gUsuario.registrar(usuario)) {
            return usuario;
        }
        return null;
    }
    
    @Override
    public Chat login(Usuario usuario) {
        if (gUsuario.login(usuario)) {
            return this;
        }
        return null;
    }
    
    @Override
    public List<Grupo> listaGrupos() {
        return gGrupo.existentes();
    }
    
    @Override
    public void onChat(Usuario usuario, Subscriber subscriber, Grupo grupo) {
        new Thread(() -> {
            gUsuario.logado(usuario);
            List<Notificacao> notify = gNotificacao.recuperaNotificacao(usuario, grupo);
            notify.forEach((n) -> {
                try {
                    subscriber.receber(n.getMensagem());
                    gNotificacao.remove(n);
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            });
        }).start();
    }
    
}
