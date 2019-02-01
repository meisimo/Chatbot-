/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsimulator;

import personSimulator.Someone;
import serverSimulator.Group;

/**
 *
 * @author silva
 */
public class ChatSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Someone guy1 = new Someone("maximo",(short)26,"4144126882");
        Someone guy2 = new Someone("oscarina",(short)26,"4144126881");
        Someone guy3 = new Someone("ambar",(short)4,"*******");
        Someone guy4 = new Someone("oscar",(short)28,"4144122684");
        
        Group grp = new Group();
        
        guy1.openTheChat(grp);
        guy2.openTheChat(grp);
        guy3.openTheChat(grp);
        guy4.openTheChat(grp);
        
        
        
    }
    
}
