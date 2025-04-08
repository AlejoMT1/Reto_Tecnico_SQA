package co.sqasa.exeptions;

public class ProductoNoEncontradoException extends AssertionError {

    public  static final String FECHA_NO_ESPERADA = "La fecha seleccionada no es la esperada";

    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}