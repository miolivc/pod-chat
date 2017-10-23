
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.RemoteException;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 13/10/2017
 */

public class GerenciadorSubscricoes {
    
    private final GerenciadorGrupo gerenciador = new GerenciadorGrupo();
    
    public void inscrever(Usuario usuario, String nomeGrupo) throws RemoteException {
        gerenciador.addUser(usuario, nomeGrupo);
    }
    
}
