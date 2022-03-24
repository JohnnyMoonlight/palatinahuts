package io.tobias.palatinehuts.dtos;
import io.tobias.palatinehuts.model.Hut;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class HttpResponse {

    String message;
    JsonElement object;
    private HttpResponse() {
        this.object = null;
    }

    public HttpResponse(String message, Object object) {
        this();
        this.message = message;
        if(object != null) {
            this.object = new Gson().toJsonTree(object);
        }
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public JsonElement getObject() {
        return object;
    }


    public void setObject(JsonElement object) {
        this.object = object;
    }


    public HttpResponse(String message) {
        this();
        this.message = message;
    }
}
