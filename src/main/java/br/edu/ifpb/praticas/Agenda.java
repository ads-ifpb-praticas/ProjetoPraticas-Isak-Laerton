/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas;

import java.util.List;

/**
 *
 * @author Isak
 */
public class Agenda {
    private Profissional profissional;
    private List<Solicitacao> listaDeSolicitacoes;
    private List<Solicitacao> listaDeSolicitacoesAtendidas;

    public Agenda() {
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public List<Solicitacao> getListaDeSolicitacoes() {
        return listaDeSolicitacoes;
    }

    public void setListaDeSolicitacoes(List<Solicitacao> listaDeSolicitacoes) {
        this.listaDeSolicitacoes = listaDeSolicitacoes;
    }

    public List<Solicitacao> getListaDeSolicitacoesAtendidas() {
        return listaDeSolicitacoesAtendidas;
    }

    public void setListaDeSolicitacoesAtendidas(List<Solicitacao> listaDeSolicitacoesAtendidas) {
        this.listaDeSolicitacoesAtendidas = listaDeSolicitacoesAtendidas;
    }
    
}
