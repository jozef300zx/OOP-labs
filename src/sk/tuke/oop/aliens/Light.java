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
public class Light extends AbstractActor implements Switchable, EnergyConsumer {
    boolean switchedOn;
    boolean ElectricityFlow;
    Animation onAnimation;
    Animation offAnimation;
    
    
    Light()
    {
    onAnimation = new Animation("resources/images/light_on.png",16,16,10);
    offAnimation = new Animation("resources/images/light_off.png",16,16,10);
    setAnimation(offAnimation); 
    }
    
    public void toggle()
    {
        this.switchedOn = this.switchedOn == false;
        updateAnimation();
    }
    
    public void setElectricityFlow(boolean setElectricityFlow)
    {
        this.ElectricityFlow = setElectricityFlow;
        updateAnimation();
    }
    
    public void updateAnimation()
    {
      if(this.ElectricityFlow && this.switchedOn)
      {
          setAnimation(onAnimation); 
      } else {
          setAnimation(offAnimation); 
      }
    }

    @Override
    public void turnOff() {
        this.switchedOn = false;
        updateAnimation();
    }

    @Override
    public void turnOn() {
        this.switchedOn = true;
        updateAnimation();
    }

    @Override
    public boolean isOn() {
        return this.switchedOn;
    }
}
