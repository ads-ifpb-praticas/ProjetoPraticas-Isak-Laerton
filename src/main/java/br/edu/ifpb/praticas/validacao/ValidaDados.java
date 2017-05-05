/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.praticas.validacao;


import br.edu.ifpb.praticas.entidades.Endereco;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;


/**
 *
 * @author laerton
 */
@Stateless
public class ValidaDados {
    
    public static boolean validaEndereco(Endereco endereco) throws Exception{
        
        if (endereco== null){
            throw  new Exception("Cliente deve ter um endereço informado");
        }
        if (endereco.getRua().trim().equals("")){
            throw new Exception ("Endereço cliente deve ter uma rua, avenida, etc... Informado.");
        }
        if(endereco.getBairro().trim().equals("")){
            throw  new Exception("Endereco cliente deve conter um bairro.");
        }
        
        if (endereco.getRua().length() < 6 || endereco.getRua().length() > 70){
            throw  new Exception("Enderço cliente não pode conter uma rua com menos de 6 endereço e mais de 70 caracteres.");
        }
        
        if (endereco.getNumero() <= 0){
            throw  new Exception("Endereço do cliente não pode conter número menor ou igual a zero.");
        }
        
        if (endereco.getCidade().equals(""))throw  new Exception("Endereço não pode ter o nome da cidade em branco.");
        
        if (endereco.getCidade().length() > 50) throw  new Exception ("Cidade não pode conter nome com mais de 50 caracteres.");
        
        return true;
    }
    
    /***
     * Método valida nome conforme a regra de negócio da aplicação
     * @param nome - Nome a ser analiasado
     * @return - Bolleando de confirmaçao
     * @throws Exception -Valida que nome não pode ser vazio, conter caractres especiais e deve ter tamanho mínimo de 5 e máximo de 70 caractres.
     */
    public static boolean validaNome (String nome) throws Exception{
        if (nome.trim().equals("")) throw  new Exception("Cliente não pode conter nome vazio!");
        Pattern pattern = Pattern.compile(" ^[[ ]|\\p{L}*]+$");
        Matcher match = pattern.matcher(nome);
        if (!match.find()) throw  new Exception("Cliente não pode conter caracteres especiais");
        if (nome.length() < 5 || nome.length() > 70) throw new Exception("Cliente não pode ter nome maior que 70 e menor que 5 caracteres");
        return true;
    }
    
    public static boolean validaEmail (String email) throws Exception{
        if (email.trim().equals("")) throw  new Exception("Email não pode ser em branco");
        if (!email.contains("@")) throw  new Exception("Email inválido.");
        return true;
    }
    
    
    
    
}
