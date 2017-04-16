package be.ac.ulb.infof307.g07.lib.errors;

public class WrongTypeFieldException extends Exception {
    public WrongTypeFieldException (String s) {
        super("Wrong tpye field: " + s);
    }
}
