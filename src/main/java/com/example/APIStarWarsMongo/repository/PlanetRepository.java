package com.example.APIStarWarsMongo.repository;

import com.example.APIStarWarsMongo.model.PlanetDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlanetRepository extends MongoRepository<PlanetDto, Long> {
}
