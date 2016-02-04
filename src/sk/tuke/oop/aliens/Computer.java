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
public class Computer extends AbstractActor implements EnergyConsumer{
    Animation normalAnimation;
    boolean ElectricityFlow;

    
    Computer()
    {
    normalAnimation = new Animation("resources/images/computer.png",80,48,100);
    setAnimation(normalAnimation); 
    normalAnimation.stop();
    
    }
    
    @Override
    public void setElectricityFlow(boolean a) {
        this.ElectricityFlow = a;
    }
    
    public void updateAnimation()
    {
      if(this.ElectricityFlow)
      {
          normalAnimation.start();
      } else {
          normalAnimation.stop(); 
      }
    }
    
    public void act()
    {
        updateAnimation();
    }
}

