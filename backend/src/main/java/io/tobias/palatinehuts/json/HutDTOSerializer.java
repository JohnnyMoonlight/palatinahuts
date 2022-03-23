package io.tobias.palatinehuts.json;
import io.tobias.palatinehuts.dtos.HutDTO;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;


public class HutDTOSerializer extends StdSerializer<HutDTO> {

    protected HutDTOSerializer(Class<HutDTO> t) {
        super(t);
    }


    @Override
    public void serialize(HutDTO value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStartObject(value);
        gen.writeString("asd");
        gen.writeEndObject();
    }
}
