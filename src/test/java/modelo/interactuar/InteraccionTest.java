package modelo.interactuar;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import modelo.criatura.CriaturaAncestral;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InteraccionTest {

    private Interaccion interaccion;

    @Before
    public void setUp() {
        interaccion = new Interaccion();
    }

    @Test
    public void testMismaAfinidad() {
        CriaturaSalvaje c1 = new CriaturaSalvaje("C1", 100, Arrays.asList(Afinidad.FUEGO));
        CriaturaSalvaje c2 = new CriaturaSalvaje("C2", 150, Arrays.asList(Afinidad.FUEGO));

        interaccion.interactuar(c1, c2);

        assertEquals(110, c1.getEnergia());
        assertEquals(160, c2.getEnergia());
    }

    @Test
    public void testAfinidadesOpuestas() {
        CriaturaSalvaje agua = new CriaturaSalvaje("Agua", 50, Arrays.asList(Afinidad.AGUA));
        CriaturaSalvaje fuego = new CriaturaSalvaje("Fuego", 100, Arrays.asList(Afinidad.FUEGO));

        interaccion.interactuar(agua, fuego);

        assertTrue(agua.isInestable());
        assertTrue(fuego.isInestable());
    }

    @Test
    public void testDominioAncestral() {
        CriaturaAncestral ancestral = new CriaturaAncestral("Anc", 190, Arrays.asList(Afinidad.AIRE));
        CriaturaSalvaje normal = new CriaturaSalvaje("Normal", 50, Arrays.asList(Afinidad.AGUA));

        interaccion.interactuar(ancestral, normal);

        assertEquals(200, ancestral.getEnergia());
        assertEquals(35, normal.getEnergia());
    }

    @Test
    public void testEnergiaMaximaMinima() {
        CriaturaAncestral anc = new CriaturaAncestral("Anc", 195, Arrays.asList(Afinidad.FUEGO));
        CriaturaSalvaje normal = new CriaturaSalvaje("Normal", 10, Arrays.asList(Afinidad.AGUA));

        interaccion.interactuar(anc, normal);

        assertEquals(200, anc.getEnergia());
        assertEquals(0, normal.getEnergia());
    }

    @Test
    public void testNoModificaCuandoNadaAplica() {
        CriaturaSalvaje c1 = new CriaturaSalvaje("C1", 50, Arrays.asList(Afinidad.FUEGO));
        CriaturaSalvaje c2 = new CriaturaSalvaje("C2", 60, Arrays.asList(Afinidad.TIERRA));

        interaccion.interactuar(c1, c2);

        assertEquals(50, c1.getEnergia());
        assertEquals(60, c2.getEnergia());
        assertFalse(c1.isInestable());
        assertFalse(c2.isInestable());
    }
}



