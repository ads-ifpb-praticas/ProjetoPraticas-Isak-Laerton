/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;

import br.edu.ifpb.praticas.entidades.Orcamento;
import br.edu.ifpb.praticas.entidades.Profissional;
import br.edu.ifpb.praticas.entidades.Qualificacao;
import br.edu.ifpb.praticas.entidades.Solicitacao;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.persistencia.SolicitacaoPersiste;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Classe de serviço para Solicitação
 * @author laerton
 */
@Stateless
public class SolicitacaoService {
    @Inject
    private GenericPersiste<Solicitacao> gpSolicitacao;
    @Inject
    private SolicitacaoPersiste solicitacaop;
    private Solicitacao solicitacao = new Solicitacao();
    /***
     * Método cria uma nova solicitação
     * @param solicitacao - Solicitação a ser persistida no banco
     * @return  - Solicitação após a persistencia.
     */
    public void create (Solicitacao solicitacao){
        this.solicitacao =  gpSolicitacao.create(solicitacao);
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }
    
    /***
     * Atualiza os dados de uma solicitação na base de dados
     * 
     */
    public void edit(){
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
    /***
     * Método lança uma avaliação para uma solicitação concluida
     * @param nota - Nota a ser repassada, sendo maior ou igual a zero e menor ou igual a dez.
     * @param obs - Observação sobre a avaliação.
     * @throws Exception - Não permitido para solicitações já avaliadas ou que ainda não contenham um orçamento fechado
     */
    public void avaliaSolicitacao (int nota, String obs) throws Exception{
        if (solicitacao.isConcluido()) throw  new Exception("Solcitação já foi avaliada.");
        if (!solicitacao.isFechado()) throw  new Exception("Solicitação ainda não foi fehcado orçamento.");
        if (nota < 0 || nota > 10) throw  new Exception("Nota da avaliação deve ser num intervalo de 0 a 10");
        solicitacao.setNota(nota);
        solicitacao.setObsAvaliacao(obs);
        solicitacao.setConcluido(true);
        this.edit();
    }
    
    /***
     * Método aprova um orcamento da solicitação corrente
     * @param orcamento
     * @throws Exception Não permitido para solicitações já fechadas ou cujo orcamento não esteja na lista de orçamentos da mesma.
     */
    public void aprovaOrcamento (Orcamento orcamento) throws Exception{
       atualizaSolicitacao();
       if (this.solicitacao.isFechado()) throw  new Exception("Já existe um orçamento aprovado");
       if (!this.solicitacao.getOrcamentos().contains(orcamento)) throw  new Exception("Orcamento não está registrado na lista de orçamentos da solicitação corrente.");
       
       this.solicitacao.setFechado(true);
       orcamento.setAprovado(true);
       solicitacao.updateOrcamento(orcamento);
       this.edit();
       
    }
    /***
     * Método atualiza a solicitação da classe
     */
    private void atualizaSolicitacao(){
        try {
            this.solicitacao = gpSolicitacao.findEntity(Solicitacao.class, (long) solicitacao.getId());
        } catch (Exception ex) {
            Logger.getLogger(SolicitacaoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    /***
     * Busca pelo orçamento aprovado na lista de orçamento
     * @return Orçamento aprovado
     * @throws Exception caso não encontre nehum orçamento aprovado.
     */
    public Orcamento orcamentoAprovado() throws Exception{
        if (!this.solicitacao.isFechado()) throw  new Exception("Não existe orcameto aprovado");
        
        List<Orcamento> orcamentos = this.solicitacao.getOrcamentos();
        for (Orcamento orcamento : orcamentos) {
            if (orcamento.isAprovado()) return orcamento;
        }
        return null;
    }
    
    /***
     * Desfaz a aprovação de um orçamento
     * @throws Exception - Não permitido para solicitações já concluidas ou sem orçamentos fechados
     */
    public void desaprovaOrcamento() throws Exception{
        if (this.solicitacao.isConcluido())throw  new Exception("Não é possível desaprovar orcamento em uma solicitão já concluida.");
        if (!this.solicitacao.isFechado()) throw  new Exception("Não existe orcamento aprovado!");
        Orcamento orcamento = this.orcamentoAprovado();
        orcamento.setAprovado(false);
        this.solicitacao.updateOrcamento(orcamento);
        this.solicitacao.setFechado(false);
        this.edit();
    }
    
    /***
     * Método dezfaz avaliação retirando o status de concluido da solicitação
     * @throws Exception - Não pertido para solicitações não concluidas.
     */
    public void desfazAvaliacao() throws Exception{
        if (!this.solicitacao.isConcluido()) throw new Exception("Solicitação ainda não contém avaliação");
        this.solicitacao.setNota(0);
        this.solicitacao.setObsAvaliacao("");
        this.solicitacao.setConcluido(false);
        this.edit();
    }
    
    
    
}
