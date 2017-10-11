/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.service;

import br.edu.ifpb.shared.domain.Usuario;
import java.rmi.Remote;

/**
 *
 * @author recursivejr
 */
public interface Chat extends Remote {
    
    void resgistrar(Usuario usuario);
    void login(Usuario usuario);
    void logout(Usuario usuario);
    
}
