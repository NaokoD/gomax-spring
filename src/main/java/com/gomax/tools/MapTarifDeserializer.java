package com.gomax.tools;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.gomax.entities.Tarif;

import java.io.IOException;
import java.util.*;

public class MapTarifDeserializer extends StdDeserializer<Map<Tarif, Integer>> {

    public MapTarifDeserializer(){
        this(null);
    }

    public MapTarifDeserializer(Class<Map<Tarif, Integer>> t){
        super(t);
    }

    @Override
    public Map<Tarif, Integer> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        System.out.println(node);
        Map<Tarif, Integer> tarifs = new HashMap<Tarif, Integer>();
        Iterator<JsonNode> itr = node.iterator();
        while(itr.hasNext()){
            JsonNode tarifNode=itr.next();
            Tarif tarif = new Tarif();
            tarif.setId(tarifNode.get("id").longValue());
            tarif.setLibelle(tarifNode.get("libelle").textValue());
            tarif.setMontant(tarifNode.get("montant").doubleValue());
            tarifs.put(tarif, tarifNode.get("quantite").intValue());
        }
        return tarifs;
    }
}
