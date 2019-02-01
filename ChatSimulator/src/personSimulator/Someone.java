/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personSimulator;
import serverSimulator.Member;
import chatsimulator.gui.ChatGUI;
import serverSimulator.Group;
/**
 *
 * @author silva
 */
public class Someone implements Runnable {
    private Member info;
    private Thread trd;
    private ChatGUI chat;
    private Group src;
    
    public Someone(String name, short age, String number){
        info = new Member(name, number, age);
        trd  = new Thread(this,name);
    }
    
    public void openTheChat(Group src){
        this.src = src;
        trd.start();
    }
    
    @Override
    public void run(){
       chat = new ChatGUI(src,info);
    }
}
