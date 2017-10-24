
package br.edu.ifpb.shared.domain;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public interface Chat extends Remote {

    Usuario inscrever(Usuario usuario) throws RemoteException;
    Chat login(Usuario usuario) throws RemoteException;
    List<Grupo> listaGrupos() throws RemoteException;
    void onChat(Usuario usuario, Subscriber subscriber, Grupo grupo) throws RemoteException;
    
}
