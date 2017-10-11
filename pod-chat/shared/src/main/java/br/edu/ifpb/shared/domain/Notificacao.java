/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author recursivejr
 */
public class Notificacao implements Serializable {
    private Mensagem mensagem;
    private List<Usuario> inscritos;

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
    
}
