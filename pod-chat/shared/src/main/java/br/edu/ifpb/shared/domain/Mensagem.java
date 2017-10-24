
package br.edu.ifpb.shared.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mensagem implements Serializable {
    private int id;
    private Usuario remetente;
    private LocalDateTime timestamp;
    private Grupo grupo;
    private String body;

    public Mensagem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "id=" + id + ", remetente=" + remetente + ", timestamp=" + 
                timestamp + ", grupo=" + grupo + ", body=" + body + '}';
    }
    
}
