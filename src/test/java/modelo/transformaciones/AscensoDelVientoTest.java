package modelo.transformaciones;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AscensoDelVientoTest {

    private CriaturaSalvaje salvaje;
    private AscensoDelViento ascenso;

    @Before
    public void setUp() {
        
        salvaje = new CriaturaSalvaje("Fang", 100, Arrays.asList(Afinidad.FUEGO));
        ascenso = new AscensoDelViento(salvaje);
    }

    @Test
    public void testAplicarTransformacionAgregaAfinidadAire() {
        
        List<Afinidad> antes = salvaje.getAfinidades();
        assertFalse(antes.contains(Afinidad.AIRE));

        
        ascenso.aplicar(salvaje);

        
        List<Afinidad> despues = salvaje.getAfinidades();
        assertTrue(despues.contains(Afinidad.AIRE));
        assertEquals(2, despues.size()); // 
    }

    @Test
    public void testAplicarTransformacionNoDuplicaAfinidad() {
        
        salvaje.setAfinidades(Arrays.asList(Afinidad.FUEGO, Afinidad.AIRE));

        
        ascenso.aplicar(salvaje);

       
        List<Afinidad> despues = salvaje.getAfinidades();
        assertEquals(2, despues.size());
        assertTrue(despues.contains(Afinidad.AIRE));
        assertTrue(despues.contains(Afinidad.FUEGO));
    }
}
