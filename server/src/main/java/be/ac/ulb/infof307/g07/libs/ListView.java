package be.ac.ulb.infof307.g07.libs;

import static spark.Spark.*;
import spark.Request;
import com.google.gson.Gson;
import org.mongodb.morphia.query.Query;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
     * Define how to retrieve the data passed in the URL of the request.
     * 
     * @param req The request object providing information about the HTTP request
     * @return Detail object given in the url.
     */
    protected Object getDetail (Request req) throws Exception {
        return getParam(req, ":detail", (val) -> {
            return Integer.parseInt(val);
        });
    }

    /**
     * Define API endpoint to get a specific object saved in the database
     * under the model defined in this.getModel().
     */
    protected void detailRoute () {
        get(this.getRoute() + "/:detail", (req, res) -> {
            Object det = null;
            try {
                det = getDetail(req);
            } catch (Exception e) {
                return new Error(e.getMessage());
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
     * Define API endpoint to save a new data in the model defined in this.getModel().
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
        delete(this.getRoute() + "/:detail", (req, res) -> {
            final Query<T> d = Database.get().find(this.getModel()).field("id").equal(getDetail(req));
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
