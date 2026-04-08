/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author utente
 */
public class Runner implements Runnable{
    private int id;
    private int ritardo;
    private boolean stop;

    public Runner(int id, int ritardo) {
        this.id = id;
        this.ritardo = ritardo;
        stop = false;
    }

    public int getRitardo() {
        return ritardo;
    }

    public boolean isStop() {
        return stop;
    }
    
    @Override
    public void run(){
        
    }
    
    
}
