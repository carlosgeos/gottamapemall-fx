package be.ac.ulb.infof307.g07.lib;

@FunctionalInterface
public interface ParamHandler {

    /**
     * Used to change the form of a value from a HTTP request e.g parse as an int.
     *
     * @param param The value retrieved from the HTTP request.
     * @return The modified version.
     * @throws java.lang.Exception implementation can choose to throw exception
     */
    public Object handle(String param) throws Exception;
}