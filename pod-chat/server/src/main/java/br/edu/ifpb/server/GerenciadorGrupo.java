
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class GerenciadorGrupo {
    
    private List<Grupo> grupos = new ArrayList<>();
    
    /**
     * Busca o grupo passado como parametro na lista dos existentes e
     * adiciona um determinado usuario na lista de inscritos desse grupo
     * 
     * @param usuario
     * @param grupo 
     */
    public void inscrever(Usuario usuario, Grupo grupo) {
        grupos.forEach((Grupo g) -> {
            if (g.equals(grupo)) {
                g.getInscritos().add(usuario);
            }
        });
    }
    
    /**
     * Busca o grupo passado como parametro na lista dos existentes e
     * remove o usuario passado por parametro na lista de inscritos desse grupo
     * 
     * @param usuario
     * @param grupo 
     */
    public void remover(Usuario usuario, Grupo grupo) {
        grupos.forEach((g) -> {
            if (g.equals(grupo)) {
                g.getInscritos().remove(usuario);
                return;
            }
        });
    }
    
    /**
     * Adiciona a instancia de um novo grupo no chat
     * 
     * @param grupo 
     */
    public boolean criar(Grupo grupo) {
        return grupos.add(grupo);
    }
    
    public List<Grupo> existentes() {
        return grupos;
    }
    
    public Grupo recuperar(String nome) {
        Grupo grup = null;
        for (Grupo g : grupos) {
            if (g.getNome().equalsIgnoreCase(nome)) {
                grup = g;
                break;
            }
        }
        return grup;
    }
    
}
