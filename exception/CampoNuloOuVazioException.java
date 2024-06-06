package exception;

public class CampoNuloOuVazioException extends Exception {
    public CampoNuloOuVazioException(String campo) {
        super("O campo '" + campo + "' é obrigatório e não pode ser nulo ou vazio.");
    }
}