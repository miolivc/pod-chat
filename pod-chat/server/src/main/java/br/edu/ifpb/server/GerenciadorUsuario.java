
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 13/10/2017
 */

public class GerenciadorUsuario {

    private final List<Usuario> usuarios = new ArrayList<>();
    
    public void add(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void remove(Usuario usuario) {
        usuarios.remove(usuario);
    }
    
    public Usuario get(String email) {
        Usuario usuario = null;
        for(Usuario u : usuarios) {
            if(u.getEmail().equalsIgnoreCase(email)) {
                usuario = u;
                break;
            }
        }
        return usuario;
    }
    
    public List<Usuario> get() {
        return Collections.unmodifiableList(usuarios);
    }
    
}
