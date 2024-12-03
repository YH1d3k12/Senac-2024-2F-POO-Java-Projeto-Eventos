package models;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

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

    @Override
    public String toString() {
        return "\n\nId: " + id + "\nEvento: " + name + "\nData: " + date + "\nHora: " + hour + "\nDescrição: " + description + "\nVagas: " + vacancies + "\n\n";
    }

    public static Event createEvent(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome do evento: ", scanner);
        int organizerId = utilities.GetValues.getIntInput("Digite o ID do organizador: ", scanner);
        int locationId = utilities.GetValues.getIntInput("Digite o ID do local: ", scanner);
        Date date = utilities.GetValues.getDateInput("Digite a data do evento: ", scanner);
        String hour = utilities.GetValues.getHourInput("Digite a hora do evento: ", scanner);
        String description = utilities.GetValues.getStringInput("Digite a descrição do evento: ", scanner);
        int vacancies = utilities.GetValues.getIntInput("Digite o número de vagas: ", scanner);
        String timeWithSeconds = hour + ":00";
        Time eventTime = Time.valueOf(timeWithSeconds);  // Converte a string para java.sql.Time

        return new Event(name, organizerId, locationId, date, eventTime, description, vacancies);
    }

}