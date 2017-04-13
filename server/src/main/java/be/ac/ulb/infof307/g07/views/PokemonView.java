package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;
import com.google.gson.Gson;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.lib.Database;
import java.util.List;

public class PokemonView {
    public static void init () {
        Gson gson = new Gson();

        // path("/pokemons", () -> {
        get("/pokemons", (req, res) -> {
            Query<PokemonModel> query = Database.get().find(PokemonModel.class);
            final List<PokemonModel> pokemons = query.asList();

            res.status(200);

            return pokemons;
        }, gson::toJson);

        get("/pokemons/:id", (req, res) -> {
            res.status(200);
            int id = 0;
            try {
                id = Integer.parseInt(req.params("id"));
            } catch (Exception e) {
                return e;
            }
            return Database.get().find(PokemonModel.class).field("id").equal(id).get();
        }, gson::toJson);

        post("/pokemons", (req, res) -> {
            int id = req.queryMap("id").integerValue();
            String name = req.queryMap("name").value();
            final PokemonModel pokemon = new PokemonModel(id, name);
            Database.get().save(pokemon);
            res.status(201);
            return pokemon;
        }, gson::toJson);

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
