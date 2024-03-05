package kass.concurrente.modelos;

/**
 * Clase que modela un prisioner
 * @version 1.0
 * @author Los Threads
 */
public class Prisionero {
    protected Integer id;
    protected Boolean esVocero;
    protected Boolean marcado;

    /**
     * Metodo constructor para generar un prisionero
     * @param id El identificador del prisionero
     * @param esVocero true si es Vocero false en otro caso
     * @param marcado true si ya paso
     */
    public Prisionero(Integer id, Boolean esVocero, Boolean marcado){
        this.id = id;
        this.esVocero = esVocero;
        this.marcado = marcado;
    }

    //Annadir getter and setter, toString.

    /**
     * Metodo void para establecer el id de la habitación.
     * @param id - id del prisionero
     */
    public void setID(Integer id){
        this.id =  id;
    }

    /**
     * MEtodo para establecer el vocero
     * @param esvocero - boolean que dice si es vocero
     */
    public void setVocero(boolean esvocero){    
        esVocero = esvocero;
    }

    /**
     * Metodo que establece si está marcado o no
     * @param marcado - booleano 
     */
    public void setMarcado(boolean marcado){
        this.marcado = marcado;
    }

    /**
     * Método para obtener el Id
     * @return - id del prisionero
     */
    public Integer getId(){
        return id;
    }

    /**
     * Método para obtener si es vocero o no.
     * @return - checa si es vocero o no.
     */
    public boolean getVocero(){
        return esVocero;
    }

    /**
     * Método para obtener si ya pasó
     * @return - booleano si ya pasó.
     */
    public boolean getMarcado(){
        return marcado;
    }


}
