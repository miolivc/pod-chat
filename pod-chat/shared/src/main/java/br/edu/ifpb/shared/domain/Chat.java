
package br.edu.ifpb.shared.domain;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public interface Chat extends Remote {

    Usuario inscrever(Usuario usuario) throws RemoteException;
    Chat login(Usuario usuario) throws RemoteException;
    
}
