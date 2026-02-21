package Exceptions;

public class ProveedorNoExisteException extends RuntimeException {
    public ProveedorNoExisteException(String message) {
        super(message);
    }
}
