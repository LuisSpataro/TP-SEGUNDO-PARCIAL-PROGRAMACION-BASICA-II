package modelo.transformaciones;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class VinculoTerrestreTest {

    private CriaturaSalvaje salvajeBaja;
    private CriaturaDomesticada domesticadaMedia;
    private CriaturaAncestral ancestralAlta;

    @Before
    public void setUp() {
        // Energía < 50
        salvajeBaja = new CriaturaSalvaje("FangBajo", 30, Arrays.asList(Afinidad.TIERRA));

        // Energía = 50
        domesticadaMedia = new CriaturaDomesticada("LunaMedia", 50, Arrays.asList(Afinidad.AGUA));

        // Energía > 50
        ancestralAlta = new CriaturaAncestral("ThorAlto", 100, Arrays.asList(Afinidad.AIRE));
    }

    @Test
    public void testAplicarVinculoTerrestre() {
        
        VinculoTerrestre vt1 = new VinculoTerrestre(salvajeBaja);
        vt1.aplicar(salvajeBaja);
        assertEquals("Energía mínima no aplicada correctamente", 50, salvajeBaja.getEnergia());

        
        VinculoTerrestre vt2 = new VinculoTerrestre(domesticadaMedia);
        vt2.aplicar(domesticadaMedia);
        assertEquals("Energía igual a 50 no debe cambiar", 50, domesticadaMedia.getEnergia());

       
        VinculoTerrestre vt3 = new VinculoTerrestre(ancestralAlta);
        vt3.aplicar(ancestralAlta);
        assertEquals("Energía mayor a 50 no debe modificarse", 100, ancestralAlta.getEnergia());
    }

    @Test
    public void testAplicarVariasVeces() {
        
        salvajeBaja.setEnergia(10);
        VinculoTerrestre vt = new VinculoTerrestre(salvajeBaja);
        vt.aplicar(salvajeBaja);
        assertEquals(50, salvajeBaja.getEnergia());

        vt.aplicar(salvajeBaja);
        assertEquals(50, salvajeBaja.getEnergia());
    }

    @Test
    public void testReferenciasDistintasCriaturas() {
        
        CriaturaSalvaje c1 = new CriaturaSalvaje("C1", 20, Arrays.asList(Afinidad.FUEGO));
        CriaturaDomesticada c2 = new CriaturaDomesticada("C2", 45, Arrays.asList(Afinidad.AGUA));
        CriaturaAncestral c3 = new CriaturaAncestral("C3", 60, Arrays.asList(Afinidad.AIRE));

        VinculoTerrestre vt1 = new VinculoTerrestre(c1);
        VinculoTerrestre vt2 = new VinculoTerrestre(c2);
        VinculoTerrestre vt3 = new VinculoTerrestre(c3);

        vt1.aplicar(c1);
        vt2.aplicar(c2);
        vt3.aplicar(c3);

        assertEquals(50, c1.getEnergia());
        assertEquals(50, c2.getEnergia());
        assertEquals(60, c3.getEnergia());
    }
}

