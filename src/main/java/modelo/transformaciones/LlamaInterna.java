package modelo.transformaciones;

import modelo.criatura.Criatura;

public class LlamaInterna extends Transformacion {

    public LlamaInterna(Criatura base) {
        super(base);
        aplicar(base);
    }

    public void aplicar(Criatura criatura) {
        if (criatura.getAfinidades().contains(Criatura.Afinidad.FUEGO)) {
            int nuevaEnergia = criatura.getEnergia() + 30;
            criatura.setEnergia(Math.min(nuevaEnergia, 200));
        } else {
            criatura.volverInestable();
        }
    }
}
