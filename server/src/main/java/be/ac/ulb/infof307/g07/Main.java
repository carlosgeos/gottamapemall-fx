package be.ac.ulb.infof307.g07;

import be.ac.ulb.infof307.g07.lib.Database;
import be.ac.ulb.infof307.g07.views.PokemonView;

public class Main {
    public static void main(final String[] args) {
        Database.init();

        PokemonView view = new PokemonView();

        //notFound((req, res) -> {
        //    res.type("application/json");
        //    return "{\"message\":\"404 not found\"}";
        //});

        //internalServerError((req, res) -> {
        //    res.type("application/json");
        //    return "{\"message\":\"500 server error\"}";
        //});
    }
}
