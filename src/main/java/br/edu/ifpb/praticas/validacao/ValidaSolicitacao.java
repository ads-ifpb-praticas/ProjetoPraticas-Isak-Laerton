/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.validacao;

import br.edu.ifpb.praticas.entidades.Solicitacao;
import javax.ejb.Stateless;

/**
 *
 * @author laerton
 */
@Stateless
public  class ValidaSolicitacao {
    /***
     * Método verifica se o intervalo de data é valido.
     * @param solicitacao - Solicitação
     * @return Solicitação repassada
     * @throws Exception - Quando a data inicial é maior que a final
     */
    public static boolean validaIntervaloData(Solicitacao solicitacao) throws Exception {
        if (solicitacao.getDataInicio().compareTo(solicitacao.getDataFim()) >= 1){
            throw  new Exception("Data final não pode ser inferior que a data inicial.");
        }
        return true;
    }
    
    
    
    
    
    
    
}
