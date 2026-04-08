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
    private ThreadListener listener;

    public Runner(int id, int ritardo, ThreadListener listener) {
        this.id = id;
        this.ritardo = ritardo;
        stop = false;
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public int getRitardo() {
        return ritardo;
    }

    public boolean isStop() {
        return stop;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 101; i++){
            if(stop)return;
            listener.cambioValore(id, i);
            if(i == 90)listener.InizioProssimoThread();
            try{
                Thread.sleep(ritardo);
            }catch(InterruptedException ie){
                System.out.println("Thread interrotto");
            }
        }
        listener.fineThread(id);
    }
    
    /**
     * Metodo per fermare il thread definitivamente
     */
    public void ferma(){
        stop = true;
    }
}
