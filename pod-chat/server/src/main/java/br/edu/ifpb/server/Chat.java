
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Mensagem;
import br.edu.ifpb.shared.domain.Notificacao;
import br.edu.ifpb.shared.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Chat {
    
    private final List<Usuario> ativos = new ArrayList<>();
    private final GerenciadorUsuario gerenciador = new GerenciadorUsuario();
    private final GerenciadorGrupo grupos = new GerenciadorGrupo();
    private final GerenciadorNotificacoes notificacoes = new GerenciadorNotificacoes(grupos);
    private final MessageManager msgManager = new MessageManager();
    
    public void inscrever(Usuario usuario) {
        gerenciador.add(usuario);
    }
    
    public void login(Usuario usuario) {
        if (gerenciador.get(usuario.getEmail()).equals(usuario)) {
            ativos.add(usuario);
        }
    }
    
    public void logout(Usuario usuario) {
        ativos.removeIf((Usuario ativo) -> ativo.equals(usuario));
    }
    
    public void receberMensagem(Mensagem mensagem) {
        msgManager.adicionarMensagem(mensagem);
        notificacoes.criaNotificacao(mensagem, gerenciador.get());
    }
    
    
    public void notificaAtivos() {
        // verificar lista de ativos e entrega as notificacoes 
        // referentes a esse usuario e logo apos remove
        ativos.forEach((usuario) -> {
            List<Notificacao> notify = notificacoes.notificacoesDoUsuario(usuario);
            
        });
    }
    
}
