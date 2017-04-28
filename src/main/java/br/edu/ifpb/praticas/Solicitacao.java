/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Isak
 */
public class Solicitacao implements Serializable {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private LocalDate data;

    public Solicitacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "id=" + id +
               ", cliente=" + cliente +
               ", servico=" + servico +
               ", data=" + data + '}';
    }   
   
    
}
