package com.example.APIStarWarsMongo.service;

import com.example.APIStarWarsMongo.model.PlanetDto;

import java.util.List;
import java.util.Optional;

public interface PlanetService {
    PlanetDto createPlanet(PlanetDto planet);
    List<PlanetDto> getPlanetByName(String name);
}
