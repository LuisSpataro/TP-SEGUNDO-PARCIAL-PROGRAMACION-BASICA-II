package modelo.transformaciones;

import modelo.criatura.Criatura;

public class VinculoTerrestre extends Transformacion {

    public VinculoTerrestre(Criatura base) {
        super(base);
    }

    @Override
    public void aplicar(Criatura criatura) {
        if (criatura.getEnergia() < 50) {
            criatura.setEnergia(50);
        }
    }
}
