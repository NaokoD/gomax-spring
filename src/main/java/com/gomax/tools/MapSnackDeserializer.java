package com.gomax.tools;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.gomax.entities.Snack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapSnackDeserializer extends StdDeserializer<Map<Snack, Integer>> {

    public MapSnackDeserializer() {
        this(null);
    }

    public MapSnackDeserializer(Class<Map<Snack, Integer>> t) {
        super(t);
    }

    @Override
    public Map<Snack, Integer> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println(p);
        JsonNode node = p.getCodec().readTree(p);
        System.out.println(node);
        Map<Snack, Integer> snacks = new HashMap<Snack, Integer>();
        Iterator<JsonNode> itr = node.iterator();
        while(itr.hasNext()){
            JsonNode snackNode=itr.next();
            System.out.println(snackNode.toString());
            Snack snack = new Snack();
            snack.setId(snackNode.get("id").longValue());
            snack.setLibelle(snackNode.get("name").textValue());
            snack.setPrix(snackNode.get("price").doubleValue());
            snack.setImage(snackNode.get("image").textValue());
            snacks.put(snack, snackNode.get("qte").intValue());
        }
        return snacks;
    }
}
