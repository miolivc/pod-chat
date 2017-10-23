
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 13/10/2017
 */

public class GerenciadorGrupo {

    private final List<Grupo> grupos = new ArrayList<>();
    
    public void addUser(Usuario usuario, String nomeGrupo) {
        for (Grupo grupo: grupos) {
            if (grupo.getNome().equalsIgnoreCase(nomeGrupo)) {
                grupo.getInscritos().add(usuario);
                break;
            }
        }
    }
    
    public Grupo getGrupo(String nomeGrupo) {
        Grupo grupo = null;
        for (Grupo g: grupos) {
            if (g.getNome().equalsIgnoreCase(nomeGrupo)) {
                grupo = g;
            }
        }
        return grupo;
    }
    
    public void removeUser(Usuario usuario, String nomeGrupo) {
        grupos.stream()
              .filter((g) -> (g.getNome().equalsIgnoreCase(nomeGrupo)))
              .forEachOrdered((Grupo selected) -> selected.getInscritos().remove(usuario));
    }
    
}
