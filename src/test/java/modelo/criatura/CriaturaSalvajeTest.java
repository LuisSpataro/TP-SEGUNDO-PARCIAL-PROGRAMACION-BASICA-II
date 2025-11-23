package modelo.criatura;

import modelo.criatura.Criatura.Afinidad;
import modelo.excepciones.EnergiaExcedidaException;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CriaturaSalvajeTest {

    private CriaturaSalvaje salvaje;
    private List<Afinidad> afinidades;

    @Before
    public void setUp() {
        afinidades = Arrays.asList(Afinidad.FUEGO, Afinidad.AIRE);
        salvaje = new CriaturaSalvaje("Fang", 120, afinidades);
    }

    @Test
    public void testEnergiaInicial() {
        assertEquals(120, salvaje.getEnergia());
    }

    @Test
    public void testEntrenarIncrementaEnergia() throws EnergiaExcedidaException {
        int energiaAntes = salvaje.getEnergia();
        salvaje.entrenar(30);
        assertEquals(energiaAntes + 30, salvaje.getEnergia());
    }

    @Test(expected = EnergiaExcedidaException.class)
    public void testEntrenarExcedeEnergia() throws EnergiaExcedidaException {
        salvaje.entrenar(100); 
    }

    @Test
    public void testPacificar() {
        assertTrue(salvaje.isInestable()); 
        salvaje.pacificar();
        assertFalse(salvaje.isInestable());
    }
}
