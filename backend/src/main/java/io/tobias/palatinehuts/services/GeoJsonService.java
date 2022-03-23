package io.tobias.palatinehuts.services;
import io.tobias.palatinehuts.model.Hut;

import com.google.gson.Gson;
import com.google.gson.JsonElement;


public class GeoJsonService {

    public JsonElement serializeHutToGeoJson(Hut hut) {
        Gson gson = new Gson();
        final JsonElement jsonElement = gson.toJsonTree(hut);
        return jsonElement;
    }

}
