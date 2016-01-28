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
public class Reactor extends AbstractActor {
    private int temperature;
    private int damage;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation destroyedAnimation;
    
    Reactor()
    {
        temperature = 0;
        damage = 0;
     // create animation object
    normalAnimation = new Animation("resources/images/reactor_on.png", 80, 80, 120);
    // play animation repeatedly
    normalAnimation.setPingPong(true);
    // set actor's animation to just created Animation object
    setAnimation(normalAnimation);   
    
    hotAnimation = new Animation("resources/images/reactor_hot.png", 80, 80, 50);
    // play animation repeatedly
    hotAnimation.setPingPong(true);
    // set actor's animation to just created Animation object
    //setAnimation(hotAnimation);   
    
    destroyedAnimation = new Animation("resources/images/reactor_broken.png", 80, 80, 120);
    // play animation repeatedly
    destroyedAnimation.setPingPong(true);
    // set actor's animation to just created Animation object
    //setAnimation(destroyedAnimation);   
    }
    
    public int getTemperature()
    {
    return temperature;
    }

    public int getDamage()
    {
    return damage;
    }    
    
    public void increaseTemperature(int temperature_up)
    {
        if (temperature_up > 0){
        //teplota
        if(this.getDamage() < 50){
            temperature = this.getTemperature() + temperature_up;
        } else if (this.getDamage() >= 50)
        {
            temperature = this.getTemperature() + 2 * temperature_up;
        }
        //poskodenie
        if (this.getTemperature() > 2000)
        {
            damage = (100 * (this.getTemperature() - 2000)) / 3000;
            if(damage > 100){
                damage = 100;
            }
        }
        
        updateAnimation();
        }
     }
    public void decreaseTemperature(int temperature_down)
    {
        if (temperature_down > 0){
        if(this.getDamage() < 50){
            temperature = this.getTemperature() - temperature_down;
        }
        else if (this.getDamage() >= 50 && this.getDamage() < 100)
        {
            temperature = this.getTemperature() - temperature_down / 2;
        } else if (this.getDamage() == 100)
        {}
        updateAnimation();
        }
    }
    
    private void updateAnimation()
    {
        
        
        if (temperature < 4000)
        {
            normalAnimation.setDuration(120 - damage);
            setAnimation(normalAnimation);
        } 
        else if (temperature >= 4000 && temperature < 4999) 
        {
            hotAnimation.setDuration(120 - damage);
            setAnimation(hotAnimation);
        } 
        else if (temperature >=5000){
            setAnimation(destroyedAnimation);
        }
       
    }
    
    public boolean isServiceNeeded()
    {
        return this.getDamage() > 50 && this.getTemperature() > 3000;
    }
    
    public void repair(Hammer hammer)
    {
        if(this.getDamage() < 100 && hammer != null)
        {
            int temp = this.getDamage() - 50;
            if(this.getTemperature() > (30 * temp) + 2000){
            temperature = (30 * temp) + 2000;
            }
                
            damage = this.getDamage() - 50;
            if (damage < 0)
            {
                damage = 0;
            }
            
        }
        
        updateAnimation();
    }
}
    
