/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas;

import java.io.Serializable;

/**
 *
 * @author Isak
 */
public class Avaliacao implements Serializable {
    private int id;
    private Cliente cliente;
    private Profissional profissional;
    private int nota;

    public Avaliacao() {
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

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id +
               ", cliente=" + cliente +
               ", profissional=" + profissional +
               ", nota=" + nota + '}';
    }
    
}
