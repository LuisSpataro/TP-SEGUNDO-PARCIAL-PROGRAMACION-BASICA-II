package modelo.excepciones;

public class EnergiaExcedidaException extends Exception {
    private static final long serialVersionUID = 1L;

    public EnergiaExcedidaException(String mensaje) {
        super(mensaje);
    }
}
