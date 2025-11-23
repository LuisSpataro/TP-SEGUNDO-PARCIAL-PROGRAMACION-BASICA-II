package modelo.criatura;

import java.util.List;
import modelo.excepciones.EnergiaExcedidaException;

public class CriaturaSalvaje extends Criatura {

    public CriaturaSalvaje(String nombre, int energia, List<Afinidad> afinidades) {
        super(nombre, energia, afinidades, true);
    }

    @Override
    public void entrenar(int cantidad) throws EnergiaExcedidaException {
        this.energia += cantidad;
        if (this.energia > 200) {
            throw new EnergiaExcedidaException("Salvaje no puede superar 200 de energía");
        }
    }

    @Override
    public void pacificar() {
        this.inestable = false;
    }
}
