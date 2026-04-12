/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package threadrelay;

/**
 * Interfaccia per la comunicazione tra i runner e il form
 * @author utente
 */
public interface ThreadListener {
    
    //metodo per cambio valore dei componenti grafici
    void cambioValore(int nRunner, int valoreCorrente);

    //metodo per far partire il prossimo thread
    void InizioProssimoThread();

    //fine thread
    void fineThread(int nRunner);
}
