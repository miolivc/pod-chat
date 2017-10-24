
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Chat;
import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Notificacao;
import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorChat extends UnicastRemoteObject implements Chat {
    
    public int opt = 0;
    private GerenciadorUsuario gUsuario = new GerenciadorUsuario();
    private GerenciadorGrupo gGrupo = new GerenciadorGrupo();
    private GerenciadorMensagem gMensagem = new GerenciadorMensagem(); 
    private GerenciadorNotificacao gNotificacao = new GerenciadorNotificacao();

    public GerenciadorChat() throws RemoteException {
    }
    
    @Override
    public Usuario inscrever(Usuario usuario) {
        if (gUsuario.registrar(usuario)) {
            return usuario;
        }
        return null;
    }
    
    public Chat login(Usuario usuario) {
        if (gUsuario.login(usuario)) {
            return this;
        }
        return null;
    }
    
    public void onChat(Grupo grupo) {
        
    }
    
}
