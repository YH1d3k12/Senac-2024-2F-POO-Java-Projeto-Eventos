package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    // Attributes
    private Integer id;
    private String name;
    private Integer organizerId;
    private Organizer organizer;
    private Integer locationId;
    private Location location;
    private String description;
    private Integer vacancies;
    private Date date;
    private Participant participants;

    // Constructor
    public Event(
        String name,
        Integer organizerId,
        Integer locationId,
        String description,
        Integer vacancies,
        Date date
    ) {
        this.name = name;
        this.organizerId = organizerId;
        this.locationId = locationId;
        this.description = description;
        this.vacancies = vacancies;
        this.date = date;
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOrganizerId() {
        return this.organizerId;
    }

    public Organizer getOrganizer() {
        return this.organizer;
    }

    public Integer getLocationId() {
        return this.locationId;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getVacancies() {
        return this.vacancies;
    }

    public Date getDate() {
        return this.date;
    }

    public Participant[] getParticipants() {
        return this.participants;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVacancies(Integer vacancies) {
        this.vacancies = vacancies;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setParticipants(Participant participants) {
        this.participants = participants;
    }

    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }

    @Override
    public String toString() {
        return (
            "Nome: " + this.name + "\n" +
            "Organizador: " + this.organizer.getName() + "\n" +
            "Local: " + this.location.getDescription() + "\n" +
            "Descrição: " + this.description + "\n" +
            "Vagas: " + this.vacancies + "\n" +
            "Data: " + this.date
        );
    }

    public Event createEvent(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome: ", scanner);
        Integer organizerId = utilities.GetValues.getIntInput("Digite o ID do organizador: ", scanner);
        Integer locationId = utilities.GetValues.getIntInput("Digite o ID do local: ", scanner);
        String description = utilities.GetValues.getStringInput("Digite a descrição: ", scanner);
        Integer vacancies = utilities.GetValues.getIntInput("Digite o número de vagas: ", scanner);
        Date date = utilities.GetValues.getDateInput("Digite a data: ", scanner);
        return new Event(name, organizerId, locationId, description, vacancies, date);
    }
}
