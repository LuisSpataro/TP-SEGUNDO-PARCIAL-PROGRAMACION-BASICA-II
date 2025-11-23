package modelo.reportes;

import modelo.maestro.MaestroElemental;
import modelo.criatura.Criatura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneradorDeReportes {

    private List<MaestroElemental> maestros;

    public GeneradorDeReportes(List<MaestroElemental> maestros) {
        this.maestros = maestros;
    }

    public List<Criatura> listarTodasLasCriaturas() {
        List<Criatura> resultado = new ArrayList<>();
        for (MaestroElemental m : maestros) {
            resultado.addAll(m.getCriaturas().values());
        }
        return resultado;
    }

    public Criatura criaturaConMayorEnergia() {
        List<Criatura> todas = listarTodasLasCriaturas();
        if (todas.isEmpty()) return null;

        Criatura max = todas.get(0);
        for (Criatura c : todas) {
            if (c.getEnergia() > max.getEnergia()) {
                max = c;
            }
        }
        return max;
    }

    public MaestroElemental maestroConMasTransformadas() {
        MaestroElemental top = null;
        int maxTransformadas = -1;

        for (MaestroElemental m : maestros) {
            int count = 0;
            for (Criatura c : m.getCriaturas().values()) {
                if (c.getClass().getSimpleName().contains("Transformacion")) {
                    count++;
                }
            }
            if (count > maxTransformadas) {
                maxTransformadas = count;
                top = m;
            }
        }
        return top;
    }

    public HashMap<Criatura.Afinidad, Integer> cantidadPorAfinidad() {
        HashMap<Criatura.Afinidad, Integer> map = new HashMap<>();
        for (Criatura c : listarTodasLasCriaturas()) {
            for (Criatura.Afinidad a : c.getAfinidades()) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }
        return map;
    }
}


