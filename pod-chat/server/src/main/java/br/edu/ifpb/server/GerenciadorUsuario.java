
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorUsuario {
    
    private List<Usuario> registrados = new ArrayList<>();
    private List<Usuario> ativos = new ArrayList<>();

    /**
     * Cadastra um usuario no sistema 
     * @param usuario 
     */
    public boolean registrar(Usuario usuario) {
        return registrados.add(usuario);
    }
    
    /**
     * Verifica se o usuario esta registrado e caso esteja
     * adiciona na lista de usuarios ativos no momento
     * @param usuario
     * @return 
     */
    public boolean login(Usuario usuario) {
        return ativos.add(registrados.stream().filter((u) -> u.equals(usuario)).findFirst().get());
    }

    /**
     * Verifica se o usuario ta na lista de ativos e o remove desta
     * tornando-o inativo no sistema
     * @param usuario
     * @return 
     */
    public boolean logout(Usuario usuario) {
        return ativos.removeIf((u) -> usuario.equals(u));
    }
    
    
    public boolean logado(Usuario usuario) {
        return ativos.contains(usuario);
    }
    
}
