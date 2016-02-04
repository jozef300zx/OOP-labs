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
public class Cooler extends AbstractActor implements Switchable{
    Reactor reactor;
    boolean turnedOn;
    private Animation normalAnimation;

    
    Cooler(Reactor reactor)
    {
    this.reactor = reactor;   
    normalAnimation = new Animation("resources/images/fan.png",32,32,200);
    setAnimation(normalAnimation); 
    
    
    }
    
     public void turnOn()
     {
         this.turnedOn = true;
     }
     
     public void turnOff()
     {
         this.turnedOn = false;
     }
    
     public boolean isOn()
     {
         return this.turnedOn;
     }
     
     public void act()
     {
         updateAnimation();
         if(this.isOn())
         {
         this.reactor.decreaseTemperature(1);
         }
     }
    
    public void updateAnimation()
    {
      if(this.isOn())
      {
           normalAnimation.start();
      }
      else
      {
          normalAnimation.stop();
      }
    }
     
}
