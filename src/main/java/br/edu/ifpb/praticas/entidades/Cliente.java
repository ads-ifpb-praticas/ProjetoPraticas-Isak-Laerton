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
import javax.persistence.OneToMany;

/**
 *
 * @author Isak
 */
@Entity
public class Cliente extends Usuario implements Serializable {
    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Solicitacao> solicitacoes = new LinkedList<>();
        
    public Cliente() {
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
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + super.getId() + ", nome=" + super.getNome() +
               ", telefone=" + super.getTelefone() + ", email=" + super.getEmail() +
               ", endereco=" + endereco + '}';
    }  
   
    
}