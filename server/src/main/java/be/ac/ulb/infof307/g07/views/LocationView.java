package be.ac.ulb.infof307.g07.views;

import static spark.Spark.*;

import org.bson.types.ObjectId;

import be.ac.ulb.infof307.g07.models.LocationModel;
import be.ac.ulb.infof307.g07.lib.Database;
import be.ac.ulb.infof307.g07.lib.ListView;
import be.ac.ulb.infof307.g07.lib.Error;

import java.util.List;

public final class LocationView extends ListView<LocationModel> {
    protected final String getRoute () {
        return "locations";
    }

    protected final Class<LocationModel> getModel () {
        return LocationModel.class;
    }

    /**
     * Do not implement update route.
     */
    @Override
    protected final void updateRoute () {}

    /**
     * Detail route use ID from the mongodb.
     */
    protected void detailRoute () {
        get(this.getRoute() + "/:detail", (req, res) -> {
            String detail = getParam(req, ":detail");

            if (!ObjectId.isValid(detail)) {
                return new Error("Not found");
            }

            ObjectId oid = new ObjectId(detail);

            LocationModel m = Database.get().find(this.getModel()).field("id").equal(oid).get();

            if (m == null) {
                return new Error("Not found");
            }

            res.status(200);
            return m;
        }, gson::toJson);
    }



    public LocationView () {
        super();
    }
}
