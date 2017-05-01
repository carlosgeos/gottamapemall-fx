package be.ac.ulb.infof307.g07.libs.errors;

public class WrongTypeFieldException extends Exception {
    public WrongTypeFieldException (String s) {
        super("Wrong tpye field: " + s);
    }
}
