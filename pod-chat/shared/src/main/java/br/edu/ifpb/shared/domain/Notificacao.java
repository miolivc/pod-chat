
package br.edu.ifpb.shared.domain;

import java.io.Serializable;
import java.util.List;

public class Notificacao implements Serializable {
    private Mensagem mensagem;
    private List<Usuario> inscritos;
    private boolean entregue;

    public Notificacao() {
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public List<Usuario> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Usuario> inscritos) {
        this.inscritos = inscritos;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }
    
}
