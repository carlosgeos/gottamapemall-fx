package be.ac.ulb.infof307.g07.libs;

import static spark.Spark.*;
import spark.Request;
import com.google.gson.Gson;
import org.mongodb.morphia.query.Query;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;

import be.ac.ulb.infof307.g07.libs.CustomGson;
import be.ac.ulb.infof307.g07.libs.ParamHandler;
import be.ac.ulb.infof307.g07.libs.Message;
import be.ac.ulb.infof307.g07.libs.Database;
import be.ac.ulb.infof307.g07.libs.Error;

/**
 * Abstraction to create API endpoint for a specific model instance.
 *
 * @param <T> The model instance to create the API endpoint on.
 */
public abstract class ListView<T> {
    static protected Gson gson = CustomGson.get();

    /**
     * Utilisé pour définir la route.
     */
    protected abstract String getRoute ();

    /**
     * Utilisé pour définir le model utilisé.
     */
    protected abstract Class<T> getModel ();

    /**
     * Utilisé pour définir les champs qui peuvent être cherché.
     */
    protected String getSearchField () {
        return "name";
    }

    /**
     * Utilisé pour définir les champs qui peuvent être filtrés.
     */
    protected String[] getFiltersFields() {
        return new String[0];
    }

    /**
     * Récupère le paramètre de la requète. Il peut venir de l'url ou d'une form.
     *
     * @param req L'instance de la requète qui contient les infos HTTP.
     * @param key Clé du paramètre à récuperer.
     * @return Valeur du paramètre sous forme de String.
     */
    static protected String getParam(Request req, String key) {
        String param = "";
        
        return req.params(key);
    }

    /**
     * Récupère le paramètre de la requète et change sa forme.
     *
     * @param req L'instance de la requète qui contient les infos HTTP.
     * @param key Clé du paramètre à récuperer.
     * @param handler Fonction pour modifier la valeur du paramètre
     * @return La valeur du paramètre parśe.
     */
    static protected Object getParam(Request req, String key, ParamHandler handler) throws IllegalArgumentException {
        Object param = getParam(req, key);

        // Juste une chaine de charactère mais retourné comme un "Object" pour
        // prendre la forme voulu selon le cas.
        param = handler.handle((String) param);

        return param;
    }

    /**
     * Gère la recherche d'une valeur.
     *
     * @param current L'état actuel de l'ensemble de recherche.
     * @param query La recherche.
     *
     * @return L'état une fois la recherche effectuée.
     */
    protected Query<T> search (Query<T> current, String query) {
        return current.field(this.getSearchField()).contains(query);
    }

    /**
     * Gère de fournir des données correct à la méthode search.
     */
    private Query<T> handleSearch(Request req, Query<T> query) {
        String searchQuery = req.queryParams("search");
        if (searchQuery != null) {
            return search(query, searchQuery);
        }
        return query;    
    }

    /**
     * Gère le filtre des valeurs. Par défaut ne fait rien.
     *
     * @param current L'état actuel de l'ensemble à filtrer.
     * @param param Le champs à filtrer.
     * @param query Le filtre appliqué sur le champ.
     *
     * @return L'état une fois le filtre effectué.
     */
    protected Query<T> filter(Query<T> current, String param, String query) {
        return current;
    }

    /**
     * S'occupe d'envoyer les bonnes valeurs pour être filtrées.
     *
     * @param req L'instance de la requète qui contient les infos HTTP.
     * @param query L'état actuel de l'ensemble à filtrer.
     *
     * @return L'état une fois les filtres effectués.
     */
    private Query<T> handleFilters(Request req, Query<T> query) {
        String[] filters = getFiltersFields();
        for (int i = 0; i < filters.length; ++i) {
            String filterQuery = req.queryParams(filters[i]);
            if (filterQuery != null) {
                query = filter(query, filters[i], filterQuery);
            }
        }
        return query;
    }

    /**
     * Défini la route pour récuperer tout les objets d'un certain model
     * dans la base de donnée.
     */
    protected void viewsetRoute () {
        get(this.getRoute(), (req, res) -> {
            Query<T> q = Database.get().find(this.getModel()).order("id");

            q = handleSearch(req, q);
            q = handleFilters(req, q);

            final List<T> sets = q.asList();

            res.status(200);
            return sets;
        }, gson::toJson);
    }

    /**
     * Défini comment récupérer les données passé dans l'URL d'une requète.
     * 
     * @param req L'instance de la requète qui contient les infos HTTP.
     *
     * @return L'objet passé dans l'URL.
     */
    protected Object getDetail (Request req) throws NumberFormatException {
        return getParam(req, ":detail", (val) -> {
            return Integer.parseInt(val);
        });
    }

    /**
     * Défini la route pour récupérer les détails.
     */
    protected void detailRoute () {
        get(this.getRoute() + "/:detail", (req, res) -> {
            Object det = null;
            try {
                det = getDetail(req);
            } catch (IllegalArgumentException e) {
                return new Error("Wrong detail formatting");
            }

            T m = Database.get().find(this.getModel()).field("id").equal(det).get();

            if (m == null) {
                res.status(404);
                return new Error("Not found");
            }

            res.status(200);
            return m;
        }, gson::toJson);
    }

    /**
     * Défini la route pour créer un nouveau model dans la BDD.
     */
    protected void createRoute () {
        post(this.getRoute(), (req, res) -> {
            try {
                T creation = gson.fromJson(req.body(), this.getModel());
                Database.get().save(creation);
                res.status(201);
                return creation;
            } catch (Exception e) {
                res.status(400);
                return new Error(e.getMessage());
            }
        }, gson::toJson);
    }

    /**
     * Défini la route pour supprimer une instance du model.
     */
    protected void deleteRoute () {
        delete(this.getRoute() + "/:detail", (req, res) -> {
            Object det = null;
            det = getDetail(req);
            final Query<T> d = Database.get().find(this.getModel()).field("id").equal(det);
            if (d == null) {
                res.status(404);
                return new Error("Not found");
            }

            Database.get().delete(d);

            res.status(200);
            return new Message("deleted");
        }, gson::toJson);
    }

    public ListView () {
        // If the gson is not created exit.
        assert gson != null;

        this.viewsetRoute();
        this.detailRoute();
        this.createRoute();
        this.deleteRoute();

        after((req, res) -> {
            res.type("application/json");
        });
    }
}

