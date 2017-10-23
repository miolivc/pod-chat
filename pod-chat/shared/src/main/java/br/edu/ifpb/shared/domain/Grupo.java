
package br.edu.ifpb.shared.domain;

import java.io.Serializable;
import java.util.List;

public class Grupo implements Serializable {
    private String nome;
    private List<Usuario> inscritos;

    public Grupo() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Usuario> inscritos) {
        this.inscritos = inscritos;
    }
    
}
