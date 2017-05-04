/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.persistencia;




import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author laerton
 */
@Stateless
public class GenericPersiste<T> {

    @PersistenceContext(unitName =  "praticas-PU")
    protected EntityManager em;
    
    
    public T create(T obj) {
        
         em.persist(obj);
         return obj;
    }

   
    
    public void edit(T obj) {
        em.merge(obj);
    }



    
    public void destroy(Class<T> classe, Long id) {
        T f = null;
        try {
            f = this.findEntity(classe, id);
        } catch (Exception ex) {
            Logger.getLogger(GenericPersiste.class.getName()).log(Level.SEVERE, null, ex);
        }
        em.remove(f);
    }

    
    public T findEntity(Class<T> classe, Long id) throws Exception {
        T find = em.find(classe, id);
        if (find == null){
            throw new Exception ("Dados não localizados");
        }
        return find;

    }

    
    public List<T> findEntities(Class<T> classe) {
        Query resposta;
        resposta = em.createQuery("Select e from " + classe.getName() +" as e", classe);
        return resposta.getResultList();
    }

    
    public List<T> findEntities(Class<T> classe, int maxResults, int firstResult) {
        Query q = em.createQuery("Select e from " + classe.getName() +" as e", classe);
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
            return q.getResultList();
    }

    
    public int getEntityCount(Class<T> classe) {
        Query q = em.createQuery("Select e from " + classe.getName() +" as e", classe);
        return ((Long) q.getSingleResult()).intValue();
    }

    
    
}
