
package br.edu.ifpb.shared.domain;

import java.io.Serializable;

public class Notificacao implements Serializable {
    private Mensagem mensagem;
    private Usuario inscrito;
    private boolean entregue;

    public Notificacao(Mensagem mensagem, Usuario usuario) {
        this.mensagem = mensagem;
        this.inscrito = inscrito;
        this.entregue = false;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getInscrito() {
        return inscrito;
    }

    public void setInscrito(Usuario inscrito) {
        this.inscrito = inscrito;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    @Override
    public String toString() {
        return "Notificacao{" + "mensagem=" + mensagem + ", inscrito="
                + inscrito + ", entregue=" + entregue + '}';
    }

}
