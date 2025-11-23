package modelo.interactuar;

import modelo.criatura.Criatura;
import modelo.criatura.Criatura.Afinidad;
import modelo.criatura.CriaturaAncestral;

public class Interaccion {

    public void interactuar(Criatura a, Criatura b) {

 
        if (a instanceof CriaturaAncestral) {
            aplicarDominioAncestral((CriaturaAncestral) a, b);
            return;
        }

        if (b instanceof CriaturaAncestral) {
            aplicarDominioAncestral((CriaturaAncestral) b, a);
            return;
        }

      
        if (compartenAfinidad(a, b)) {
            a.setEnergia(a.getEnergia() + 10);
            b.setEnergia(b.getEnergia() + 10);
            return;
        }

        if (sonOpuestas(a, b)) {
            a.volverInestable();
            b.volverInestable();
        }
    }


    private boolean compartenAfinidad(Criatura a, Criatura b) {
        return a.getAfinidades().stream().anyMatch(
                af -> b.getAfinidades().contains(af)
        );
    }

    private boolean sonOpuestas(Criatura a, Criatura b) {
        for (Afinidad afA : a.getAfinidades()) {
            for (Afinidad afB : b.getAfinidades()) {
                if ((afA == Afinidad.AGUA && afB == Afinidad.FUEGO) ||
                    (afA == Afinidad.FUEGO && afB == Afinidad.AGUA) ||
                    (afA == Afinidad.AIRE && afB == Afinidad.TIERRA) ||
                    (afA == Afinidad.TIERRA && afB == Afinidad.AIRE)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void aplicarDominioAncestral(CriaturaAncestral ancestral, Criatura otra) {
        // La ancestral gana +20 energía (máx 200)
        int nuevaEnergiaA = Math.min(ancestral.getEnergia() + 20, 200);
        ancestral.setEnergia(nuevaEnergiaA);

        // La otra pierde -15 energía (mín 0)
        int nuevaEnergiaB = Math.max(otra.getEnergia() - 15, 0);
        otra.setEnergia(nuevaEnergiaB);
    }
}
