package exception;

public class NomeInvalidoException extends Exception {
    public NomeInvalidoException() {
        super("Nome inválido. Digite apenas letras e espaços.");
    }
    
}