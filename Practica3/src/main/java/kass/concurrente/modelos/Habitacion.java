package kass.concurrente.modelos;

import kass.concurrente.constantes.Contante;

/**
 * Clase que fungira como habitacion
 * Se sabe que existe un interruptor que nos dice
 * si el foco esta prendido o no
 * Se desconoce el estado inicial del foco (Usar un random, para que sea
 * pseudoaleatorio el estado inicial)
 * @author Los Threads
 * @version 1.0
 */
public class Habitacion {
    protected Boolean prendido;

    /**
     * Metodo Constructor
     * Aqui se define el como estara el foco inicialmente
     */
    public Habitacion(){
        prendido = Math.random() < 0.5;
    }

    /**
     * Metodo que permite al prisionero entrar a la habitacion
     * Recordemos que solo uno pasa a la vez, esta es la SECCION CRITICA
     * En este caso se controla desde fuera
     * Es similar al algoritmo que progonan y similar al de su tarea
     * El prisionero espera una cantidad finita de tiempo
     * @param prisionero El prisionero que viene entrando
     * @return false si ya pasaron todos, true en otro caso
     * @throws InterruptedException Si falla algun hilo
     */
    public Boolean entraHabitacion(Prisionero prisionero) throws InterruptedException{
        prisionero.setMarcado(Contante.LOGS);
        Thread.sleep(Contante.CINCO_SEGUNDOS);
        return prendido;
    }

    public void setInterruptor(boolean prendido){
        this.prendido = prendido;
    }

    public Boolean getInterruptor(){
        return prendido;
    }


    public String toString(){
        return "Interruptor: "+ prendido;
    }
}
