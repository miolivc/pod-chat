
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
    boolean login(Usuario usuario) throws RemoteException;
    Grupo grupoByName(String name) throws RemoteException;
    List<Grupo> listaGrupos() throws RemoteException;
    void onChat(Usuario usuario, Subscriber subscriber, Grupo grupo) throws RemoteException;
    void publicar(Mensagem mensagem) throws RemoteException;
    void inscrever(Grupo grupo, Usuario usuario) throws RemoteException;
    
}
