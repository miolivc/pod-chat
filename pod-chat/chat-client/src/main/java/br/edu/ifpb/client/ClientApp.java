package br.edu.ifpb.client;

import br.edu.ifpb.shared.domain.Chat;
import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Mensagem;
import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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
        final SubscriberClient subs = new SubscriberClient();

        while (true) {
            System.out.println("Bem vindo ao sistema..");
            System.out.println("O que deseja fazer? \n1- Cadastrar no chat \n2- Fazer login");
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1: {
                    usuario = cadastrar(chat);
                }
                break;
                case 2: {
                    if (login(chat)) {
                        Grupo grupo = selecionaGrupo(chat);

                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                try {
                                    chat.onChat(usuario, subs, chat.grupoByName(grupo.getNome()));//
                                } catch (RemoteException ex) {
                                    System.err.print("Erro ao receber mensagem: " + ex);
                                }
                            }
                        }, 1000, 10000);

                        while (true) {
                            System.out.println("...");
                            Mensagem mensagem = new Mensagem();
                            mensagem.setBody(scanner.nextLine());//
                            mensagem.setGrupo(chat.grupoByName(grupo.getNome()));
                            mensagem.setRemetente(usuario);
                            mensagem.setTimestamp(LocalDateTime.now());
                            chat.publicar(mensagem);
                        }

                    }
                    System.out.println("Erro ao efetuar login.. Tente novamente");
                }
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

    public static boolean login(Chat chat) throws RemoteException {
        System.out.println("Digite seu nome: ");
        usuario.setNome(scanner.nextLine());

        System.out.println("Digite seu email: ");
        usuario.setEmail(scanner.nextLine());

        return chat.login(usuario);
    }

    public static Grupo selecionaGrupo(Chat chat) throws RemoteException {
        chat.listaGrupos().forEach(System.out::println);
        System.out.print("Digite o nome do grupo desejado: ");
        String nameGroup = scanner.nextLine();
        return chat.listaGrupos()
                .stream().filter((g) -> g.getNome().equalsIgnoreCase(nameGroup))
                .findFirst().get();
    }
}
