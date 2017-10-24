
package br.edu.ifpb.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class ServerApp {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        GerenciadorChat chat = new GerenciadorChat();
        Registry registry = LocateRegistry.createRegistry(10999);
        registry.bind("Chat", chat);
        System.out.println("Servidor ativo!");
        
    }
    
}
