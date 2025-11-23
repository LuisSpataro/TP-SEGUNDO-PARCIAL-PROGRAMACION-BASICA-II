package modelo.criatura;

import java.util.List;
import modelo.excepciones.EnergiaExcedidaException;

public class CriaturaDomesticada extends Criatura {

    public CriaturaDomesticada(String nombre, int energia, List<Afinidad> afinidades) {
        super(nombre, energia, afinidades, false);
    }

    @Override
    public void entrenar(int cantidad) throws EnergiaExcedidaException {
        this.energia += cantidad;
        if (this.energia > 200) {
            throw new EnergiaExcedidaException("Domesticada no puede superar 200 de energía");
        }
    }

    @Override
    public void pacificar() {
        this.inestable = false;
    }
}
