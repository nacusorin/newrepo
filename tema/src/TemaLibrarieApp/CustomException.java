package TemaLibrarieApp;

import TemaLibrarieApp.Catalog;

public class CustomException extends Exception {
    /**
     * Constructs a <code>FileNotFoundException</code> with the
     * specified detail message. The string <code>s</code> can be
     * retrieved later by the
     * <code>{@link Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param message the detail message.
     */
    public CustomException(String message) {

        super(message);
    }
}


