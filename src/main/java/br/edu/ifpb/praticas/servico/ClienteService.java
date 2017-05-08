/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;

import br.edu.ifpb.praticas.entidades.Cliente;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.validacao.ValidaCPF;
import br.edu.ifpb.praticas.validacao.ValidaDados;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Classe de serviços de cliente
 * @author laerton
 */
@Stateless

public class ClienteService {
    @Inject
    private GenericPersiste<Cliente> gpCliente;
    
    
    /***
     * Método atualiza dados de um cliente no banco de dados 
     * @param cliente - Cliente cujo dados serão atualizados
     * @throws Exception - Valida os dados do cliente
     */
    public void edit (Cliente cliente) throws Exception{
        validaCliente(cliente);
        gpCliente.edit(cliente);
    }
    /***
     * Remove um cliente da base de dados
     * @param cliente - Cliente que será removido.
     */
    public void destroy (Cliente cliente){
        gpCliente.destroy(Cliente.class, (long) cliente.getId());
    }
    /***
     * Valida os dados de um cliente
     * @param cliente - Cliente que terá os dados validados
     * @throws Exception  - Valida os dados como, nome, cpf e endereço 
     */
    private void validaCliente(Cliente cliente) throws Exception{
        ValidaDados.validaNome(cliente.getNome());
        ValidaDados.validaEndereco(cliente.getEndereco());
        ValidaDados.validaEmail(cliente.getEmail());
        ValidaCPF.isCPF(cliente.getCpf());
    }
    
    
   
   
    
    
    
  
    
    
    
}
