package br.com.infnet.minddesk.exception;

public class FilaSuporteException extends RuntimeException{

    public FilaSuporteException(String message) {
        super(message);
    }

    public FilaSuporteException(String message, Throwable cause) {
        super(message, cause);
    }
}

