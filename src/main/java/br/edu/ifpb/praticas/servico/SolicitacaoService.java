/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;

import br.edu.ifpb.praticas.entidades.Profissional;
import br.edu.ifpb.praticas.entidades.Qualificacao;
import br.edu.ifpb.praticas.entidades.Solicitacao;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.persistencia.SolicitacaoPersiste;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author laerton
 */
@Stateless
public class SolicitacaoService {
    @Inject
    private GenericPersiste<Solicitacao> gpSolicitacao;
    @Inject
    private SolicitacaoPersiste solicitacaop;
    /***
     * Método cria uma nova solicitação
     * @param solicitacao - Solicitação a ser persistida no banco
     * @return  - Solicitação após a persistencia.
     */
    public Solicitacao create (Solicitacao solicitacao){
        return  gpSolicitacao.create(solicitacao);
    }
    /***
     * Atualiza os dados de uma solicitação na base de dados
     * @param solicitacao - Solicitação a ser atualizada
     */
    public void edit(Solicitacao solicitacao){
        gpSolicitacao.edit(solicitacao);
    }
    /***
     * Lista todas as solicitações cadastradas
     * @return - Lista de solicitações 
     */
    public List<Solicitacao> findAllSolicitacoes(){
        return gpSolicitacao.findEntities(Solicitacao.class);
    }
    
    /***
     * Busca por uma solicitação a partir do id repassado
     * @param id - Id da solicitação 
     * @return - Solicitação localizada
     * @throws Exception - Lançadada quando não é localizado a solicitação
     */
    public Solicitacao findSolicitacaoById(int id) throws Exception{
        return gpSolicitacao.findEntity(Solicitacao.class,(long) id);
    }
    /***
     * Lista todas as solicitações filtradas pela qualificação repassada
     * @param qualificacao - Qualificação usada como filtro
     * @return - Lista de Solicitações
     */
    public List<Solicitacao> findSolicitacoesByQualificacao(Qualificacao qualificacao){
        return  solicitacaop.findAllSolicitacoesByQualificacao(qualificacao);
    }
    
    /***
     * Busca por Solicitações que contenham alguma das qualificações repassdas
     * @param qualificacaos - Lista de qualificações usadas como filtro
     * @return  - Lista de solicitações encontradas.
     */
    public List<Solicitacao> findSolicitacoesByQualificacoes(List<Qualificacao> qualificacaos){
        return  solicitacaop.findAllSolicitacoesByQualificacoes(qualificacaos);
    }
    
    /***
     * Busca por solicitações fechadas e avaliadas por Profissional
     * @param profissional - Profissional avaliado
     * @return - Lista de solicitações.
     */
    public List<Solicitacao> findSolicitacoesFechadasByProfissional(Profissional profissional){
        return solicitacaop.findSolicitacoesFechadasByProfissional(profissional);
    }
    
    
    
}
