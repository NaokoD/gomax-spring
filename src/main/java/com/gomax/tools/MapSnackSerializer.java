package com.gomax.tools;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gomax.entities.Snack;
import com.gomax.entities.Tarif;

import java.io.IOException;
import java.util.Map;

public class MapSnackSerializer extends StdSerializer<Map<Snack, Integer>> {
    public MapSnackSerializer() {
        this(null);
    }

    public MapSnackSerializer(Class<Map<Snack, Integer>> t) {
        super(t);
    }

    @Override
    public void serialize(Map<Snack, Integer> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        for(Map.Entry<Snack, Integer> entry : value.entrySet()){
            gen.writeStartObject();
            gen.writeNumberField("id", entry.getKey().getId());
            gen.writeStringField("name", entry.getKey().getLibelle());
            gen.writeNumberField("price", entry.getKey().getPrix());
            gen.writeNumberField("qte", entry.getValue());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
