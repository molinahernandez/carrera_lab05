package Thread;


import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LN710Q
 */
public class AnimalThread extends Thread {
    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;
    

    public AnimalThread(String nombre, int x, int y, int limite, JLabel animal) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.limite = limite;
        this.animal = animal;
        
    }
    
    @Override
    public void run(){
        for (int i= x ; i<=this.limite ; i+=10){
            System.out.println(this.nombre + "Avanza");
            this.animal.setLocation(i,y);
            try{
                sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(this.nombre + "a llegado a la meta");
        yield();
    }
    
}
