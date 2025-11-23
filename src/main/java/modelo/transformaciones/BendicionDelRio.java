package modelo.transformaciones;

import modelo.criatura.Criatura;

public class BendicionDelRio extends Transformacion {

    public BendicionDelRio(Criatura base) {
        super(base);
    }

    @Override
    public void aplicar(Criatura criatura) {
        int nuevaEnergia = criatura.getEnergia() * 2;
        criatura.setEnergia(Math.min(nuevaEnergia, 180));
    }
}
