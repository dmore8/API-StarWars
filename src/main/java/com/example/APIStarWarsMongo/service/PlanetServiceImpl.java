package com.example.APIStarWarsMongo.service;

import com.example.APIStarWarsMongo.model.PlanetDto;
import com.example.APIStarWarsMongo.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public PlanetDto createPlanet(PlanetDto planet) {
        return planetRepository.save(planet);
    }
}
