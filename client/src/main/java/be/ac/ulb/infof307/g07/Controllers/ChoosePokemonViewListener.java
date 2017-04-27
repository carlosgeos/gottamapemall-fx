package be.ac.ulb.infof307.g07.Controllers;

import be.ac.ulb.infof307.g07.Models.Pokemon;

public interface ChoosePokemonViewListener {
    public void onConfirm(Pokemon pokemon, String date, String time);
}
