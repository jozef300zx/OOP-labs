/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.aliens.actor.Player;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Teleport extends AbstractActor{
    private Teleport destinationTeleport;
    private Animation normalAnimation;
    protected boolean teleported;
    
    Teleport(Teleport destinationTeleport)
    {
        this.destinationTeleport = destinationTeleport;
        normalAnimation = new Animation("resources/images/lift.png",48,48,100);
        setAnimation(normalAnimation);

    }
    
    public void setDestination(Teleport destinationTeleport)
    {
        if(this != destinationTeleport)
        {
        this.destinationTeleport = destinationTeleport;
        } else
        {
            System.out.println("vybral si instanciu tohto teleportu");
        }
    }
    
    public void teleportPlayer()
    {
        Player player = getPlayer();

        if(this.teleported == false && this.destinationTeleport != null && player.getX() > this.getX() - 24 && player.getX() < this.getX() + 24 && player.getY() > this.getY() - 24 && player.getY() < this.getY() + 24)
        {
            player.setPosition(this.destinationTeleport.getX(), this.destinationTeleport.getY());
            this.destinationTeleport.teleported = true;
        }
    }
    
    public void resetTeleport()
    {
        Player player = getPlayer();
        if(this.teleported && (player.getX() < this.getX() - 24 || player.getX() > this.getX() + 24 || player.getY() < this.getY() - 24 || player.getY() > this.getY() + 24))
        {
            this.teleported = false;
        }   
    }
    
    public void act()
    {
     this.teleportPlayer();   
     this.resetTeleport();
    }
    
}
