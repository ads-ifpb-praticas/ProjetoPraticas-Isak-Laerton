/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;

import br.edu.ifpb.praticas.entidades.Cliente;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
@Stateless

public class ClienteService {
    @Inject
    private GenericPersiste<Cliente> gpCliente;
    
    
    public Cliente create (Cliente cliente){
        return gpCliente.create(cliente);
    }
    
    public void edit (Cliente cliente){
        gpCliente.edit(cliente);
    }
    
    public void destroy (Cliente cliente){
        gpCliente.destroy(Cliente.class, (long) cliente.getId());
    }
    
   
   
    
    
    
  
    
    
    
}
