package models;

import java.sql.Date;
import java.sql.Time;

public class Event {
    private int id;
    private String name;
    private int organizerId;
    private int locationId;
    private Date date; // Para armazenar a data
    private Time hour; // Para armazenar a hora
    private String description;
    private int vacancies;

    // Construtor com todos os parâmetros
    public Event(String name, int organizerId, int locationId, Date date, Time hour, String description, int vacancies) {
        this.name = name;
        this.organizerId = organizerId;
        this.locationId = locationId;
        this.date = date;
        this.hour = hour;
        this.description = description;
        this.vacancies = vacancies;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    // Método para exibir o evento de forma legível
    @Override
    public String toString() {
        return "\n\nId: " + id + "\nEvento: " + name + "\nData: " + date + "\nHora: " + hour + "\nDescrição: " + description + "\nVagas: " + vacancies + "\n\n";
    }
}