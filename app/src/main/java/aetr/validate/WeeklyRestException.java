package aetr.validate;

public class WeeklyRestException extends RuntimeException{
    public WeeklyRestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
