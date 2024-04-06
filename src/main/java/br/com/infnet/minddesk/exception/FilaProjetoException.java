package br.com.infnet.minddesk.exception;

public class FilaProjetoException extends RuntimeException{

    public FilaProjetoException(String message) {
        super(message);
    }

    public FilaProjetoException(String message, Throwable cause) {
        super(message, cause);
    }
}

