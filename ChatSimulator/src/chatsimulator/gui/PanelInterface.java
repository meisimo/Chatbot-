/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsimulator.gui;

import chatsimulator.gui.exception.EmptyInputException;

/**
 *
 * @author silva
 */
public interface PanelInterface {
    public String getTxt() throws EmptyInputException;
}
