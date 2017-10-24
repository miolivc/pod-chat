
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Chat;
import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Notificacao;
import br.edu.ifpb.shared.domain.Usuario;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorChat implements Chat {
    
    public int opt = 0;
    private GerenciadorUsuario gUsuario = new GerenciadorUsuario();
    private GerenciadorGrupo gGrupo = new GerenciadorGrupo();
    private GerenciadorMensagem gMensagem = new GerenciadorMensagem(); 
    private GerenciadorNotificacao gNotificacao = new GerenciadorNotificacao();
    
    public Usuario inscrever(Usuario usuario) {
        if (gUsuario.registrar(usuario)) {
            System.out.println("Usuario cadastrado com sucesso! Efetue login.");
            return usuario;
        }
        System.out.println("Nao foi possivel cadastrar usuario!");
        return null;
    }
    
    public Usuario login(Usuario usuario) {
        if (gUsuario.login(usuario)) {
            System.out.println("Bem vindo ao sistema..");
            return usuario;
        }
        System.out.println("Erro ao efetuar login.. Tente novamente");
        return null;
    }
    
    public Chat logado(Usuario usuario) {
        if (gUsuario.logado(usuario)) {
            return this;
        }
        return null;
    }
    
    public void onChat(Chat chat) {
        switch (opt) {
            case 1: {
            } break;
            case 2: {
            } break;
        }
    }
    
}
