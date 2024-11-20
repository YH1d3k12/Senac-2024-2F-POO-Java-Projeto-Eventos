package models;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private Integer id;
    private String description;
    private Integer vacancies;
    private List<Event> events;

    // Constructor
    public Location(String description, Integer vacancies) {
        this.description = description;
        this.vacancies = vacancies;
        this.events = new ArrayList<>();
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public List<Event> getEvents() {
        return events;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
}
