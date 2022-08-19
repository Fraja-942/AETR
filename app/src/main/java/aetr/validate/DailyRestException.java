package aetr.validate;

public class DailyRestException  extends RuntimeException{
    public DailyRestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
