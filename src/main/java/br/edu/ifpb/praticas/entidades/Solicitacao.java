/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
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
public class Solicitacao implements Serializable {
   
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Cliente cliente;
    
    @OneToMany(mappedBy = "solicitacao")
    private List<Orcamento> orcamentos;
    private boolean fechado;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String horario;
    private int nota;
    private String obsAvaliacao;
    
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private List<Qualificacao> qualificacaos = new LinkedList<>();
    

    public Solicitacao() {
        this.fechado = false;
    }

    public String getObsAvaliacao() {
        return obsAvaliacao;
    }

    public void setObsAvaliacao(String obsAvaliacao) {
        this.obsAvaliacao = obsAvaliacao;
    }

    
    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    
    public void addQualificacao (Qualificacao qualificacao){
        qualificacaos.add(qualificacao);
    }
    
    public void remQualificacao (Qualificacao qualificacao){
        qualificacaos.remove(qualificacao);
    }
    
    public List<Qualificacao> getQualificacaos() {
        return qualificacaos;
    }

    public void setQualificacaos(List<Qualificacao> qualificacaos) {
        this.qualificacaos = qualificacaos;
    }

    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    
    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
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


    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "Solicitacao{" + "id=" + id +
               ", cliente=" + cliente +
               ", data=" + dataInicio + '}';
    }   

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }
   
    
    
}
