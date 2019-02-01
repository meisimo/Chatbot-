/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSimulator;

/**
 *
 * @author silva
 */
public class Group {
    private StringBuilder  text;
    
    public Group(){
        text = new StringBuilder("");
    }
    
    public String getTxt(){
        return text.toString();
    }
    
    synchronized public void memberLeaves(String memberName){
        text.append("\t").append(memberName).append(" has left the group :(\n\n");
        notifyAll();
    }
    
    synchronized public void pushTxtLn(String memberName,String text){
        this.text.append(memberName).append(": ").append(text).append("\n\n");
        notifyAll();
    }
}
