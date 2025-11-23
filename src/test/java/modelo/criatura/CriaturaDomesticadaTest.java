package modelo.criatura;

import modelo.criatura.Criatura.Afinidad;
import modelo.excepciones.EnergiaExcedidaException;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CriaturaDomesticadaTest {

    private CriaturaDomesticada domesticada;
    private List<Afinidad> afinidades;

    @Before
    public void setUp() {
        afinidades = Arrays.asList(Afinidad.AGUA, Afinidad.TIERRA);
        domesticada = new CriaturaDomesticada("Luna", 100, afinidades);
    }

    @Test
    public void testEnergiaInicial() {
        assertEquals(100, domesticada.getEnergia());
    }

    @Test
    public void testEntrenarIncrementaEnergia() throws EnergiaExcedidaException {
        int energiaAntes = domesticada.getEnergia();
        domesticada.entrenar(20);
        assertEquals(energiaAntes + 20, domesticada.getEnergia());
    }

    @Test(expected = EnergiaExcedidaException.class)
    public void testEntrenarExcedeEnergia() throws EnergiaExcedidaException {
        domesticada.entrenar(150); // 100 + 150 = 250 > 200
    }

    @Test
    public void testPacificar() {
        domesticada.volverInestable();
        domesticada.pacificar();
        assertFalse(domesticada.isInestable());
    }
}
