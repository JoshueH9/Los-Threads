package kass.concurrente;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

import kass.concurrente.constantes.Contante;
import kass.concurrente.modelos.*;

import java.util.ArrayList;
import java.util.List;

import static kass.concurrente.constantes.Contante.LOGS;

/**
 * Clase principal, se ejecuta todo la simulacion
 * Como en el cuento.
 * @author <Equipo>
 * @version 1.0
 */
public class Main implements Runnable {

    Lock lock;
    List<Thread> hilos;
    List<Prisionero> prisioneros;
    Habitacion hab;
    Vocero vocero;

    public Main(){
        lock = new ReentrantLock();
        hilos = new ArrayList<>();
        prisioneros = new ArrayList<>();
        hab = new Habitacion();
        vocero = new Vocero(0,true,false);
        prisioneros.add(vocero);

        for(Integer i = 0; i < Contante.PRISIONEROS; i++){
            Prisionero prisionero = new Prisionero(i, false, false);
            prisioneros.add(prisionero);
        }

    }

    /*
     * INSTRUCCIONES:
     * 1.- Ya genere el lock, es un reentrantLock, investiguen que hace
     * 2.- Tenenemos que tener un lugar el donde se albergaran los prisioneros
     * 3.- Tenemos que tener un lugar donde se albergan los Hilos
     * 4.- Se nececita un objeto de tipo Habitacion para que sea visitada
     * 5.- Aqui controlaremos el acceso a la habitacion, aunque por defecto tenia exclusion mutua
     * aqui hay que especificar el como se controlara
     * 6.- Hay que estar ITERANDO constantemente para que todos los prisiones puedan ir ingresando
     */
    @Override
    public void run() {
        System.out.println(hab.getInterruptor());
        // TODO Auto-generated method stub
        for (Prisionero prisionero : prisioneros) {
            Thread t = new Thread(() -> {
                while (true) {
                    lock.lock();
                    try {
                        boolean interruptorEstado = hab.entraHabitacion(prisionero);
                        if(interruptorEstado == false){
                            hab.setInterruptor(Contante.LOGS);
                        }
                        if (interruptorEstado == true && prisionero.getMarcado() == false) {
                            synchronized (Main.this) {
                                vocero.annadir(prisionero);
                                System.out.println(Contante.RED + "Prisionero " + prisionero.getId() + " ha pasado. (Interruptor encendido)");
                            }
                        } else if (prisionero.getMarcado() == true) {
                            synchronized (Main.this) {
                                vocero.annadir(prisionero);
                                System.out.println(Contante.BLUE + "Prisionero " + prisionero.getId() + " ha pasado. (Interruptor apagado)");
                            }
                        }
                        if (vocero.getContador() == prisioneros.size()) {
                            hab.setInterruptor(false); // Apagar el interruptor
                            System.out.println("Todos los prisioneros han pasado al menos una vez.");
                            break;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
            hilos.add(t);
            t.start();
        }

        
    }


    public static void main(String[] args) {
        Main m = new Main();
        Thread simulationThread = new Thread(m);
        System.out.println("Simulación:\n");
        simulationThread.start();
    }
}