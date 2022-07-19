package com.example.APIStarWarsMongo.repository;

import com.example.APIStarWarsMongo.model.PlanetDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository extends MongoRepository<PlanetDto, Long> {
    List<PlanetDto> findByName(String name);
}
