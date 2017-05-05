/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.persistencia;

import br.edu.ifpb.praticas.entidades.Orcamento;
import br.edu.ifpb.praticas.entidades.Profissional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author laerton
 */
@Stateless
public class OrcamentoPersiste {
    @PersistenceContext(unitName =  "praticas-PU")
    protected EntityManager em;
    
    /***
     * Busca por todos os orçamento aprovados por profissional ordenado por data e hora
     * @param profissional - Profissional usado como filtro
     * @return - Lista de Orçamentos
     */
     public List<Orcamento> findAllOrcamentosAprovadosByProfissional(Profissional profissional){
        Query q = em.createQuery("Select o from Orcamento as o  Where o.profisisional:= profissional and o.aprovado = true ORDER BY  o.data,o.hora ASC ", Orcamento.class);
        q.setParameter("profissional", profissional);
        return q.getResultList();
     }
}
