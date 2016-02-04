/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

/**
 *
 * @author jmorvay
 */
public class Switch extends PowerSwitch {
    
    public Switch(Switchable test) {
        super(test);
    }
    
    public void toggle()
    {
        if(test.isOn())
        {
            test.turnOff();
        } else
        {
            test.turnOn();
        }
    }
    
}
