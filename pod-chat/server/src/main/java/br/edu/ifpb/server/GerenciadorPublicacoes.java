
package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Mensagem;
import java.rmi.RemoteException;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 13/10/2017
 */

public class GerenciadorPublicacoes {

    private final MessageManager manager = new MessageManager();
    
    public void publicar(Mensagem mensagem) throws RemoteException {
        manager.adicionarMensagem(mensagem);
    }

}
