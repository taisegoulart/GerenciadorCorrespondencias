package exceptions;

public class CampoVazioException extends Exception{

    public CampoVazioException() {
    }

    public CampoVazioException(String msg) {
        super(msg);
    }
}
