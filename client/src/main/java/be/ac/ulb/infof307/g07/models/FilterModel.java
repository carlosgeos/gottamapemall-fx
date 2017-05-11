package be.ac.ulb.infof307.g07.models;

/**
 * Cette classe a pour but d'abstraire la création de filtre pour les sauvegarder
 * sur le serveur en utilisant notament "Gson".
 */
public class FilterModel {
    private String query;
    private String name;

    public String getName() {
        return this.name; 
    }

    public String getQuery() {
        return this.query; 
    }

    public FilterModel(String query, String name) {
        this.query = query;
        this.name = name;
    }

    public FilterModel(String query) {
        this.query = query;
        this.name = query;
    }
}
