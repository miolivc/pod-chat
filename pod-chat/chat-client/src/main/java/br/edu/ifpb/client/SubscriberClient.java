
package br.edu.ifpb.client;

import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Mensagem;
import br.edu.ifpb.shared.domain.Subscriber;
import br.edu.ifpb.shared.domain.Usuario;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class SubscriberClient extends UnicastRemoteObject implements Subscriber {

    public SubscriberClient() throws RemoteException {
    }
    
    @Override
    public void receber(Mensagem mensagem) throws RemoteException {
        //
        try {
            System.in.read();
        } catch(IOException e){ e.printStackTrace();}
        //
        String textMessage = String.format("No grupo %s, %s disse: %s", 
                                mensagem.getGrupo(),
                                mensagem.getRemetente().getNome(), 
                                mensagem.getBody());
        System.out.println(textMessage);
        
    }

}

