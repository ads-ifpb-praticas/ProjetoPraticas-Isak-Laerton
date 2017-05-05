package br.edu.ifpb.praticas.uteis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author laerton
 */
@MessageDriven(activationConfig = {@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/dac/Queue")})
public class ConsumidorQueueMDB implements MessageListener{
    //private ServiceEviarEmail service;
    private final String email =   "hrecruta.dac@gmail.com";
    private final String senha = "senha123456";
    @Override
    public void onMessage(Message message) {
        try {
            Email body = message.getBody(Email.class);
            JavaMailClass mail = new JavaMailClass();
            mail.envia(email, senha, body.getDestinatario(), body.getTitulo(),body.getCorpo());
        } catch (Exception e) {
        }
    }
    
}
