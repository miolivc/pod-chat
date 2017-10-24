
package br.edu.ifpb.client;

import br.edu.ifpb.shared.domain.Chat;
import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

/**
 *
 * @author miolivc
 * @mail miolivc@outlook.com
 * @since 24/10/2017
 */

public class ClientApp {

    public static Usuario usuario = new Usuario();
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        Chat chat = (Chat) LocateRegistry.getRegistry(10999).lookup("Chat");
        
        System.out.println("O que deseja fazer? \n1- Cadastrar no chat \n2- Fazer login");
        int opt = scanner.nextInt();    scanner.nextLine();
        
        switch(opt) {
            case 1: {
                usuario = cadastrar(chat);
            } break;
            case 2: {
                chat = chat.login(usuario);
                if (! chat.equals(null)) {
                    System.out.println("Bem vindo ao sistema..");
                    while (true) {
                        
                    }
                }
                System.out.println("Erro ao efetuar login.. Tente novamente");
            }
        }
        
    }
    
    public static Usuario cadastrar(Chat chat) throws RemoteException {
        
        System.out.println("Insira seu nome: ");
        usuario.setNome(scanner.nextLine());
        
        System.out.println("Insira seu email: ");
        usuario.setEmail(scanner.nextLine());
        
        usuario = chat.inscrever(usuario);
        
        if (usuario != null) {
            System.out.println("Usuario cadastrado com sucesso! Efetue login.");
        } else {
            System.out.println("Nao foi possivel cadastrar usuario!");
        }
        
        return usuario;
    }
    
}
