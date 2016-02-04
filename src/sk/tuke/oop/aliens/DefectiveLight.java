/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

/**
 *
 * @author jmorvay
 */
public class DefectiveLight extends Light implements Repairable{
    boolean fixed;
    int countdown;
    
    DefectiveLight()
    {
        super();
    }
    
    public void brokenOperation()
    {
        if(this.ElectricityFlow == true)
        {
        if(Math.random() < 0.1 && this.switchedOn)
        {
            toggle();
        } else if (this.switchedOn == false) {
            toggle();
        }
        }
    }
    
    public void fixedOperation()
    {
        if(this.ElectricityFlow == true)
        {
            this.turnOn();
        }
    }
    
    @Override
    public void act()
    {
        
        if(fixed)
        {
            fixedOperation();
            this.countdown -=1;
           if(this.countdown == 0)
           {
               this.fixed = false;
           }
            
        } else
        {
           brokenOperation(); 
        }

    }

    @Override
    public void repair(AbstractTool tool) {
        if(tool instanceof Wrench)
        {
          tool.Use();
          this.fixed = true;
          this.countdown = 1000;
        } else
        {
            System.out.println("na opravu svetla funguje len vidlicovy kluc");
        }
    }
    
}
