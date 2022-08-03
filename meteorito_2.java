import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lazer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class meteorito_2 extends Actor
{
    private int velocidad;
    private int velocidad_y;
    
    public meteorito_2(int v){
        velocidad = v;
        velocidad_y = v+1;
        
        GreenfootImage myImage = getImage();
        int myNewHeight = (int)myImage.getHeight()/(3);
        int myNewWidth = (int)myImage.getWidth()/(3);
        myImage.scale(myNewWidth, myNewHeight);
    }
    public void act()
    {
        setLocation(getX() - velocidad, getY() + velocidad_y);
        if(getY() <= 10){
            velocidad_y = -velocidad_y;
        }
        
        if(getY() >= 470){
            velocidad_y = -velocidad_y;
        } 
        
        if( getX() <= 10 ){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.aumentar_puntos(0);
            juego.disminuir_num_obstaculos_2();
        }
    }
}
