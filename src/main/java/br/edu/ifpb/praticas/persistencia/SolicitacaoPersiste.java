/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.persistencia;

import br.edu.ifpb.praticas.entidades.Profissional;
import br.edu.ifpb.praticas.entidades.Qualificacao;
import br.edu.ifpb.praticas.entidades.Solicitacao;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Classe de serviço de Solicitações 
 * @author laerton
 */
@Stateless
public class SolicitacaoPersiste {
    @PersistenceContext(unitName =  "praticas-PU")
    protected EntityManager em;
    /***
     * Método encarregado de buscar por todas as solicitações a partir da qualificação repassada.
     * @param qualificacao - Qualificação usada para filtra
     * @return - Lista de solicitações encontradas.
     */
    public List<Solicitacao> findAllSolicitacoesByQualificacao(Qualificacao qualificacao){
       Query q = em.createQuery("Select s from Solicitacao as s LEFT JOIN s.qualificacaos as q WHERE q =:qualificacao and s.fechado = false", Qualificacao.class);
       q.setParameter("qualificacao", qualificacao);
       return q.getResultList();
    }
    
    /***
     * Método encarregado de buscar as solicitações que contenha alguma das qualificações repassadas como paramentros
     * @param qualificacaos - Qualificações usadas como filtro
     * @return - Lista de Solicitações.
     */
    public List<Solicitacao> findAllSolicitacoesByQualificacoes(List<Qualificacao> qualificacaos){
        List<Solicitacao> resposta = new LinkedList<>();
        for (Qualificacao qualificacao : qualificacaos) {
            resposta.addAll(findAllSolicitacoesByQualificacao(qualificacao));
        }
        return resposta;
    }
    
    /***
     * Busca por todas as solicitaṍes fechadas realizadas e qualificadas por proficional.
     * @param profissional - Profissional usado como filtro
     * @return - Lista de solicitações
     */
    public List<Solicitacao> findSolicitacoesFechadasByProfissional(Profissional profissional){
        Query q = em.createQuery("Select s from Solicitacao as s LEFT JOIN s.orcamentos as o Where o.profissional= profissional and s.fechado = true", Solicitacao.class);
        q.setParameter("profissional", profissional);
        return q.getResultList();
    }
    
    
    
    
}
