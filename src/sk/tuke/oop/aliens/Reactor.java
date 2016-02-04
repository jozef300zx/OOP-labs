/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Reactor extends AbstractActor implements Switchable,Repairable {
    private int temperature;
    private int damage;
    private String manufacturer;
    private int yearOfProduction;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation destroyedAnimation;
    private Animation offAnimation;
    private boolean isRunning;
    private boolean hasLightAttached;
    private Light light;
    private boolean coolingOn;
    private List <EnergyConsumer> devices;
    
    Reactor(String manufacturer, int yearOfProduction)
    {
        setmanufacturer(manufacturer);
        setyearOfProduction(yearOfProduction);
        temperature = 0;
        damage = 0;
        isRunning = false;
        devices = new ArrayList<>();
        
    offAnimation = new Animation("resources/images/reactor.png", 80, 80, 120);
    setAnimation(offAnimation);   
    
    normalAnimation = new Animation("resources/images/reactor_on.png", 80, 80, 120);
    normalAnimation.setPingPong(true);
    
    hotAnimation = new Animation("resources/images/reactor_hot.png", 80, 80, 50);
    hotAnimation.setPingPong(true);
    
    destroyedAnimation = new Animation("resources/images/reactor_broken.png", 80, 80, 120);
    destroyedAnimation.setPingPong(true);
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
        if (this.isRunning){
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
            
            if (this.getDamage() == 100)
            {
                turnOff();
            }
        }
        }
        
        updateAnimation();
        }
     }
    public void decreaseTemperature(int temperature_down)
    {
        if (this.isRunning){
        if (temperature_down > 0 && this.temperature > 0){
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
    }
    
    private void updateAnimation()
    {
        
        if (this.isRunning()){
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
        } else if (this.isRunning() == false && this.getDamage() == 100) 
                {
            setAnimation(destroyedAnimation);
                }
        else if (this.isRunning() == false && this.getDamage() < 100)
        {
            setAnimation(offAnimation);
        }
       
    }
    
    public boolean isServiceNeeded()
    {
        return this.getDamage() > 50 && this.getTemperature() > 3000;
    }
    
    public void repair(AbstractTool tool)
    {
        
        if(this.getDamage() < 100 && tool instanceof Hammer)
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
            tool.Use();
        } else
        {
            System.out.println("vybrany nastroj nie je kladivo");
        }
        updateAnimation();
    }
    public void setyearOfProduction(int yearOfProduction)
    {
        this.yearOfProduction = yearOfProduction;
    }
    public void setmanufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }
    
    public boolean isRunning()
    {
        return this.isRunning;
    }
    
    public boolean isOn()
    {
        return isRunning();
    }
    
    public void turnOn()
    {
        EnergyConsumer energyConsumer;
        if(this.getDamage() < 100)
        {
        this.isRunning = true;
        Iterator iterator = devices.iterator();
        while(iterator.hasNext())
        {
           energyConsumer = (EnergyConsumer) iterator.next();
           energyConsumer.setElectricityFlow(true);
        }
          }
        updateAnimation();   
        }
    
    
    public void turnOff()
    {
        EnergyConsumer energyConsumer;
        this.isRunning = false;
         Iterator iterator = devices.iterator();
        while(iterator.hasNext())
        {
           energyConsumer = (EnergyConsumer) iterator.next();
           energyConsumer.setElectricityFlow(false);
        }
        updateAnimation();
    }
    
    public void addDevice(EnergyConsumer energyConsumer)
    {
           if(this.isRunning)
           {
            energyConsumer.setElectricityFlow(true);
           }
           
           if(devices.contains(energyConsumer))
                   {
                       System.out.println("tento objekt uz je reaktorom napajany");
                   }
           else
           {
               devices.add(energyConsumer);
           }
    }
    
    public void removeDevice(EnergyConsumer energyConsumer)
    {
        energyConsumer.setElectricityFlow(false);
        devices.remove(energyConsumer);
        
    }
    
    public void listOutput()
    {
        Iterator iterator = devices.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    
    public void act()
    {
        increaseTemperature(1);
    }
    
    public boolean startCooling()
    {
       if (this.getTemperature() > 2000)
       {
       this.coolingOn = true;
       }
       
       if (this.getTemperature() < 1000)
       {
       this.coolingOn = false;
       }
       return coolingOn;
       
    }
    
    public boolean stopCooling()
    {
        return this.getTemperature() < 1000;
    }
}
    
