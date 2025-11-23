package modelo.maestro;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import modelo.excepciones.EnergiaExcedidaException;
import modelo.excepciones.FaltaMaestriaException;
import modelo.transformaciones.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class MaestroElementalTest {

    private MaestroElemental maestro;
    private CriaturaSalvaje salvaje;
    private CriaturaDomesticada domesticada;
    private CriaturaAncestral ancestral;

    @Before
    public void setUp() {
        maestro = new MaestroElemental("Merlin", 10, Afinidad.FUEGO);

        salvaje = new CriaturaSalvaje("Fang", 100, Arrays.asList(Afinidad.FUEGO));
        domesticada = new CriaturaDomesticada("Luna", 80, Arrays.asList(Afinidad.AGUA));
        ancestral = new CriaturaAncestral("Thor", 150, Arrays.asList(Afinidad.AIRE));

        maestro.agregarCriatura(salvaje);
        maestro.agregarCriatura(domesticada);
        maestro.agregarCriatura(ancestral);
    }

    // Getters
 
    @Test
    public void testGetters() {
        assertEquals("Merlin", maestro.getNombre());
        assertEquals(10, maestro.getNivelMaestria());
        assertEquals(Afinidad.FUEGO, maestro.getAfinidadPrincipal());
    }

 
    @Test
    public void testEntrenamientoCompleto() throws FaltaMaestriaException, EnergiaExcedidaException {
        
        int energiaSalvaje = salvaje.getEnergia();
        maestro.entrenarCriatura("Fang", 50);
        assertEquals(energiaSalvaje + 50, salvaje.getEnergia());

        
        int energiaDom = domesticada.getEnergia();
        maestro.entrenarCriatura("Luna", 100); // llevar al límite
        assertEquals(Math.min(energiaDom + 100, 200), domesticada.getEnergia());

        
        int energiaAncestral = ancestral.getEnergia();
        ancestral.setEnergia(180);
        try {
            maestro.entrenarCriatura("Thor", 50);
            fail("Debe lanzar EnergiaExcedidaException");
        } catch (EnergiaExcedidaException e) {
            assertTrue(e.getMessage().contains("Un ancestral no puede superar 200"));
        }

        // Entrenar criatura inexistente (no debe lanzar excepción)
        maestro.entrenarCriatura("NoExiste", 50);
    }

    @Test(expected = FaltaMaestriaException.class)
    public void testEntrenarConMaestriaBaja() throws FaltaMaestriaException, EnergiaExcedidaException {
        MaestroElemental maestroBajo = new MaestroElemental("Low", 3, Afinidad.AGUA);
        CriaturaSalvaje c = new CriaturaSalvaje("Rex", 50, Arrays.asList(Afinidad.AGUA));
        maestroBajo.agregarCriatura(c);
        maestroBajo.entrenarCriatura("Rex", 10);
    }

    
    @Test
    public void testPacificarCompleto() {
        salvaje.volverInestable();
        domesticada.volverInestable();
        ancestral.volverInestable();

        maestro.pacificarCriatura("Fang");
        maestro.pacificarCriatura("Luna");
        maestro.pacificarCriatura("Thor");

        assertFalse(salvaje.isInestable());
        assertFalse(domesticada.isInestable());
        assertFalse(ancestral.isInestable());

      
        maestro.pacificarCriatura("NoExiste");
    }

    
    @Test
    public void testTransformacionesCompletas() throws EnergiaExcedidaException {
        
        Transformacion viento = new AscensoDelViento(salvaje);
        Transformacion rio = new BendicionDelRio(domesticada);
        Transformacion fuego = new LlamaInterna(ancestral);
        Transformacion tierra = new VinculoTerrestre(salvaje);

        
        maestro.transformarCriatura("Fang", viento);
        maestro.transformarCriatura("Luna", rio);
        maestro.transformarCriatura("Thor", fuego);
        maestro.transformarCriatura("Fang", tierra);

        assertSame(maestro.getCriaturas().get("Fang"), tierra);
        assertSame(maestro.getCriaturas().get("Luna"), rio);
        assertSame(maestro.getCriaturas().get("Thor"), fuego);

        
        Transformacion t = new AscensoDelViento(salvaje);
        maestro.transformarCriatura("NoExiste", t); // no debe lanzar excepción
    }

   
    @Test
    public void testMapaCriaturasYValidaciones() throws FaltaMaestriaException, EnergiaExcedidaException {
        Map<String, Criatura> mapa = maestro.getCriaturas();
        assertEquals(3, mapa.size());
        assertTrue(mapa.containsKey("Fang"));
        assertTrue(mapa.containsKey("Luna"));
        assertTrue(mapa.containsKey("Thor"));

        
        for (Criatura c : mapa.values()) {
            if (maestro.getNivelMaestria() >= 5) {
                c.entrenar(10);
                c.pacificar();
            }
            assertFalse(c.isInestable());
        }
    }

   
    @Test
    public void testCombinacionesExtremas() throws FaltaMaestriaException, EnergiaExcedidaException {
       
        for (int i = 0; i < 5; i++) {
            maestro.entrenarCriatura("Fang", 5);
            maestro.pacificarCriatura("Fang");
            Transformacion t = new VinculoTerrestre(salvaje);
            maestro.transformarCriatura("Fang", t);
        }

        Criatura finalFang = maestro.getCriaturas().get("Fang");
        assertTrue(finalFang instanceof Transformacion);
    }
}

