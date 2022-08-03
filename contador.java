import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class contador extends Actor
{
    private int value = 0;
    private int target = 0;
    private String texto;
    private int stringLength;
    
    public contador(){
        this("");
    }
    public contador(String prefix)
    {
        texto = prefix;
        stringLength = (texto.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  
        image.setColor(Color.BLACK);
        
        updateImage();
    }
    public void act()
    {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }
    public void add(int puntos){
        target += puntos;
    }
    public void subtract(int puntos){
        target -= puntos;
    }
    public int getValue(){
        return value;
    }
    private void updateImage(){
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(texto + value, 1, 18);
    }
}
