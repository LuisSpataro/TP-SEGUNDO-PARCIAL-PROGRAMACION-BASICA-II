package modelo.criatura;

import modelo.criatura.Criatura.Afinidad;
import modelo.excepciones.EnergiaExcedidaException;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CriaturaAncestralTest {

    private CriaturaAncestral ancestral;
    private List<Afinidad> afinidades;

    @Before
    public void setUp() {
        afinidades = Arrays.asList(Afinidad.AIRE, Afinidad.FUEGO);
        ancestral = new CriaturaAncestral("Thor", 120, afinidades);
    }

    @Test
    public void testEnergiaInicialMayor100() {
        CriaturaAncestral c = new CriaturaAncestral("Test", 50, afinidades);
        assertTrue(c.getEnergia() >= 100); // La energía mínima es 100
    }

    @Test
    public void testEntrenarIncrementaEnergia() throws EnergiaExcedidaException {
        int energiaAntes = ancestral.getEnergia();
        ancestral.entrenar(10); // +10 + 20 extra de Ancestral
        assertEquals(energiaAntes + 30, ancestral.getEnergia());
    }

    @Test(expected = EnergiaExcedidaException.class)
    public void testEntrenarExcedeEnergia() throws EnergiaExcedidaException {
        ancestral.entrenar(100); // Debería superar 200 y lanzar excepción
    }

    @Test
    public void testPacificar() {
        ancestral.volverInestable();
        ancestral.pacificar();
        assertFalse(ancestral.isInestable());
    }

    @Test
    public void testVolverTranquila() throws EnergiaExcedidaException {
        ancestral.volverInestable();
        ancestral.setEnergia(50); // Menor a 100
        ancestral.volverTranquila();
        assertFalse(ancestral.isInestable());
        assertEquals(100, ancestral.getEnergia());
    }
}
