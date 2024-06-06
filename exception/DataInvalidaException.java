package exception;

public class DataInvalidaException extends Exception {
    public DataInvalidaException() {
        super("Data de nascimento inválida. Utilize o formato dd/mm/yyyy");
    } 
}