package modelo.transformaciones;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BendicionDelRioTest {

    private CriaturaDomesticada domesticada;
    private BendicionDelRio bendicion;

    @Before
    public void setUp() {
        domesticada = new CriaturaDomesticada("Luna", 80, Arrays.asList(Afinidad.AGUA));
        bendicion = new BendicionDelRio(domesticada);
    }

    @Test
    public void testAplicarTransformacionDuplicaEnergia() {
        
        assertEquals(80, domesticada.getEnergia());

       
        bendicion.aplicar(domesticada);

        
        assertEquals(160, domesticada.getEnergia());
    }

    @Test
    public void testAplicarTransformacionLimiteEnergia() {
        
        domesticada.setEnergia(100);

        
        bendicion.aplicar(domesticada);

        
        assertEquals(180, domesticada.getEnergia());
    }

    @Test
    public void testAplicarTransformacionEnergiaMenorLimite() {
        domesticada.setEnergia(50);
        bendicion.aplicar(domesticada);
        assertEquals(100, domesticada.getEnergia());
    }
}
