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
public class Controller extends AbstractActor{
    private Animation normalAnimation;
    Reactor reactor;
    
    Controller(Reactor reactor)
    {
        normalAnimation = new Animation("resources/images/switch.png",16,16,10);
        setAnimation(normalAnimation); 
        this.reactor = reactor;
    }
    
    public void toggle()
    {
        if(this.reactor.isRunning() == false)
        {
        this.reactor.turnOn();
        } else {
            this.reactor.turnOff();
        }
        
    }
}
