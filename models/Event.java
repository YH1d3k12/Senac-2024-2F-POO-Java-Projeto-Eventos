package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    // Attributes
    private Integer id;
    private String name;
    private Integer organizationId;
    private Integer locationId;
    private String description;
    private Integer vacancies;
    private Date date;
    private List<Person> participants;

    // Constructor
    public Event(
            String name,
            Integer organizationId,
            Integer locationId,
            String description,
            Integer vacancies,
            Date date)
            
    {
        this.name = name;
        this.organizationId = organizationId;
        this.locationId = locationId;
        this.description = description;
        this.vacancies = vacancies;
        this.date = date;
        this.participants = new ArrayList<>();
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getVacancies() {
        return vacancies;
    }

    public Date getDate() {
        return date;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
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

    public void addParticipant(Person participant) {
        this.participants.add(participant);
    }
}
