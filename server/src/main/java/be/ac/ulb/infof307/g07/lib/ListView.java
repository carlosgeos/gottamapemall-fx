package be.ac.ulb.infof307.g07.lib;

import static spark.Spark.*;
import spark.Request;
import org.mongodb.morphia.query.Query;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import be.ac.ulb.infof307.g07.lib.ParamHandler;
import be.ac.ulb.infof307.g07.lib.Message;
import be.ac.ulb.infof307.g07.lib.Database;
import be.ac.ulb.infof307.g07.lib.models.GenericModel;

public class ListView<T extends GenericModel> {
    static private Gson gson = new Gson();

    private List<String> required_fields = null;
    private List<String> fields = null;

    /**
     * Get a parameter from the request, could be from the url or a form.
     *
     * @param req The request object providing information about the HTTP request
     * @param key Key of the parameter to retrieve.
     * @return Parameter value as a String.
     */
    static private String getParam(Request req, String key) {
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
     * @return Parameter value as a String.
     */
    static private Object getParam(Request req, String key, ParamHandler handler) {
        Object param = getParam(req, key);
        // Just a string but parsed as an object to be returned.

        try{
            param = handler.handle((String) param);
        } catch (Exception e) {
            halt(400, "Parameter " + param + " is not accepted.");
        }

        return param;
    }

    public ListView (String route, Class<T> clazz) {
        get(route, (req, res) -> {
            final List<T> pokemons = Database.get().find(clazz).asList();

            res.status(200);
            return pokemons;
        }, gson::toJson);

        get(route + "/:id", (req, res) -> {
            int id = (int) getParam(req, ":id", (val) -> {
                return Integer.parseInt(val);
            });

            res.status(200);
            return Database.get().find(clazz).field("id").equal(id).get();
        }, gson::toJson);

        post(route, (req, res) -> {
            final T model = clazz.newInstance();
            try {
                model.set(req.queryMap().toMap());
            } catch (Exception e) {
                return new Message(e.getMessage());
            }
            Database.get().save(model);

            res.status(201);
            return model;
        }, gson::toJson);

        //update(route + "/:id", (req, res) -> {
        //    int id = (int) getParam(req, ":id", (val) -> {
        //        return Integer.parseInt(val);
        //    });

        //    res.status(200);
        //    T object = Database.get().find(clazz).field("id").equal(id).get();
        //    object.update(req.queryMap().toMap());
        //    Database.update()
        //}, gson::toJson);

        delete(route + "/:id", (req, res) -> {
            int id = (int) getParam(req, ":id", (val) -> {
                return Integer.parseInt(val);
            });

            res.status(200);
            final Query<T> d = Database.get().find(clazz).field("id").equal(id);
            Database.get().delete(d);

            return new Message("deleted");
        }, gson::toJson);

        after((req, res) -> {
            res.type("application/json");
        });

        //exception(IllegalArgumentException.class, (e, req, res) -> {
        //    res.status(400);
        //    res.body(gson::toJson(new ResponseError(e)));
        //});
    }
}
