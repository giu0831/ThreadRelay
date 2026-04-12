/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadrelay;

/**
 *
 * @author delfo
 */
public class ThreadRelay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creazione e apertura form staffetta
        java.awt.EventQueue.invokeLater(() -> new FrmStaffetta().setVisible(true));
    }
    
}
