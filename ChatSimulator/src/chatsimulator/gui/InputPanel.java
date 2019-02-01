/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsimulator.gui;

import chatsimulator.gui.exception.EmptyInputException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author silva
 */
public class InputPanel extends JPanel implements  PanelInterface{
    private JTextField  inputArea;
    private JButton     sendBut;
    private JPanel      butPanel;
       
    public InputPanel(){
        initPanel();
        addItems();
    }
        
    private void initPanel(){
        setLayout(new BorderLayout());
        setBorder( new TitledBorder("Enviar Mensaje:"));
    }
    
    private void initInArea(){
        inputArea   = new JTextField();
        inputArea.setActionCommand("simple_Sent");
    } 
    
    private void initSendBut(){
        butPanel= new JPanel();
        butPanel.setLayout(new GridLayout(2,1));
        
        sendBut = new JButton("Enviar");

        
        sendBut.setActionCommand("simple_Sent");

        
        butPanel.add( sendBut );

    }

    private void addItems(){
        initInArea();
        initSendBut();

        
        add(BorderLayout.CENTER, inputArea);
        add( BorderLayout.EAST, butPanel );
        
    }
    
    public  void addSendButList(ActionListener listener){
        sendBut.addActionListener( listener );
    }
    
    public void addInputAreaList(ActionListener listener){
        inputArea.addActionListener(listener);
    }
    
    @Override
    public String getTxt() throws EmptyInputException{
        if ( inputArea.getText().equals("") )
            throw new EmptyInputException();
        try{
            return inputArea.getText();
        }finally{
            inputArea.setText("");
        }
    }
    
}
