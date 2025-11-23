package modelo.maestro;

import modelo.criatura.Criatura;
import modelo.transformaciones.Transformacion;
import modelo.excepciones.EnergiaExcedidaException;
import modelo.excepciones.FaltaMaestriaException;

import java.util.HashMap;
import java.util.Map;

public class MaestroElemental {

    private String nombre;
    private int nivelMaestria; // 1–50
    private Criatura.Afinidad afinidadPrincipal;
    private Map<String, Criatura> criaturas;

    public MaestroElemental(String nombre, int nivelMaestria, Criatura.Afinidad afinidadPrincipal) {
        this.nombre = nombre;
        this.nivelMaestria = nivelMaestria;
        this.afinidadPrincipal = afinidadPrincipal;
        this.criaturas = new HashMap<>();
    }

    public void agregarCriatura(Criatura criatura) {
        criaturas.put(criatura.getNombre(), criatura);
    }

    public Map<String, Criatura> getCriaturas() {
        return criaturas;
    }

    public void entrenarCriatura(String nombreCriatura, int cantidad) throws FaltaMaestriaException, EnergiaExcedidaException {
        Criatura criatura = criaturas.get(nombreCriatura);
        if (criatura == null) return;

        if (nivelMaestria < 5) { // ejemplo de validación
            throw new FaltaMaestriaException("El maestro no tiene maestría suficiente para entrenar esta criatura.");
        }

        criatura.entrenar(cantidad);
    }

    public void pacificarCriatura(String nombreCriatura) {
        Criatura criatura = criaturas.get(nombreCriatura);
        if (criatura == null) return;

        criatura.pacificar();
    }

    public void transformarCriatura(String nombreCriatura, Transformacion transformacion) throws EnergiaExcedidaException {
        Criatura criatura = criaturas.get(nombreCriatura);
        if (criatura == null) return;

        
        criaturas.put(nombreCriatura, transformacion);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivelMaestria() {
        return nivelMaestria;
    }

    public Criatura.Afinidad getAfinidadPrincipal() {
        return afinidadPrincipal;
    }
}

