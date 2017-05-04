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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Isak
 */
@Entity
public class Profissional implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String telefone;
    
    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Orcamento> orcamentos;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Qualificacao> qualificacaos;
    
    public Profissional() {
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
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
        return "Profissional{" + "id=" + id +
               ", nome=" + nome + 
               ", telefone=" + telefone + '}';
    }
    
    
}
