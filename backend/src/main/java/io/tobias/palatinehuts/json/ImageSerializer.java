package io.tobias.palatinehuts.json;
import io.tobias.palatinehuts.model.Hut;
import io.tobias.palatinehuts.model.generic.Image;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;


public class ImageSerializer extends StdSerializer<Image> {

    protected ImageSerializer(Class<Image> t) {
        super(t);
    }


    protected ImageSerializer(JavaType type) {
        super(type);
    }


    protected ImageSerializer(Class<?> t, boolean dummy) {
        super(t, dummy);
    }


    protected ImageSerializer(StdSerializer<?> src) {
        super(src);
    }


    @Override
    public void serialize(Image value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeString(value.getPath().toString()+"asd");
        gen.writeEndObject();
    }
}
