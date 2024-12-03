package models;

import java.util.List;
import java.util.ArrayList; // Para inicializar a lista de eventos
import java.util.Scanner;

public class Location {
    private Integer id;
    private String description;
    private Integer vacancies;
    private List<Event> events; // Lista de eventos

    // Construtor
    public Location(String description, Integer vacancies) {
        this.description = description;
        this.vacancies = vacancies;
        this.events = new ArrayList<>(); // Inicializa a lista de eventos
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getVacancies() {
        return this.vacancies;
    }

    public List<Event> getEvents() {
        return this.events;
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

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public String toString() {
        return (
            "Descrição: " + this.description + "\n" +
            "Vagas: " + this.vacancies + "\n" +
            "Id: " + this.id
        );
    }

    // Exibe os eventos associados a esse local
    public void showEvents() {
        for (Event event : this.events) {
            System.out.println(event); // Assumindo que Event tenha um método toString() adequado
        }
    }

    public static Location createLocation(Scanner scanner) {
        String description = utilities.GetValues.getStringInput("Digite a descrição: ", scanner);
        Integer vacancies = utilities.GetValues.getIntInput("Digite o número de vagas: ", scanner);
        return new Location(description, vacancies);
    }
}
