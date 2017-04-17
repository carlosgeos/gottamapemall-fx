package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;

import be.ac.ulb.infof307.g07.models.PokemonModel;
import be.ac.ulb.infof307.g07.lib.Database;
import be.ac.ulb.infof307.g07.lib.ListView;
import java.util.List;

public final class PokemonView extends ListView<PokemonModel> {
    protected final String getRoute () {
        return "pokemons";
    }

    protected final Class<PokemonModel> getModel () {
        return PokemonModel.class;
    }

    /**
     * Do not implement update route.
     */
    @Override
    protected final void updateRoute () {}

    /**
     * Do not implement delete route.
     */
    @Override
    protected final void deleteRoute () {}

    public PokemonView () {
        super();
    }
}
