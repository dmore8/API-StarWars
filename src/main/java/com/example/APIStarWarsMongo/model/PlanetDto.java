package com.example.APIStarWarsMongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Planet")
public class PlanetDto {
    private String name;
    private String rotation_period_minutes;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private String residents_string;
    private String films_string;
    private String created;
    private String edited;
    private String url;

    public PlanetDto() {
    }

    public PlanetDto(String name, String rotation_period_minutes, String orbital_period, String diameter, String climate, String gravity, String terrain, String surface_water, String population, String residents, String films, String created, String edited, String url) {
        this.name = name;
        this.rotation_period_minutes = rotation_period_minutes;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.residents_string = residents;
        this.films_string = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }





    public void setName(String name) {
        this.name = name;
    }

    public void setRotation_period_minutes(String rotation_period_minutes) {
        this.rotation_period_minutes = rotation_period_minutes;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public void setResidents_string(String residents_string) {
        this.residents_string = residents_string;
    }

    public void setFilms_string(String films_string) {
        this.films_string = films_string;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PlanetDto{" +
                "name='" + name + '\'' +
                ", rotation_period_minutes='" + rotation_period_minutes + '\'' +
                ", orbital_period='" + orbital_period + '\'' +
                ", diameter='" + diameter + '\'' +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surface_water='" + surface_water + '\'' +
                ", population='" + population + '\'' +
                ", residents=" + residents_string +
                ", films=" + films_string +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getRotation_period_minutes() {
        return rotation_period_minutes;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public String getResidents_string() {
        return residents_string;
    }

    public String getFilms_string() {
        return films_string;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }
}