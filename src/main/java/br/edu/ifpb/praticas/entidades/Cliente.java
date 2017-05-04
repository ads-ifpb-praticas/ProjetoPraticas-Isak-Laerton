/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.entidades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Isak
 */
@Entity
public class Cliente implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String telefone;
    private String email;
    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Solicitacao> solicitacoes = new LinkedList<>();
        
    public Cliente() {
    }

    public int getId() {
        return id;
    }
    
    public  void addSolicitacao (Solicitacao solicitacao){
        this.solicitacoes.add(solicitacao);
    }
    
    public void remSolicitacao(Solicitacao solicitacao){
        this.solicitacoes.remove(solicitacao);
    }
    
    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome +
               ", telefone=" + telefone + ", email=" + email +
               ", endereco=" + endereco + '}';
    }  
   
    
}
