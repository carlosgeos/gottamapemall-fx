package be.ac.ulb.infof307.g07.lib;

import static spark.Spark.*;
import spark.Request;
import com.google.gson.Gson;
import org.mongodb.morphia.query.Query;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.lib.CustomGson;
import be.ac.ulb.infof307.g07.lib.ParamHandler;
import be.ac.ulb.infof307.g07.lib.Message;
import be.ac.ulb.infof307.g07.lib.Database;

/**
 * Abstraction to create API endpoint for a specific model instance.
 *
 * @param <T> The model instance to create the API endpoint on.
 */
public class ListView<T> {
    static protected Gson gson = CustomGson.get();

    /**
     * Used to define the route of the API endpoint.
     */
    protected String getRoute () {
        return "";
    }

    /**
     * Used to define the model used with the endpoint.
     */
    protected Class<T> getModel () {
        return null;
    }

    /**
     * Used to define the field to search in the database.
     */
    protected String getSearchField () {
        return "name";
    }

    /**
     * Get a parameter from the request, could be from the url or a form.
     *
     * @param req The request object providing information about the HTTP request
     * @param key Key of the parameter to retrieve.
     * @return Parameter value as a String.
     */
    static protected String getParam(Request req, String key) {
        String param = "";
        try{
            param = req.params(key);
        } catch (Exception e) {
            halt(400, "Parameter not found for key: " + key);
        }

        return param;
    }

    /**
     * Get a parameter from the request and change its form.
     *
     * @param req The request object providing information about the HTTP request
     * @param key Key of the parameter to retrieve.
     * @param handler Function to modify the value of the parameter.
     * @return Parameter value parsed.
     */
    static protected Object getParam(Request req, String key, ParamHandler handler) {
        Object param = getParam(req, key);
        // Just a string but parsed as an object to be returned.

        try {
            param = handler.handle((String) param);
        } catch (Exception e) {
            halt(400, "Parameter " + param + " is not accepted.");
        }

        return param;
    }

    /**
     * Define API endpoint to get all the object saved in the database
     * under the model defined in this.getModel().
     */
    protected void viewsetRoute () {
        get(this.getRoute(), (req, res) -> {
            final List<T> sets = Database.get().find(this.getModel()).order("id").asList();

            res.status(200);
            return sets;
        }, gson::toJson);
    }

    /**
     * Define API endpoint to filter the viewset by matching with the result
     * of a certain field.
     */
    protected void searchSetRoute () {
        get(this.getRoute() + "/search/:query", (req, res) -> {
            String param = (String) getParam(req, ":query");
            return Database.get().find(this.getModel()).field(this.getSearchField()).contains(param).asList();
        }, gson::toJson);
    }

    /**
     * Define API endpoint to get a specific object saved in the database
     * under the model defined in this.getModel().
     */
    protected void detailRoute () {
        get(this.getRoute() + "/:detail", (req, res) -> {
            int detail = (int) getParam(req, ":detail", (val) -> {
                return Integer.parseInt(val);
            });

            res.status(200);
            return Database.get().find(this.getModel()).field("id").equal(detail).get();
        }, gson::toJson);
    }

    /**
     * Define API endpoint to save a new data in the model defined in this.getModel().
     */
    protected void createRoute () {
        post(this.getRoute(), (req, res) -> {
            try {
                System.out.println(req.body());
                T creation = gson.fromJson(req.body(), this.getModel());
                Database.get().save(creation);
                res.status(201);
                return creation;
            } catch (Exception e) {
                return new Message(e.getMessage());
            }
        }, gson::toJson);
    }

    /**
     * Define API endpoint to update a specific data in the model.
     */
    protected void updateRoute () {
        //update(this.getRoute() + "/:id", (req, res) -> {
        //    int id = (int) getParam(req, ":id", (val) -> {
        //        return Integer.parseInt(val);
        //    });

        //    res.status(200);
        //    T object = Database.get().find(this.getModel()).field("id").equal(id).get();
        //    object.update(req.queryMap().toMap());
        //    Database.update()
        //}, gson::toJson);
    }

    /**
     * Define API endpoint to delete a specific object in the model.
     */
    protected void deleteRoute () {
        delete(this.getRoute() + "/:id", (req, res) -> {
            int id = (int) getParam(req, ":id", (val) -> {
                return Integer.parseInt(val);
            });

            res.status(200);
            final Query<T> d = Database.get().find(this.getModel()).field("id").equal(id);
            Database.get().delete(d);

            return new Message("deleted");
        }, gson::toJson);
    }

    public ListView () {
        // If the gson is not created exit.
        assert gson != null;

        this.viewsetRoute();
        this.searchSetRoute();
        this.detailRoute();
        this.createRoute();
        this.updateRoute();
        this.deleteRoute();

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
