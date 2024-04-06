package br.com.infnet.minddesk.exception;

public class FilaCormecialException extends RuntimeException{

    public FilaCormecialException(String message) {
        super(message);
    }

    public FilaCormecialException(String message, Throwable cause) {
        super(message, cause);
    }
}
