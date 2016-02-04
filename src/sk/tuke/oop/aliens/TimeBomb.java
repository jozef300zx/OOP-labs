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
public class TimeBomb extends AbstractActor{
    private int countdown;
    private boolean activated;
    private Animation offAnimation;
    private Animation onAnimation;
    private Animation explosionAnimation;
    
    
    TimeBomb(int countdown)
    {
        this.countdown = countdown;
        offAnimation = new Animation("resources/images/bomb.png", 16, 16, 10);
        onAnimation = new Animation("resources/images/bomb_activated.png", 16, 16, 100);
        onAnimation.setPingPong(true);
        explosionAnimation = new Animation("resources/images/small_explosion.png", 16, 16, 100);
        setAnimation(offAnimation);
        
        
    }
    
    public void activate()
    {
        this.activated = true;
        updateAnimation();
    }
    
    public void act()
    {
        if(this.activated)
        {
            this.countdown -=1;
        }
        if(this.countdown == 0)
        {
            updateAnimation();
        }
        
       if(this.countdown == -20)
       {
        getWorld().removeActor(this);
       }
        
    }
    
        public void updateAnimation()
        {
            if(this.activated == false)
            {
                setAnimation(offAnimation);
            }
            else
            {
                setAnimation(onAnimation);
            }
            if(this.activated == true && this.countdown == 0)
            {
                   setAnimation(explosionAnimation);
            }
        }
}
