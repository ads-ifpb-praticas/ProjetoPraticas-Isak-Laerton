/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.servico;

import br.edu.ifpb.praticas.entidades.Usuario;
import br.edu.ifpb.praticas.uteis.Email;
import br.edu.ifpb.praticas.uteis.ProdutorQueue;
import br.edu.ifpb.praticas.persistencia.GenericPersiste;
import br.edu.ifpb.praticas.persistencia.UsuarioPersiste;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Classe de serviço para Usuário
 * @author laerton
 */
@Stateless
public class UsuarioService {
    @Inject
    private GenericPersiste<Usuario> gpUsuario;
    @Inject
    private ProdutorQueue produtor;
    @Inject
    private UsuarioPersiste userp;
    
    private final String emailRemetente =   "hrecruta.dac@gmail.com";
    
    /***
     * Métoto cria um novo usuário não liberado e ecaminha e-mail para os adminsitradores para que possa desbloque-lo
     * @param usuario - Usuário a ser persistido
     * @return - Usuário persistido.
     */
    public Usuario create (Usuario usuario){
        usuario= gpUsuario.create(usuario);
        Email email = new Email(emailRemetente, emailsAdministrador(), "Confirmacao de cadastro", "Existe usuarios pendentes de autorização.");
        produtor.enviar(email);
        return usuario;
    }
        
    
   /***
    * Métodod encarregado de coletar os e-mails de todos os administradores no banco de dados
    * @return String formada com os e-mails dos administradores.
    */
    private String emailsAdministrador() {
        String emails ="";
        List<Usuario> lista = this.userp.findByUsuariosAdministrador();
        int i = 1;
        for (Usuario usuario : lista) {
            emails += usuario.getEmail() +((i != lista.size())? ",":"");
            i++;
        }
        return emails;
    }
    
}
