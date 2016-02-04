/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.aliens.actor.Player;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.World;

/**
 *
 * @author jmorvay
 */
public class Helicopter extends AbstractActor{
    private Animation normalAnimation;
    //Player player;
    World world;
    private boolean searchAndDestroy;
    
    
    Helicopter()
    {
        normalAnimation = new Animation("resources/images/heli.png",64,64,100);
        normalAnimation.setPingPong(true);
        setAnimation(normalAnimation);
        
        
        
    }
    
    public void startSearchAndDestroy()
    {
     
        this.searchAndDestroy = searchAndDestroy == false;
    }
    
    public void searchAndDestroy()
    {
        Player player = getPlayer();
        
        if(player.getX() > this.getX())
        {
            this.setPosition(this.getX() + 1, this.getY());
        } else if (player.getX() < this.getX())
        {
            this.setPosition(this.getX() - 1, this.getY());
        }
        
        if(player.getY() > this.getY())
        {
            this.setPosition(this.getX(), this.getY() + 1);
        } else if (player.getY() < this.getY())
        {
            this.setPosition(this.getX(), this.getY() - 1);
        }
        
        if(player.getX() == this.getX() && player.getY() == this.getY())
        {
            player.setEnergy(player.getEnergy() - 1);
        }
    }
    
    public void act()
    {
        if(this.searchAndDestroy)
        {
        searchAndDestroy();
        }
    }
    
}
