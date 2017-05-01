package be.ac.ulb.infof307.g07.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("filter")
public class FilterModel {
    @Id
    private ObjectId id;
    private String query;
}
