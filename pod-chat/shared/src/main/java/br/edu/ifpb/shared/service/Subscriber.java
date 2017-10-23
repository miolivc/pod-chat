
package br.edu.ifpb.shared.service;

import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Mensagem;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subscriber extends Remote {
    
    void inscrever(Grupo grupo) throws RemoteException;
    void receber(Mensagem mensagem) throws RemoteException;
    
}
