package be.bstorm.tf_java2023_springtest.exceptions;

public class TitleBookException extends RuntimeException{
    public TitleBookException() {
        super("Title already taken");
    }

    public TitleBookException(String message) {
        super(message);
    }
}
