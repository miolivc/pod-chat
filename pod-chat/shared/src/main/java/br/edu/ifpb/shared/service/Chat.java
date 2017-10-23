
package br.edu.ifpb.shared.service;

import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
    
    void resgistrar(Usuario usuario) throws RemoteException;
    void login(Subscriber subscriber) throws RemoteException;
    void logout(Subscriber subscriber) throws RemoteException;
    
}
