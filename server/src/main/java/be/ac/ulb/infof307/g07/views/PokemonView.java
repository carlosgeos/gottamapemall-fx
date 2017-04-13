package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;

import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.lib.Database;
import be.ac.ulb.infof307.g07.lib.ListView;
import java.util.List;

public class PokemonView extends ListView<PokemonModel> {
    public PokemonView () {
        super("pokemons", PokemonModel.class);
    }
}
