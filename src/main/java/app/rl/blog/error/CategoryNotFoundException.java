package app.rl.blog.error;

public class CategoryNotFoundException extends java.lang.Exception {

    public CategoryNotFoundException() {

        super();
    }
    
    
    public CategoryNotFoundException(String message) {

        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }
    
    public CategoryNotFoundException(Throwable cause) {

        super(cause);
    }

    public CategoryNotFoundException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace
            ) {
        
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
