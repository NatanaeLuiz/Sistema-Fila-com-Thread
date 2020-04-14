/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemafila;

import java.util.ArrayList;

/**
 *
 * @author natan
 */
public class Filas {

    public static final int PRIORIDADE = 1;
    public static final int ESPECIAL = 2;
    public static final int NORMAL = 3;
    public static int contadorPrioridade = 0;
    public static int contadorEspecial = 0;
    public static int contadoGeral = 0;

    Thread t1;
    Thread t2;
    Thread t3;

    public static ArrayList<Cliente> listaFila = new ArrayList<>();
    //public static String[] fila = new String[6];

    public static ArrayList<Cliente> getFila() {
        return listaFila;
    }

    public void filaPrioridade() throws InterruptedException {

        synchronized (this) {
            //chamaProximo(PRIORIDADE);

            for (int x = 0; x < listaFila.size(); x++) {
                //Thread.sleep(3000);
                if (listaFila.get(x).getStatus() == PRIORIDADE) {
                    // System.out.println("::: CHAMA PRIORIDADE :::");
                    contadorPrioridade++;
                    contadoGeral++;
                    System.out.println("Cliente " + listaFila.get(x).getNome() + " com STATUS " + listaFila.get(x).getStatus() + " REMOVIDO");
                    //listaFila.remove(x);
                    //x = 0;
                    listaFila.get(x).setStatus(0);

                    //System.out.println("\n" + listaFila);
                    if (contadorPrioridade == 3) {
                        System.out.println("T1 Aguardando...");
                        System.out.println(listaFila);
                        wait();
                    } else {
                        notifyAll();
                    }
                }
            }
            System.out.println("Terminou PRINCIPAL");
        }
    }

    public void filaEspecial() throws InterruptedException {
        synchronized (this) {
            for (int x = 0; x < listaFila.size(); x++) {
                if (listaFila.get(x).getStatus() == ESPECIAL) {
                    //System.out.println("::: CHAMA ESPECIAL :::");
                    contadorEspecial++;
                    contadoGeral++;
                    System.out.println("Cliente " + listaFila.get(x).getNome() + " com STATUS " + listaFila.get(x).getStatus() + " REMOVIDO");
                    //listaFila.remove(x);
                    listaFila.get(x).setStatus(0);
                    if (contadorEspecial == 2) {
                        System.out.println("T2 Aguardando...");
                        System.out.println(listaFila);
                        wait();
                    }
                }
            }
            System.out.println("Terminou ESPECIAL");

            //chamaProximo(ESPECIAL);
        }
    }

    public void filaNormal() throws InterruptedException {

        Thread.sleep(1000);
        synchronized (this) {
            //chamaProximo(NORMAL);
            for (int x = 0; x < listaFila.size(); x++) {
                if (listaFila.get(x).getStatus() == NORMAL) {
                    //System.out.println("::: CHAMA NORMAL :::");
                    System.out.println("Cliente " + listaFila.get(x).getNome() + " com STATUS " + listaFila.get(x).getStatus() + " REMOVIDO");
                    //listaFila.remove(x);
                    listaFila.get(x).setStatus(0);
                    if (contadoGeral != listaFila.size()) {
                        System.out.println("T3 Aguardando...");
                        System.out.println(listaFila);
                        contadorEspecial = 0;
                        contadorPrioridade = 0;
                        notifyAll();
                    } else {
                        wait();
                    }
                }
            }
            System.out.println("Terminou NORMAL");
        }
    }

//    public void chamaProximo(int status) throws InterruptedException {
//
//        synchronized (this) {
//            for (int x = 0; x < listaFila.size(); x++) {
//                switch (status) {
//                    case PRIORIDADE:
//                        if (listaFila.get(x).getStatus() == PRIORIDADE) {
//                            System.out.println("::: CHAMA PRIORIDADE :::");
//                            contadorPrioridade++;
//                            contadoGeral++;
//                            listaFila.remove(x);
//                            System.out.println("Cliente " + listaFila.get(x).getNome() + " com STATUS " + listaFila.get(x).getStatus() + " REMOVIDO");
//                            //listaFila.get(x).setStatus(0);
//                            
//                            //System.out.println("\n" + listaFila);
//                            if (contadorPrioridade == 3) {
//                                System.out.println("T1 Aguardando...");
//                                x = 0;
//                                wait();
//                            }
//                        }   break;
//                    case ESPECIAL:
//                        if (listaFila.get(x).getStatus() == ESPECIAL) {
//                            System.out.println("::: CHAMA ESPECIAL :::");
//                            contadorEspecial++;
//                            contadoGeral++;
//                            System.out.println("Cliente " + listaFila.get(x).getNome() + " com STATUS " + listaFila.get(x).getStatus() + " REMOVIDO");
//                            listaFila.remove(x);
//                            //listaFila.get(x).setStatus(0);
//                            if (contadorEspecial == 2) {
//                                System.out.println("T2 Aguardando...");
//                                wait();
//                            }
//                        }   break;
//                    case NORMAL:
//                        if (listaFila.get(x).getStatus() == NORMAL) {
//                            System.out.println("::: CHAMA NORMAL :::");
//                            System.out.println("Cliente " + listaFila.get(x).getNome() + " com STATUS " + listaFila.get(x).getStatus() + " REMOVIDO");
//                            listaFila.remove(x);
//                            //listaFila.get(x).setStatus(0);
//                            if (contadoGeral != listaFila.size()) {
//                                System.out.println("T3 Aguardando...");
//                                contadorEspecial = 0;
//                                contadorPrioridade = 0;
//                                notifyAll();
//                                System.out.println(listaFila);
//                            }
//                            notifyAll();
//                        }
//                    default:
//                        notifyAll();
//                        break;
//                }
//
//            }
//        }
//    }
}
