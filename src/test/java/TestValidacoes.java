/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpb.praticas.entidades.Cliente;
import br.edu.ifpb.praticas.entidades.Endereco;
import br.edu.ifpb.praticas.entidades.Usuario;
import br.edu.ifpb.praticas.validacao.ValidaCPF;
import br.edu.ifpb.praticas.validacao.ValidaDados;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laerton
 */
public class TestValidacoes {
    
    public TestValidacoes() {
    }
    
    private static Endereco endereco;
    private static Usuario usuario;
    
    @BeforeClass
    public static void setUpClass() {
        usuario = new Cliente("Laerton Marques de Figueiredo", "laertonmarques@uol.com.br", "02013285426");
        
    }

     @Test
     public void testaEndereco() throws Exception  
     {
        try {
            ValidaDados.validaEndereco(usuario.getEndereco());
        } catch (Exception ex) {
            assertEquals("", "Cliente deve ter um endereço informado", ex.getMessage());
        }
         endereco = new Endereco("Rua dep. Manuel Gonçalves", "Areias", 133, "Sousa", "PB");
         usuario.setEndereco(endereco);
         assertTrue(ValidaDados.validaEndereco(usuario.getEndereco()));
         
         try {
            endereco = new Endereco("", "Areias", 133, "Sousa", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
             assertEquals("", "Endereço cliente deve ter uma rua, avenida, etc... Informado.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("Rua dep. Manuel Gonçalves", "", 133, "Sousa", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Endereco cliente deve conter um bairro.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("Rua", "Areias", 133, "Sousa", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Enderço cliente não pode conter uma rua com menos de 6 endereço e mais de 70 caracteres.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "Areias", 133, "Sousa", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Enderço cliente não pode conter uma rua com menos de 6 endereço e mais de 70 caracteres.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("Rua Dep. Manuel Gonçalves", "Areias", 0, "Sousa", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Endereço do cliente não pode conter número menor ou igual a zero.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("Rua Dep. Manuel Gonçalves", "Areias", -1, "Sousa", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Endereço do cliente não pode conter número menor ou igual a zero.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("Rua Dep. Manuel Gonçalves", "Areias", 133, "", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Endereço não pode ter o nome da cidade em branco.", e.getMessage());
         }
         try {
            endereco = new Endereco("Rua Dep. Manuel Gonçalves", "Areias", 133, "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", "PB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "Cidade não pode conter nome com mais de 50 caracteres.", e.getMessage());
         }
         
         try {
            endereco = new Endereco("Rua dep. Manuel Gonçalves", "Areias", 133, "Sousa", "");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "UF do endereço não pode ficar em branco.", e.getMessage());
         }
         try {
            endereco = new Endereco("Rua dep. Manuel Gonçalves", "Areias", 133, "Sousa", "P");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "UF não pode conter mais ou menos que 2 caracteres", e.getMessage());
         }
         try {
            endereco = new Endereco("Rua dep. Manuel Gonçalves", "Areias", 133, "Sousa", "PBB");
            ValidaDados.validaEndereco(endereco);
         } catch (Exception e) {
            assertEquals("", "UF não pode conter mais ou menos que 2 caracteres", e.getMessage());
         }
         
         
     }
     
     @Test
     public void testaValidaCPF(){
         assertTrue(ValidaCPF.isCPF(usuario.getCpf()));
         String CPF = "11111111111";
         assertFalse(ValidaCPF.isCPF(CPF));
         CPF = "11111111115";
         assertFalse(ValidaCPF.isCPF(CPF));
     }
     
     @Test
     public void testaValidaNome() throws Exception{
         assertTrue(ValidaDados.validaNome(usuario.getNome()));
         String nome = "Laerton Marques de Figueiredo $";
         assertTrue(ValidaDados.isCaractresEspecias(nome));
         nome = " ";
         try {
             ValidaDados.validaNome(nome);
         } catch (Exception e) {
             assertEquals("", "Cliente não pode conter nome vazio!", e.getMessage());
         }
         
         nome = "Lae";
         try {
             ValidaDados.validaNome(nome);
         } catch (Exception e) {
             assertEquals("", "Cliente não pode ter nome maior que 70 e menor que 5 caracteres", e.getMessage());
         }
         
         nome = "jsdfkljgsiutroeifkseyrfuwlsjfoiuesorfoiuco sieufiseyfihsicyieryfisyerfiewyfiyweifyiweyrifywerifweisfhjevyegwekirycbeyiesryciryeifyurskuvgryutgyerykryguyflsevirgives";
         try {
             ValidaDados.validaNome(nome);
         } catch (Exception e) {
             assertEquals("", "Cliente não pode ter nome maior que 70 e menor que 5 caracteres", e.getMessage());
         }
         
     }
     
     @Test
     public void validaEmail() throws Exception{
         assertTrue(ValidaDados.validaEmail(this.usuario.getEmail()));
         try {
             ValidaDados.validaEmail("laertonmarques.com.br");
         } catch (Exception e) {
             assertEquals("", "Email inválido.", e.getMessage());
         }
         
         try {
             ValidaDados.validaEmail("");
         } catch (Exception e) {
             assertEquals("", "Email não pode ser em branco", e.getMessage());
         }
     }
}
