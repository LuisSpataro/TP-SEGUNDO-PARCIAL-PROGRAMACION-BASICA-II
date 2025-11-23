package modelo.criatura;

import java.util.List;
import modelo.excepciones.EnergiaExcedidaException;

public class CriaturaAncestral extends Criatura {

    public CriaturaAncestral(String nombre, int energia, List<Afinidad> afinidades) {
        super(nombre, Math.max(energia, 100), afinidades, false); // energía mínima 100
    }

    @Override
    public void entrenar(int cantidad) throws EnergiaExcedidaException {
        this.energia += cantidad + 20;
        if (this.energia > 200) {
            throw new EnergiaExcedidaException("Un ancestral no puede superar 200 de energía");
        }
    }

    @Override
    public void pacificar() {
        this.inestable = false;
    }

    @Override
    public void volverTranquila() {
        this.inestable = false;
        if (this.energia < 100) {
            this.energia = 100;
        }
    }
}
