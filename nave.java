import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class nave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nave extends Actor
{
    private int velocidad;
    GreenfootSound GameMusic = new GreenfootSound("musica.wav");
    public nave(int v){
        velocidad = v;
        GameMusic.setVolume(40);
        GameMusic.playLoop();
    }
    
    public void act()
    {   
        if(Greenfoot.isKeyDown("right"))
        {
            if(getX() < 750)
                setLocation(getX() + velocidad, getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            if(getX() > 60)
                setLocation(getX() - velocidad, getY());
        }
        if(Greenfoot.isKeyDown("up"))
        {
            if(getY() > 50)
                setLocation(getX(), getY() - velocidad);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            if(getY() < 455)
                setLocation(getX(), getY() + velocidad);
        }
        
        explotar();
    }
    public void explotar(){
        Actor estrellar = getOneIntersectingObject(meteorito.class);
        if (estrellar != null)
        {
            Greenfoot.playSound("explosion.mp3");
            getWorld().removeObject(estrellar);
            getWorld().removeObject(this);
            GameMusic.stop();
            Greenfoot.stop();
        }
        else{
            Actor estrellar_2 = getOneIntersectingObject(meteorito_2.class);
            if (estrellar_2 != null)
            {
              Greenfoot.playSound("explosion.mp3");
              getWorld().removeObject(estrellar_2);
              getWorld().removeObject(this);
              GameMusic.stop();
              Greenfoot.stop();
            }
        }
    }
    public void aumenta_velocidad(){
        velocidad++;
    }
}
