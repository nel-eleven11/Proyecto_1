import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    flecha forma = new flecha();
    private int opcion = 0;
    GreenfootSound GameMusic = new GreenfootSound("musica.wav");
    public Menu()
    {    
        super(800, 500, 1); 
        construir_mundo();
        GameMusic.setVolume(40);
        
    }
    
    private void construir_mundo(){
        addObject(forma,200,150);
    }
    
    public void act(){
        GameMusic.playLoop();
        if(Greenfoot.isKeyDown("UP") && opcion != 0){opcion++;}
        if(Greenfoot.isKeyDown("Down") && opcion != 1){opcion--;}
        
        if(opcion >= 2) {opcion = 0;}
        if(opcion < 0) {opcion = 1;}
        
        forma.setLocation(200,150+ (opcion*200));
        
        if(Greenfoot.isKeyDown("SPACE") || Greenfoot.isKeyDown("ENTER")){
            switch(opcion){
                case 0:
                    GameMusic.stop();
                    Greenfoot.setWorld(new MyWorld());
                    break;
                case 1:
                    GameMusic.stop();
                    Greenfoot.stop();
                    break;
            }
        }
    }
}
