package app;
import modelo.criatura.*;
import modelo.maestro.MaestroElemental;
import modelo.reportes.GeneradorDeReportes;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Criatura fang = new CriaturaSalvaje("Fang", 100, Arrays.asList(Criatura.Afinidad.FUEGO));
        Criatura luna = new CriaturaDomesticada("Luna", 80, Arrays.asList(Criatura.Afinidad.AGUA));
        Criatura thor = new CriaturaAncestral("Thor", 150, Arrays.asList(Criatura.Afinidad.AIRE));

        MaestroElemental maestro1 = new MaestroElemental("Aldor", 10, Criatura.Afinidad.FUEGO);
        MaestroElemental maestro2 = new MaestroElemental("Brina", 15, Criatura.Afinidad.AGUA);

        maestro1.agregarCriatura(fang);
        maestro1.agregarCriatura(thor);
        maestro2.agregarCriatura(luna);

        List<MaestroElemental> todosLosMaestros = Arrays.asList(maestro1, maestro2);
        GeneradorDeReportes reportes = new GeneradorDeReportes(todosLosMaestros);

        System.out.println("=== Todas las criaturas registradas ===");
        for (Criatura c : reportes.listarTodasLasCriaturas()) {
            System.out.println(c.getNombre() + " - Energía: " + c.getEnergia() + " - Afinidades: " + c.getAfinidades());
        }

        Criatura maxEnergia = reportes.criaturaConMayorEnergia();
        System.out.println("\nCriatura con mayor energía: " + maxEnergia.getNombre() + " (" + maxEnergia.getEnergia() + ")");

        MaestroElemental maestroTop = reportes.maestroConMasTransformadas();
        System.out.println("\nMaestro con más transformadas: " + (maestroTop != null ? maestroTop.getNombre() : "Ninguno"));

        System.out.println("\nCantidad de criaturas por afinidad:");
        for (var entry : reportes.cantidadPorAfinidad().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
