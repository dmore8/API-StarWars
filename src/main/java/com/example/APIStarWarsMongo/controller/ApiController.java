package com.example.APIStarWarsMongo.controller;

import com.example.APIStarWarsMongo.model.PlanetDto;
import com.example.APIStarWarsMongo.service.PlanetService;
import com.google.gson.*;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private static String url ="https://swapi.dev/api/people";
    @Autowired
    private PlanetService planetService;

    @GetMapping("/people")
    public ResponseEntity<String> getPeople(){
        String body = Unirest.get(url).asString().getBody();
        JsonParser parser = new JsonParser();
        JsonObject gsonO = parser.parse(body).getAsJsonObject();
        JsonArray personas = new JsonArray();
        while (true) {
            personas.addAll(gsonO.get("results").getAsJsonArray());
            if(!gsonO.get("next").isJsonNull()) {
                String url_next = gsonO.get("next").getAsString();
                body = Unirest.get(url_next).asString().getBody();
                gsonO = parser.parse(body).getAsJsonObject();
            }
            else break;
        }
        return new ResponseEntity<>(personas.toString(), HttpStatus.OK);
    }
    @GetMapping("/people/{name}")
    public ResponseEntity<String> getPerson(@PathVariable String name ) {
        String body = Unirest.get(url).asString().getBody();
        JsonParser parser = new JsonParser();
        JsonObject gsonO = parser.parse(body).getAsJsonObject();
        while (true) {
            JsonArray personas = gsonO.get("results").getAsJsonArray();
            for(JsonElement obj : personas) {
                if(obj.getAsJsonObject().get("name").getAsString().equals(name)) {
                    return new ResponseEntity<>(obj.toString(),HttpStatus.OK);
                }
            }
            if(!gsonO.get("next").isJsonNull()) {
                String url_next = gsonO.get("next").getAsString();
                body = Unirest.get(url_next).asString().getBody();
                gsonO = parser.parse(body).getAsJsonObject();
            }
            else break;
        }
        return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
    }


    @GetMapping("/planet/{name}")
    public ResponseEntity<String> getPlanet(@PathVariable String name) {
        String body = Unirest.get("https://swapi.dev/api/planets").asString().getBody();
        JsonParser parser = new JsonParser();
        JsonObject gsonO = parser.parse(body).getAsJsonObject();
        //PlanetConverter converter = Mappers.getMapper(PlanetConverter.class);
        while (true) {
            JsonArray planetas = gsonO.get("results").getAsJsonArray();
            for (JsonElement obj : planetas) {
                if (obj.getAsJsonObject().get("name").getAsString().equals(name)) {
                    PlanetDto response = new Gson().fromJson(obj.toString(),PlanetDto.class);
                    Integer rot = Integer.valueOf(obj.getAsJsonObject().get("rotation_period").getAsString());
                    response.setRotation_period_minutes(String.valueOf(rot*60));
                    this.planetService.createPlanet(response);
                    return ResponseEntity.ok().body(response.toString());
                }
            }
            if (!gsonO.get("next").isJsonNull()) {
                String url_next = gsonO.get("next").getAsString();
                body = Unirest.get(url_next).asString().getBody();
                gsonO = parser.parse(body).getAsJsonObject();
            } else break;
        }
        return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);


    }

    @GetMapping("/planet/name/{name}")
    public ResponseEntity<String> getPlanetByName(@PathVariable String name) throws Exception {
        List<PlanetDto> planetas = this.planetService.getPlanetByName();
        for (PlanetDto pla:planetas) {
            if(pla.getName().equals(name)) {
                return ResponseEntity.ok().body(pla.toString());
            }
        }
        return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
    }

}
