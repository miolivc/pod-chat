/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.shared.service;

import br.edu.ifpb.shared.domain.Mensagem;

/**
 *
 * @author recursivejr
 */
public interface Subscriber {
    
    void receber(Mensagem mensagem);
    
}
