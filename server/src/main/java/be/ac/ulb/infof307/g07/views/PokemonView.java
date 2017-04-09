package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import com.google.gson.Gson;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import be.ac.ulb.infof307.g07.models.PokemonModel;
import java.util.List;

public class PokemonView {
    public static void init (Datastore datastore) {
        Gson gson = new Gson();

        // path("/pokemons", () -> {
        get("/pokemons", (req, res) -> {
            Query<PokemonModel> query = datastore.find(PokemonModel.class);
            final List<PokemonModel> pokemons = query.asList();

            res.status(200);

            return pokemons;
        }, gson::toJson);

        get("/pokemons/:id", (req, res) -> {
            res.status(200);
            return datastore.get(PokemonModel.class, req.params("id"));//.toInt());
        }, gson::toJson);

        //post("/pokemons/create", (req, res) -> {
        //    String name = req.queryParams("name");
        //});

        after((req, res) -> {
            res.type("application/json");
        });

            //exception(IllegalArgumentException.class, (e, req, res) -> {
            //    res.status(400);
            //    res.body(gson::toJson(new ResponseError(e)));
            //});
        //});
    }
}
