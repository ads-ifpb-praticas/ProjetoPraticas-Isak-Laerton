/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;

import br.edu.ifpb.praticas.entidades.Orcamento;
import br.edu.ifpb.praticas.entidades.Profissional;
import br.edu.ifpb.praticas.entidades.Solicitacao;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.persistencia.OrcamentoPersiste;
import br.edu.ifpb.praticas.persistencia.SolicitacaoPersiste;
import br.edu.ifpb.praticas.validacao.ValidaCPF;
import br.edu.ifpb.praticas.validacao.ValidaDados;
import java.security.Timestamp;
import java.sql.SQLData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.inject.Inject;

/**
 *
 * @author laerton
 */
public class ProfissionalService {
    @Inject
    private GenericPersiste<Profissional> gpProfissional;
    @Inject
    private OrcamentoPersiste orcamentop;
    @Inject
    private SolicitacaoPersiste solicitap;
    private Profissional profissional;
    /***
     * Atualiza os dados de um profissional no banco de dados 
     * @param profissional - Profisisional que tera os dados aualizados
     * @throws Exception - Valida dados de um profissional.
     */
    public void edita() throws Exception{
        ValidaDados.validaNome(profissional.getNome());
        ValidaDados.validaEndereco(profissional.getEndereco());
        ValidaDados.validaEmail(profissional.getEmail());
        ValidaCPF.isCPF(profissional.getCpf());
        gpProfissional.edit(profissional);
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
    
    /***
     * Método retorna uma lista de solicitações lançadas baseada na qualificações do profissional em questão
     * @return - Lista de solicitações.
     * @throws Exception - Somente se setado um profissional.
     */
    public List<Solicitacao> findSolicitacoesByQualificacao() throws Exception{
        if (profissional == null) throw new Exception("Profissional não definido");
        return solicitap.findAllSolicitacoesByQualificacoes(this.profissional.getQualificacaos());
    }
    /****
     * Adiciona um orçamento 
     * @param orcamento - Orcamento a ser adicionado
     * @throws Exception - Caso a solicitação já tem orçaemnto registrado será negada. Se a data e hora agendada já contem compromisso.
     */
    public void addOrcamento(Orcamento orcamento) throws Exception{
        if (orcamento.getSolicitacao() == null) throw new Exception("Obrigatório ter uma solicitação vinculada a orçamento");
        if (!dataIsFree(orcamento.getData(), orcamento.getHora()))throw  new Exception("Já existe outro orçamento agendado para o mesmo dia e horário");
        this.profissional.addOrcamento(orcamento);
        this.edita();
    }
    /***
     * Consulta se a data e hora informada está liberada para agendar
     * @param data - data a ser verificada
     * @param hora - hora a ser verificada
     * @return - boleano de cionfirmação..
     */
    private boolean dataIsFree(LocalDate data, Timestamp hora) {
        List<Orcamento> orcamentos = orcamentop.findAllOrcamentosAprovadosByProfissional(this.profissional);
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("MMddyyyy");
        String sDate = data.format(dft);
        String sHora = hora.getTimestamp().getHours() + ":" + hora.getTimestamp().getMinutes();
        for (Orcamento orcamento : orcamentos) {
            String orcHora = orcamento.getHora().getTimestamp().getHours() + ":" + orcamento.getHora().getTimestamp().getMinutes();
            if (sDate.equals(orcamento.getData().format(dft)) && orcHora.equals(sHora)){
                return true;
            }
        }
        return true;
    }
    
    /***
     * Retorna todas as solicitações fechadas para um profissional
     * @return - Lista de coslicitações 
     */
    public List<Solicitacao> allSolicitações (){
        return solicitap.findSolicitacoesFechadasByProfissional(this.profissional);
    }
}
