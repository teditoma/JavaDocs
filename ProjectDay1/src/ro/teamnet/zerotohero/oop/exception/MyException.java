package ro.teamnet.zerotohero.oop.exception;

/**
 * Created by Theodor.Toma on 7/4/2017.
 */
public class MyException extends RuntimeException {
    public MyException() {
        super();
    }

    public MyException(String err){
        super(err);
    }

    public MyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
