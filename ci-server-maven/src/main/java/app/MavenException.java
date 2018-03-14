package app;

/**
 * Customer defined exception telling unsupported Maven command
 * 
 * @author allwi
 *
 */
public class MavenException extends Exception {

    private static final long serialVersionUID = 1L;

    public MavenException(String message) {
        super(message);
    }

    public MavenException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
