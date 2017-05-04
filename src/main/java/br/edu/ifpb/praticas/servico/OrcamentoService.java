/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;
import br.edu.ifpb.praticas.entidades.Orcamento;
import br.edu.ifpb.praticas.entidades.Profissional;

import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.persistencia.OrcamentoPersiste;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Classe encarregada dos servicos de Orçamento
 * @author laerton
 */
@Stateless
public class OrcamentoService {
    @Inject
    private GenericPersiste<Orcamento> gpOrcamento;
    @Inject
    private OrcamentoPersiste orcamentop;
    
    public Orcamento create (Orcamento orcamento){
        return gpOrcamento.create(orcamento);
    }
    
    public void edit(Orcamento orcamento){
        gpOrcamento.edit(orcamento);
    }
    
    public void destroy (Orcamento orcamento){
       gpOrcamento.destroy(Orcamento.class, (long) orcamento.getId());
    }
    /***
     * Busca por uma lista de orçamentos aprovados filtrados por profissional em ordem crscente de date e hora.
     * @param profissional - Profissional usado como filtro
     * @return  lista de orçamento
     */
    public List<Orcamento> findAllOrcamentosAprovadosByProfissional(Profissional profissional){
        return orcamentop.findAllOrcamentosAprovadosByProfissional(profissional);
    }
    
    
    
    
    
}
