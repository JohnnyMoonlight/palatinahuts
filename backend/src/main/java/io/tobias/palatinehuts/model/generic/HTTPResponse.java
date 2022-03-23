package io.tobias.palatinehuts.model.generic;
import org.springframework.http.HttpStatus;


public class HTTPResponse {
    HttpStatus statusCode;
    String     statusmessage;


    public void setStatusmessage(String statusmessage) {
        this.statusmessage = statusmessage;
    }


    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }


    public HTTPResponse(HttpStatus statusCode, String statusmessage) {
        this.statusCode = statusCode;
        this.statusmessage = statusmessage;
    }
}
