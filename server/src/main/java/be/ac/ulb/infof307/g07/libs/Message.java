package be.ac.ulb.infof307.g07.libs;

/**
 * La classe "Message"" sert à abstraire un message d'information qui va être 
 * renvoyé aux utilisateur de l'API, elle ne stocke qu'un message en son sein 
 * qui est là pour seul but d'être serialisé en json.
 *
 * @see be.ac.ulb.infof307.g07.libs.Error
 * @see com.google.gson.Gson
 */
public class Message {
    /**
     * Stocke le message d'information affiché aux utilisateurs de l'API.
     */
    String message;

    public Message (String message) {
        this.message = message;
    }
}
