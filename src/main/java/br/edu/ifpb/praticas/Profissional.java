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
public class Profissional implements Serializable {
    private int id;
    private String nome;
    private String telefone;

    public Profissional() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Profissional{" + "id=" + id +
               ", nome=" + nome + 
               ", telefone=" + telefone + '}';
    }
    
    
}
