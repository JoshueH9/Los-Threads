package kass.concurrente.modelos;

/**
 * Este ess quien lleva la cuenta de los prisioneros que han entrado a la habitacion
 * a parte de los atributos de Prisionero, tambien posee un contador
 * @author Los Threads
 * @version 1.0
 */
public class Vocero extends Prisionero{
    protected Integer contador;
    public Vocero(Integer id, Boolean esVocero, Boolean marcado) {
        super(id, esVocero, marcado);
        contador = 0;
    }
    
    //Mismo caso que el otro, annadir getter and setter
    public void setContador(Integer contador){
        this.contador = contador;
    }

    public Integer getContador(){
        return contador;
    }

    public void annadir(Prisionero pris){
        contador += 1;
    }
}
