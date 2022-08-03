import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private contador Puntos;
    private contador Nivel;
    
    private int vel_nave;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private nave alax;
    private int num_obstaculos;
    private int num_obstaculos_2;
    public MyWorld()
    {       
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 6;
        vel_nave = 2;
       
        Puntos = new contador("Puntaje: " );
        Nivel = new contador("Nivel: " );
        Nivel.add(1);
        alax= new nave(vel_nave);
       
        addObject(alax, 100, 250);
        addObject(Nivel, 100, 50);
        addObject(Puntos, 100, 20);
    }
    public void act(){
        //Greenfoot.playSound("musica.wav"); la musica no funciono
        aumentar_dificultad();
        aniadir_obstaculos();
        aniadir_obstaculos_2();
    }
    public int getRandomNumber(int start,int end){
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    public void aumentar_puntos(int valor){
        Puntos.add(valor);
    }
    
    public void aumentar_num_adelantamientos(){
        num_adelantamientos++;
    }
    
    public void disminuir_num_obstaculos(){
        num_obstaculos--;
    }
    
    public void disminuir_num_obstaculos_2(){
        num_obstaculos_2--;
    }
    
    public void aumentar_dificultad(){
        if(num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel = num_adelantamientos_nivel + 3;
            vel_nave++; 
            Nivel.add(1);
            alax.aumenta_velocidad();
        }
    }
    
    public void aniadir_obstaculos_2(){
        if(num_obstaculos_2 == 0){
            int carril = getRandomNumber(0,4);
            
            if(carril == 0){
                    addObject(new meteorito_2(vel_nave),750, 60);
                }
                else if( carril == 1){
                    addObject(new meteorito_2(vel_nave),750, 175);
                }
                else if( carril == 2){
                    addObject(new meteorito_2(vel_nave),750, 300);
                }
                else{
                    addObject(new meteorito_2(vel_nave),750, 420);
                }
            num_obstaculos_2 = 1;
            }        
    }
    
    public void aniadir_obstaculos(){
        if(num_obstaculos == 0){
            
            int carril = getRandomNumber(0,4);
            
            if(carril == 0){
                addObject(new meteorito(vel_nave),750, 60);
            }
            else if( carril == 1){
                addObject(new meteorito(vel_nave),750, 175);
            }
            else if( carril == 2){
                addObject(new meteorito(vel_nave),750, 300);
            }
            else{
                addObject(new meteorito(vel_nave),750, 420);
            }
            
            carril++;
            carril = carril % 4;
            
            if(carril == 0){
                addObject(new meteorito(vel_nave),750, 60);
            }
            else if( carril == 1){
                addObject(new meteorito(vel_nave),750, 175);
            }
            else if( carril == 2){
                addObject(new meteorito(vel_nave),750, 300);
            }
            else{
                addObject(new meteorito(vel_nave),750, 420);
            }
            
            carril++;
            carril = carril % 4;
            
            if(carril == 0){
                addObject(new meteorito(vel_nave),750, 60);
            }
            else if( carril == 1){
                addObject(new meteorito(vel_nave),750, 175);
            }
            else if( carril == 2){
                addObject(new meteorito(vel_nave),750, 300);
            }
            else{
                addObject(new meteorito(vel_nave),750, 420);
            }
            
            num_obstaculos = 3;
        }
    }
}
