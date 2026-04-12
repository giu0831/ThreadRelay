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
    private boolean pausa;
    private ThreadListener listener;

    public Runner(int id, int ritardo, ThreadListener listener) {
        this.id = id;
        this.ritardo = ritardo + 40;
        stop = false;
        pausa = false;
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
            //controllo pausa
            synchronized (this) {
                if(pausa) {
                    try {
                        //resta in pausa finche' non viene chiamato notify()
                        wait();
                    } catch (InterruptedException e) {
                        // Se viene interrotto mentre dorme
                        if (stop) return; 
                    }
                }
            }
            listener.cambioValore(id, i);
            if(i == 90)listener.InizioProssimoThread();
            
            try{
                Thread.sleep(ritardo);
            }catch(InterruptedException ie){
                System.out.println("Thread interrotto");
            }
            //rallentamento all'inizio e alla fine
            if(i < 20) ritardo-= 2;
            else if(i > 80) ritardo+= 2;
        }
        listener.fineThread(id);
    }
    
    /**
     * Metodo per fermare il thread definitivamente
     */
    public synchronized void ferma(){
        stop = true;
        pausa = false; 
        notify();
    }
    
    /**
     * Metodo che mette in pausa il thread
     */
    public synchronized void pausa(){
        pausa = true;
    }
    
    /**
     * Metodo che riavvia il thread
     */
    public synchronized void riprendi(){
        pausa = false;
        notify();
    }
}
