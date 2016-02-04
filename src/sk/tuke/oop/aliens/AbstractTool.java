/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.World;

/**
 *
 * @author jmorvay
 */
public abstract class AbstractTool extends AbstractActor{
    private int numberOfUses;
    World world;
    
    AbstractTool(int numberOfUses)
    {
        this.numberOfUses =  numberOfUses;
        System.out.println(getWorld());
    }
    
    public void Use()
    {
        this.numberOfUses -= 1;
        if (this.numberOfUses == 0)
                {
                    getWorld().removeActor(this);
                }
    }
}
