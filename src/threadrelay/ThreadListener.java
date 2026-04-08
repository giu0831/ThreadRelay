/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package threadrelay;

/**
 *
 * @author utente
 */
public interface ThreadListener {
    
    //metodo per cambio valore progress bar
    void cambioValore(int nRunner, int valoreCorrente);

    //metodo per far partire il prossimo thread
    void InizioProssimoThread(int nRunner);

    //fine thread
    void fineThread(int nRunner);
}
