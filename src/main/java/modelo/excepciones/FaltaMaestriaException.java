package modelo.excepciones;

public class FaltaMaestriaException extends Exception {
    private static final long serialVersionUID = 1L;

    public FaltaMaestriaException(String mensaje) {
        super(mensaje);
    }
}
