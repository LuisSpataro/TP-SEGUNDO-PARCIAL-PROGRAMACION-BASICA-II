package modelo.transformaciones;

import modelo.criatura.Criatura;
import java.util.ArrayList;
import java.util.List;

public class AscensoDelViento extends Transformacion {

    public AscensoDelViento(Criatura base) {
        super(base);
    }

    @Override
    public void aplicar(Criatura criatura) {
        List<Criatura.Afinidad> nuevasAfinidades = new ArrayList<>(criatura.getAfinidades());
        if (!nuevasAfinidades.contains(Criatura.Afinidad.AIRE)) {
            nuevasAfinidades.add(Criatura.Afinidad.AIRE);
        }
        criatura.setAfinidades(nuevasAfinidades);
    }
}
