package modelo.reportes;

import modelo.criatura.*;
import modelo.criatura.Criatura.Afinidad;
import modelo.maestro.MaestroElemental;
import modelo.transformaciones.Transformacion;
import modelo.transformaciones.VinculoTerrestre;
import modelo.excepciones.EnergiaExcedidaException;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class GeneradorDeReportesTest {

    private MaestroElemental maestro1;
    private MaestroElemental maestro2;
    private CriaturaSalvaje salvaje1;
    private CriaturaDomesticada dom1;
    private CriaturaAncestral ancestral1;
    private GeneradorDeReportes generador;

    @Before
    public void setUp() {
        maestro1 = new MaestroElemental("Merlin", 10, Afinidad.FUEGO);
        maestro2 = new MaestroElemental("Morgana", 8, Afinidad.AGUA);

        salvaje1 = new CriaturaSalvaje("Fang", 100, Arrays.asList(Afinidad.FUEGO));
        dom1 = new CriaturaDomesticada("Luna", 80, Arrays.asList(Afinidad.AGUA));
        ancestral1 = new CriaturaAncestral("Thor", 150, Arrays.asList(Afinidad.AIRE));

        maestro1.agregarCriatura(salvaje1);
        maestro1.agregarCriatura(dom1);
        maestro2.agregarCriatura(ancestral1);

        generador = new GeneradorDeReportes(Arrays.asList(maestro1, maestro2));
    }

    @Test
    public void testListarTodasLasCriaturas() {
        List<Criatura> todas = generador.listarTodasLasCriaturas();
        assertEquals(3, todas.size());
        assertTrue(todas.contains(salvaje1));
        assertTrue(todas.contains(dom1));
        assertTrue(todas.contains(ancestral1));
    }

    @Test
    public void testCriaturaMayorEnergia() {
        Criatura mayor = generador.criaturaConMayorEnergia();
        assertEquals(ancestral1, mayor);
    }

    @Test
    public void testMaestroConMasTransformadas() throws EnergiaExcedidaException {
        Transformacion t = new VinculoTerrestre(salvaje1);
        maestro1.transformarCriatura("Fang", t);

        MaestroElemental top = generador.maestroConMasTransformadas();
        assertEquals(maestro1, top);
    }

    @Test
    public void testCantidadPorAfinidad() {
        HashMap<Afinidad, Integer> mapa = generador.cantidadPorAfinidad();
        assertEquals(Integer.valueOf(1), mapa.get(Afinidad.FUEGO));
        assertEquals(Integer.valueOf(1), mapa.get(Afinidad.AGUA));
        assertEquals(Integer.valueOf(1), mapa.get(Afinidad.AIRE));
    }
}

