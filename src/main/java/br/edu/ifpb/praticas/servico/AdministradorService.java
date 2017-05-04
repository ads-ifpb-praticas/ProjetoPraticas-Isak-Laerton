/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;


import br.edu.ifpb.praticas.entidades.Usuario;
import br.edu.ifpb.praticas.entidades.uteis.Email;
import br.edu.ifpb.praticas.entidades.uteis.ProdutorQueue;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.persistencia.UsuarioPersiste;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Classe de serviço de Administrador
 * @author laerton
 */
@Stateless
public class AdministradorService {
    @Inject
    private UsuarioPersiste adminp;
    @Inject
    private GenericPersiste<Usuario> gpUsuario;
    @Inject
    private ProdutorQueue produto;
    
    /***
     * Busca por todos os usuários não autorizados;
     * @return - Lista de usuários.
     */
    public List<Usuario>  findByUsuerNaoAutorizados(){
        return adminp.findByUsuariosNaoAutorizados();
    }
    /***
     * Método liberar um usuário para uso no sistema e encaminha um e-mail para o mesmo confirmando
     * @param usuario - Usuário a ser liberado
     */
    public void liberaUsuario(Usuario usuario){
        usuario.setLiberado(true);
        gpUsuario.edit(usuario);
        Email email = new Email("Projeto praticas", usuario.getEmail(), "Autorização de uso", "Usuário autorizado.");
        produto.enviar(email);
    }
    /***
     * Libera todos os usuários pendente no sistema encaminhando um e-mail para cada
     */
    public void liberaAllUsuarios(){
        List<Usuario> lista = findByUsuerNaoAutorizados();
        for (Usuario usuario : lista) {
            liberaUsuario(usuario);
        }
    }
}
