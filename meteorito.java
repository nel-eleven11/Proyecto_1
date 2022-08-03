import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sierra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class meteorito extends Actor
{
    private int velocidad;
    
    public meteorito(int v){
        velocidad = v;
        
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/(3);
        int myNewWidth = (int)myImage.getWidth()/(3);
        myImage.scale(myNewWidth, myNewHeight);
    }
    
    public void act()
    {
        setLocation(getX() - velocidad, getY());
        if( getX() <= 10 ){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.aumentar_puntos(15);
            juego.disminuir_num_obstaculos();
            juego.aumentar_num_adelantamientos();
        }
    }
}
