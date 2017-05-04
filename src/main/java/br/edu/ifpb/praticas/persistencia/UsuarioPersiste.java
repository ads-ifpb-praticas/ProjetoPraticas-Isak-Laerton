/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.persistencia;

import br.edu.ifpb.praticas.entidades.Cliente;
import br.edu.ifpb.praticas.entidades.Profissional;
import br.edu.ifpb.praticas.entidades.Usuario;
import java.util.LinkedList;
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
public class UsuarioPersiste {
    @PersistenceContext(unitName =  "praticas-PU")
    protected EntityManager em;
    /***
     * Busca por todos os usuários que são admisniradores no sistema 
     * @return Lista de usuários.
     */
    public List<Usuario> findByUsuariosAdministrador(){
        List<Usuario> lista = new LinkedList<>();
        lista.addAll(findByClienteAdministrador());
        lista.addAll(findByProfissionalAdministrador());
        return lista;
    }
    /**
     * Busca por todos os Usuários do tipo cliente que são administradores do sistema
     * @return Lista de Usuários
     */
    private List<Usuario> findByClienteAdministrador(){
       Query q = em.createQuery("Select c from Cliente as c WHERE c.admistrador = true", Cliente.class);
       return q.getResultList();
    }
    /***
     * Busca por todos os usuários Profissionais que são adminsitradores do sistema
     * @return Lista de usuários.
     */
    private List<Usuario> findByProfissionalAdministrador(){
       Query q = em.createQuery("Select p from Profissional as p WHERE p.admistrador = true", Profissional.class);
       return q.getResultList();
    }
    
    /***
     * Busca por todos os usuários que estão pendentes de autorização
     * @return - Lista de usuários.
     */
    public List<Usuario> findByUsuariosNaoAutorizados(){
        List<Usuario> lista = new LinkedList<>();
        lista.addAll(findByClientesNaoAutorizados());
        lista.addAll(findByProfissionaisNaoAutorizados());
        return lista;
    }
    /***
     * Buscas por usuários do tipo cliente não autorizados  
     * @return - Lista de usuários
     */
    private List<Usuario> findByClientesNaoAutorizados(){
       Query q = em.createQuery("Select c from Cliente as c WHERE c.liberado = false", Cliente.class);
       return q.getResultList();
    }
    /**
     * Busca por usuários do tipo profissional que não estão autorizados
     * @return - Lista de usuários.
     */
    private List<Usuario> findByProfissionaisNaoAutorizados(){
       Query q = em.createQuery("Select p from Profissional as p WHERE p.liberado = FALSE", Profissional.class);
       return q.getResultList();
    }
}
