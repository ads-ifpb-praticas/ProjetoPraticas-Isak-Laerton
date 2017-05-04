/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.entidades;

import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 *
 * @author laerton
 */
@MappedSuperclass
public abstract class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nome;

    @Basic
    @NotNull(message="E-mail eh obrigatorio")
    private String email;
    private String senha;
    private boolean admistrador;
    private String telefone;
    private boolean liberado = false;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmistrador() {
        return admistrador;
    }

    public void setAdmistrador(boolean admistrador) {
        this.admistrador = admistrador;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
