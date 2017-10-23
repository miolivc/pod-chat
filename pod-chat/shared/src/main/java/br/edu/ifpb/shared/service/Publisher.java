
package br.edu.ifpb.shared.service;

import br.edu.ifpb.shared.domain.Mensagem;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Publisher extends Remote {
    
    void publicar(Mensagem mensagem) throws RemoteException;
    
}
