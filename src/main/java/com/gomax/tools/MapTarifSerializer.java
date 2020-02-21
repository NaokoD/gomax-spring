package com.gomax.tools;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gomax.entities.Tarif;

import java.io.IOException;
import java.util.Map;

public class MapTarifSerializer extends StdSerializer<Map<Tarif, Integer>> {
    public MapTarifSerializer() {
        this(null);
    }

    public MapTarifSerializer(Class<Map<Tarif, Integer>> t) {
        super(t);
    }

    @Override
    public void serialize(Map<Tarif, Integer> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        for(Map.Entry<Tarif, Integer> entry : value.entrySet()){
            gen.writeStartObject();
            gen.writeNumberField("id", entry.getKey().getId());
            gen.writeStringField("libelle", entry.getKey().getLibelle());
            gen.writeNumberField("montant", entry.getKey().getMontant());
            gen.writeNumberField("quantite", entry.getValue());
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
