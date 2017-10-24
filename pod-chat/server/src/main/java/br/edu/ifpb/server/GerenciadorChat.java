package br.edu.ifpb.server;

import br.edu.ifpb.shared.domain.Chat;
import br.edu.ifpb.shared.domain.Grupo;
import br.edu.ifpb.shared.domain.Mensagem;
import br.edu.ifpb.shared.domain.Notificacao;
import br.edu.ifpb.shared.domain.Subscriber;
import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GerenciadorChat extends UnicastRemoteObject implements Chat {

    private GerenciadorUsuario gUsuario = new GerenciadorUsuario();
    private GerenciadorGrupo gGrupo = new GerenciadorGrupo();
    private GerenciadorMensagem gMensagem = new GerenciadorMensagem();
    private GerenciadorNotificacao gNotificacao = new GerenciadorNotificacao();

    public GerenciadorChat() throws RemoteException {
        this.gGrupo.criar(new Grupo("Grupo1"));
        this.gGrupo.criar(new Grupo("Grupo2"));
        this.gGrupo.criar(new Grupo("Grupo3"));
    }

    @Override
    public Usuario inscrever(Usuario usuario) {
        if (gUsuario.registrar(usuario)) {
            return usuario;
        }
        return null;
    }

    @Override
    public boolean login(Usuario usuario) {
        return gUsuario.login(usuario);
    }

    @Override
    public Grupo grupoByName(String name) {
        return gGrupo.recuperar(name);
    }

    @Override
    public List<Grupo> listaGrupos() {
        return gGrupo.existentes();
    }

    @Override
    public void inscrever(Grupo grupo, Usuario usuario) {
        gGrupo.inscrever(usuario, grupo);
    }

    @Override
    public void onChat(Usuario usuario, Subscriber subscriber, Grupo grupo) throws RemoteException {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Entrou aqui.. A enviar notificaçao...");
                gUsuario.logado(usuario);
                List<Notificacao> notify = gNotificacao.recuperaNotificacao(usuario, gGrupo.recuperar(grupo.getNome()));
                System.out.println("------> NOTIFICACOES GERAIS: " + notify.size());
                notify.forEach((Notificacao n) -> {
                    try {
                        subscriber.receber(n.getMensagem());
                    } catch (RemoteException ex) {
                        System.err.println(ex);
                    }
                });
                gNotificacao.recuperaNotificacao(usuario, grupo);
            }
        }, 0, 500);
    }

    @Override
    public void publicar(Mensagem mensagem) throws RemoteException {
        gMensagem.publicar(mensagem);
        Grupo grupo = grupoByName(mensagem.getGrupo().getNome());
        System.out.println("Inscritos no grupinho: " + grupo.getInscritos().size() + " inscritos");
        gNotificacao.criaNotificacao(mensagem, grupo);
    }

}
