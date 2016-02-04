/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.framework.Animation;

/**
 *
 * @author jmorvay
 */
public class Wrench extends AbstractTool {
    private Animation normalAnimation;
    
    Wrench(){
    super(2);
    normalAnimation = new Animation("resources/images/wrench.png",16,16,10);
    setAnimation(normalAnimation);
}
    
}
