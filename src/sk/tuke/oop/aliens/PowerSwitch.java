/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class PowerSwitch extends AbstractActor{
    Switchable test;
    private Animation normalAnimation;
    
    PowerSwitch(Switchable test)
    {
        this.test = test;
        normalAnimation = new Animation("resources/images/switch.png",16,16,100);
        setAnimation(normalAnimation);
    }

    public void switchOn()
    {
        this.test.turnOn();
    }
    
    public void switchOff()
    {
        this.test.turnOff();
    }
    
}
