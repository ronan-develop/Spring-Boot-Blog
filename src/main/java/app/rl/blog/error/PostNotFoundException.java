package app.rl.blog.error;

public class PostNotFoundException extends java.lang.Exception {

    public PostNotFoundException() {

        super();
    }
    
    
    public PostNotFoundException(String message) {

        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }
    
    public PostNotFoundException(Throwable cause) {

        super(cause);
    }

    public PostNotFoundException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace
            ) {
        
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
