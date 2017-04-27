package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.IndexOptions;

import be.ac.ulb.infof307.g07.lib.models.GenericModel;
import be.ac.ulb.infof307.g07.lib.serializers.ObjectIdSerializer;
import be.ac.ulb.infof307.g07.models.PokemonModel;

@Entity("location")
public class LocationModel implements GenericModel {
    @Id
    @ObjectIdSerializer
    private ObjectId id;
    // @Indexed(options=@IndexOptions(unique=true))
    // private int id;
    private float lat;
    private float lon;
    // @Reference
    // private PokemonModel pokemon;
    private int pokemon;

    public LocationModel () {}
}
