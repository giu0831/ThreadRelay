/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 * Classe runner
 * @author utente
 */
public class Runner implements Runnable{
    private final int id; 
    private int ritardo; 
    private boolean stop;
    private boolean pausa;
    private final ThreadListener listener; 

    /**
     * Metodo costruttore
     * @param id id del runner
     * @param ritardo ritardo usato nel thread sleep
     * @param listener listener che permettera' al runner di comunicare con il form
     */
    public Runner(int id, int ritardo, ThreadListener listener) {
        this.id = id;
        //al ritardo viene aggiunto 40 perche' all'inizio il thread deve andare piu' piano
        this.ritardo = ritardo + 40; 
        stop = false;
        pausa = false;
        this.listener = listener;
    }

    /**
     * Metodo get
     * @return id del runner
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo get
     * @return ritardo
     */
    public int getRitardo() {
        return ritardo;
    }

    /**
     * Metodo get
     * @return stop
     */
    public boolean isStop() {
        return stop;
    }
    
    /**
     * Metodo run
     */
    @Override
    public void run(){
        for(int i = 0; i < 101; i++){
            //controllo per vedere se si deve fermare
            if(stop)return;
            //controllo pausa
            synchronized (this) {
                if(pausa) {
                    try {
                        //resta in pausa finche' non viene chiamato il metodo notify()
                        wait();
                    } catch (InterruptedException e) {
                        //controllo se viene interrotto mentre dorme
                        if (stop) return; 
                    }
                }
            }
            //vengono cambiati i valori sul form
            listener.cambioValore(id, i);
            //se il thread e' arrivato a 90 si fa partire il prossimo
            if(i == 90)listener.InizioProssimoThread();
            //il thread dorme
            try{
                Thread.sleep(ritardo);
            }catch(InterruptedException ie){
                System.out.println("Thread interrotto");
            }
            //rallentamento iniziale e finale
            if(i < 20) ritardo-= 2;
            //se questo e' l'ultimo runner non rallenta alla fine
            else if(i > 80 && id != 4) ritardo+= 2;
        }
        //finito il run viene avvisato il form
        listener.fineThread(id);
    }
    
    /**
     * Metodo per fermare il thread definitivamente
     */
    public synchronized void ferma(){
        stop = true;
        //la pausa viene tolta così che il runner possa vedere che si deve fermare
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
