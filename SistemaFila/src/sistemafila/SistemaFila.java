/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemafila;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class SistemaFila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Filas fila = new Filas();
        Cliente cliente;
        Scanner imput = new Scanner(System.in);
        
        for(int x = 1; x <= 20; x++){
            cliente = new Cliente();
//            System.out.println("Digite o " + x + "º nome: ");
//            cliente.setNome(imput.next());
            System.out.println("\nDigite o status: ");// 1 - PRIORITARIO | 2 - ESPECIAL | 3 - NORMAL
            cliente.setStatus(imput.nextInt());
            
            fila.listaFila.add(cliente);
        }
        
        System.out.println(fila.getFila());
        
                
                fila.t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            fila.filaPrioridade();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SistemaFila.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                fila.t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            fila.filaEspecial();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SistemaFila.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                fila.t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            fila.filaNormal();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SistemaFila.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                
                fila.t1.start();
                fila.t2.start();
                fila.t3.start();
           }
    
}
