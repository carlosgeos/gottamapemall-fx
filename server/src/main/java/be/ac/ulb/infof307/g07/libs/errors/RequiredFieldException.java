package be.ac.ulb.infof307.g07.libs.errors;

public class RequiredFieldException extends Exception {
    public RequiredFieldException (String s) {
        super("Required field: " + s);
    }
}