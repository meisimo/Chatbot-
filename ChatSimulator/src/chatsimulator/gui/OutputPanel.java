/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsimulator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import chatsimulator.gui.exception.EmptyInputException;
import java.util.logging.Level;
import java.util.logging.Logger;
import serverSimulator.Group;

/**
 *
 * @author silva
 */
public class OutputPanel extends JPanel implements ActionListener{
    static final private Color CREAM  = new Color( 254, 246, 233);
    
    final private PanelInterface  inputPanel;
    final private PanelInterface  ownerInfo;
    
    private Group           src;
    private JTextArea       outputTxtArea;
    private JScrollPane     outputArea;    
    
    public OutputPanel(PanelInterface input, PanelInterface ownerInfo ,Group src) {
        inputPanel = input;
        this.ownerInfo = ownerInfo;
        this.src = src;
        
        initPanel();
        addItems();
    }
    
    private void initPanel(){
        setLayout(new BorderLayout());
        
    }
    
    private void initOutputTxtArea(){
        outputTxtArea = new JTextArea();
        
        outputTxtArea.setBackground(CREAM);
        outputTxtArea.setEditable( false );
        outputTxtArea.setWrapStyleWord( true );
        outputTxtArea.setLineWrap( true );
    }
    
    private void initOutputArea(Component cmp){
        outputArea = new JScrollPane(cmp);
    }
    
    private void addItems(){
        initOutputTxtArea();
        initOutputArea( outputTxtArea);
        
        add(BorderLayout.CENTER, outputArea);
    }

    private void eraseArjonaTxt(){
        String[] lines = outputTxtArea.getText().split("\n");
        outputTxtArea.setText("");
        
        for ( String line: lines )
            if ( line.length()>0 && line.charAt(0)=='U' )
                outputTxtArea.setText( outputTxtArea.getText()+"\n"+line+"\n");
        outputTxtArea.setText(outputTxtArea.getText()+"\n");
        
    }
    
    public void refresh(){
        outputTxtArea.setText(src.getTxt());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch ( e.getActionCommand() ){
            case "simple_Sent":
                {
                    try {
                        src.pushTxtLn( ownerInfo.getTxt(), inputPanel.getTxt());
                    } catch (EmptyInputException ex) {
                        Logger.getLogger(OutputPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
    }

}


