package be.ac.ulb.infof307.g07.libs;

/**
 * La classe "Error" sert à abstraire un message d'erreur qui va être renvoyé 
 * aux utilisateur de l'API, elle ne stocke qu'un message en son sein qui est
 * là pour seul but d'être serialisé en json.
 *
 * @see be.ac.ulb.infof307.g07.libs.Message
 * @see com.google.gson.Gson
 */
public class Error {
    /**
     * Stocke le message d'erreur affiché aux utilisateurs de l'API.
     */
    String error;
    /**
     * Stocke les détails éventuels à propos de l'erreur.
     */
    String detail;

    public Error (String error) {
        this.error = error;
    }

    public Error (String error, String detail) {
        this.error = error;
        this.detail = detail;
    }
}
