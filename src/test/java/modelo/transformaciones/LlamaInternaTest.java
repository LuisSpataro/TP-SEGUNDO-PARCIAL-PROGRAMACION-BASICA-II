package modelo.transformaciones;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LlamaInternaTest {

    private CriaturaSalvaje fuego;
    private CriaturaDomesticada agua;

    @Before
    public void setUp() {
        fuego = new CriaturaSalvaje("Fang", 180, Arrays.asList(Afinidad.FUEGO));
        agua = new CriaturaDomesticada("Luna", 100, Arrays.asList(Afinidad.AGUA));
    }

    @Test
    public void testFuegoAumentaEnergia() {
        LlamaInterna transformacion = new LlamaInterna(fuego);

      
        assertEquals(200, fuego.getEnergia());

        
        assertTrue(fuego.isInestable()); // Salvaje ya es inestable por defecto
    }

    @Test
    public void testSinFuegoSeVuelveInestable() {
        LlamaInterna transformacion = new LlamaInterna(agua);

        
        assertEquals(100, agua.getEnergia());

        
        assertTrue(agua.isInestable());
    }
}
