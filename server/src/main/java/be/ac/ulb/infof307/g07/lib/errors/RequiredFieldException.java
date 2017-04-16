package be.ac.ulb.infof307.g07.lib.errors;

public class RequiredFieldException extends Exception {
    public RequiredFieldException (String s) {
        super("Required field: " + s);
    }
}