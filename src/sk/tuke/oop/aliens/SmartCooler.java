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
public class SmartCooler extends Cooler {
    
    SmartCooler(Reactor reactor) {
        super(reactor);
    }
    
    public void act()
    {
        if(this.reactor.startCooling())
        {
            this.turnOn();
        } 
        else
        {
            this.turnOff();
        }
        super.act();
         
    }
    
}
