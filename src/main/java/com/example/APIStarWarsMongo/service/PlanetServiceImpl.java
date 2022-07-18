package com.example.APIStarWarsMongo.service;

import com.example.APIStarWarsMongo.model.PlanetDto;
import com.example.APIStarWarsMongo.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public PlanetDto createPlanet(PlanetDto planet) {
        //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        //MongoDatabase db = mongoClient.getDatabase("StarWars");
        //MongoCollection<Document> collection = db.getCollection("planetDto");
        return planetRepository.save(planet);
    }

    @Override
    public List<PlanetDto> getPlanetByName() {
        List<PlanetDto> list = planetRepository.findAll();
        return list;

    }


}
