/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsimulator.gui.exception;

/**
 *
 * @author Sebastian
 */
public class EmptyInputException extends Exception {
    
    public EmptyInputException(){
        super();
    }
    
    @Override
    public String getMessage(){
        return "Error al intentar enviar un mensage vacío:\n\tLos mensajes enviados "+
                "deben de poseer almenos un caracter y el mensaje enviado estaba vacío";
    }
    
}
