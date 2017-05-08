/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Isak
 */
@Entity
public class Profissional extends Usuario implements Serializable {
    
    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Orcamento> orcamentos;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Qualificacao> qualificacaos;
    
    public Profissional() {
    }

    public Profissional(String nome, String email, String cpf) {
        super(nome, email, cpf);
    }

    
    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
    
    
    
    public void addOrcamento(Orcamento orcamento){
        orcamentos.add(orcamento);
    }
    
    public void remOrcamento(Orcamento orcamento){
        orcamentos.remove(orcamento);
    }

    public List<Qualificacao> getQualificacaos() {
        return qualificacaos;
    }

    public void setQualificacaos(List<Qualificacao> qualificacaos) {
        this.qualificacaos = qualificacaos;
    }
    
    public void addQualificacao (Qualificacao qualificacao){
        qualificacaos.add(qualificacao);
        
    }
    
    public void remQualificacao (Qualificacao qualificacao){
        qualificacaos.remove(qualificacao);
    }

    @Override
    public String toString() {
        return "Profissional{" + "id=" + super.getId() +
               ", nome=" + super.getNome() + 
               ", telefone=" + super.getTelefone() + '}';
    }
    
    
}
