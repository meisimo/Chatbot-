/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsimulator.gui;
import chatsimulator.gui.exception.EmptyInputException;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import serverSimulator.Group;
import serverSimulator.Member;

/**
 *
 * @author silva
 */
public class ChatGUI extends JFrame implements PanelInterface{
    private Group       src;
    private OutputPanel outputPanel;
    private InputPanel  inputPanel;
    private Member      owner;
    private boolean     openFlag;
    
    public ChatGUI(Group src, Member owner){
        this.src      = src;
        this.owner    = owner;
        
        initWin();
        addPanels();
        
        setVisible( true );
        
        this.openFlag = true;
        
        refreshLoop();
    }
    
    private void initWin(){
        setLayout(new BorderLayout());
        setSize(400,550);
        setTitle("Chat Group");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }
    
    
    private void addPanels(){
        inputPanel  = new InputPanel();
        outputPanel = new OutputPanel( inputPanel, this ,src );
    
        inputPanel.addSendButList( outputPanel );
        
        add( BorderLayout.CENTER, outputPanel);
        add( BorderLayout.SOUTH, inputPanel);
    }
    
    private void refreshLoop(){
        while(openFlag){
            synchronized(src){
                try {
                    src.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            outputPanel.refresh();
        }
    }
    
    
    @Override
    synchronized public void dispose(){
        super.dispose();
        openFlag = false;
        src.memberLeaves(owner.getName());
    }

    @Override
    public String getTxt() throws EmptyInputException {
        return owner.getName();
    }
    

}
