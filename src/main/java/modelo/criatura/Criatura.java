package modelo.criatura;

import java.util.List;
import modelo.excepciones.EnergiaExcedidaException;

public abstract class Criatura {

    public enum Afinidad {
        AGUA, FUEGO, AIRE, TIERRA
    }

    protected String nombre;
    protected int energia; // 0–200
    protected List<Afinidad> afinidades;
    protected boolean inestable;

    public Criatura(String nombre, int energia, List<Afinidad> afinidades, boolean inestable) {
        this.nombre = nombre;
        this.energia = energia;
        this.afinidades = afinidades;
        this.inestable = inestable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public List<Afinidad> getAfinidades() {
        return afinidades;
    }

    // corregir errores de las transformaciones
    public void setAfinidades(List<Afinidad> nuevasAfinidades) {
        this.afinidades = nuevasAfinidades;
    }

    public boolean isInestable() {
        return inestable;
    }

    public void volverInestable() {
        this.inestable = true;
    }

    public void volverTranquila() {
        this.inestable = false;
    }

    public abstract void entrenar(int cantidad) throws EnergiaExcedidaException;

    public abstract void pacificar();
}


