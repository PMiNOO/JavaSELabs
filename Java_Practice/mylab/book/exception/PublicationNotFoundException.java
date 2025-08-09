package mylab.book.exception;

public class PublicationNotFoundException extends Exception {
    public PublicationNotFoundException(String message) {
        super(message);
    }
}