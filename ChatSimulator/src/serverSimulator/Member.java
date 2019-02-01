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
public class Member {
    private String  name;
    private String  number;
    private short   age;
    private boolean adminStatus;
    
    public Member(String name, String number, short age){
        this.name   = name;
        this.number = number;
        this.age    = age;
        adminStatus = false;
    }
    
    public String getName(){
        return name;
    }
}
