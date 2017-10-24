
package br.edu.ifpb.shared.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Grupo implements Serializable {
    private String nome;
    private List<Usuario> inscritos = new ArrayList<>();

    public Grupo() {
    }

    public Grupo(String nome) {
        this.nome = nome;
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Grupo{" + "nome=" + nome + "}";
    }
    
}
