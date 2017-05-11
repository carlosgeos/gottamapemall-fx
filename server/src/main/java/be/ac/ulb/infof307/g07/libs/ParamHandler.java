package be.ac.ulb.infof307.g07.libs;

import java.lang.IllegalArgumentException;

@FunctionalInterface
public interface ParamHandler {
    /**
     * Utilisé pour changé la forme des valeurs des requètes HTTP (ex. parser en 
     * tant qu'entier).
     *
     * @param param La valeur récupérer de la requète HTTP.
     * @return La version modifiée
     * @throws java.lang.IllegalArgumentException L'implémentation choist 
     *      l'exception qui va être renvoyé.
     */
    public Object handle(String param) throws IllegalArgumentException;
}
