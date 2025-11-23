package modelo.transformaciones;

import modelo.criatura.Criatura;
import java.util.List;
import modelo.excepciones.EnergiaExcedidaException;

public abstract class Transformacion extends Criatura {

    protected Criatura base;

    public Transformacion(Criatura base) {
        super(base.getNombre(), base.getEnergia(), base.getAfinidades(), base.isInestable());
        this.base = base;
    }

    @Override
    public void entrenar(int cantidad) throws EnergiaExcedidaException {
        base.entrenar(cantidad);
    }

    @Override
    public void pacificar() {
        base.pacificar();
    }

    @Override
    public boolean isInestable() {
        return base.isInestable();
    }

    @Override
    public void volverInestable() {
        base.volverInestable();
    }

    @Override
    public void volverTranquila() {
        base.volverTranquila();
    }

    @Override
    public int getEnergia() {
        return base.getEnergia();
    }

    @Override
    public void setEnergia(int energia) {
        base.setEnergia(energia);
    }

    @Override
    public List<Criatura.Afinidad> getAfinidades() {
        return base.getAfinidades();
    }

    
    public abstract void aplicar(Criatura criatura);
}

