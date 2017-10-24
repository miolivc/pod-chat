
package br.edu.ifpb.shared.domain;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nome;
    private String email;

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + '}';
    }
    
}
