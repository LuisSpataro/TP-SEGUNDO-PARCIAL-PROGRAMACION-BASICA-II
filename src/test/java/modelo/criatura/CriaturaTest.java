package modelo.criatura;

import modelo.criatura.Criatura.Afinidad;
import modelo.excepciones.EnergiaExcedidaException;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CriaturaTest {

    private CriaturaSalvaje salvaje;
    private CriaturaDomesticada domesticada;
    private CriaturaAncestral ancestral;

    @Before
    public void setUp() {
        List<Afinidad> afinidadesFuego = Arrays.asList(Afinidad.FUEGO);
        List<Afinidad> afinidadesAgua = Arrays.asList(Afinidad.AGUA);
        List<Afinidad> afinidadesAire = Arrays.asList(Afinidad.AIRE);

        salvaje = new CriaturaSalvaje("Fang", 100, afinidadesFuego);
        domesticada = new CriaturaDomesticada("Luna", 80, afinidadesAgua);
        ancestral = new CriaturaAncestral("Thor", 150, afinidadesAire);
    }

   
    @Test
    public void testSalvajeEntrenamiento() throws EnergiaExcedidaException {
        int energiaInicial = salvaje.getEnergia();
        salvaje.entrenar(10);
        assertEquals(energiaInicial + 10, salvaje.getEnergia());
    }

    @Test
    public void testSalvajePacificar() {
        salvaje.volverInestable();
        salvaje.pacificar();
        assertFalse(salvaje.isInestable());
    }

    
    @Test
    public void testDomesticadaEntrenamiento() throws EnergiaExcedidaException {
        int energiaInicial = domesticada.getEnergia();
        domesticada.entrenar(15);
        assertEquals(energiaInicial + 15, domesticada.getEnergia());
    }

    @Test
    public void testDomesticadaPacificar() {
        domesticada.volverInestable();
        domesticada.pacificar();
        assertFalse(domesticada.isInestable());
    }

    
    @Test
    public void testAncestralEntrenamiento() throws EnergiaExcedidaException {
        int energiaInicial = ancestral.getEnergia();
        ancestral.entrenar(20); // ancestral suma +20 internamente
        assertEquals(energiaInicial + 20 + 20, ancestral.getEnergia());
    }

    @Test(expected = EnergiaExcedidaException.class)
    public void testAncestralEnergiaMaxima() throws EnergiaExcedidaException {
        ancestral.entrenar(100); // debería superar 200 y lanzar excepción
    }

    @Test
    public void testAncestralPacificar() {
        ancestral.volverInestable();
        ancestral.pacificar();
        assertFalse(ancestral.isInestable());
    }

    @Test
    public void testAncestralEnergiaMinima() {
        ancestral.setEnergia(50);
        ancestral.volverTranquila();
        assertEquals(100, ancestral.getEnergia()); // energía mínima 100
    }
}
