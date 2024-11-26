package models;

public class Location {
    private Integer id;
    private String description;
    private Integer vacancies;
    private Event events[];

    // Constructor
    public Location(
        String description,
        Integer vacancies
    ) {
        this.description = description;
        this.vacancies = vacancies;
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

    public Event[] getEvents() {
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

    public void setEvents(Event events[]) {
        this.events = events;
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public String toString() {
        return (
            "Descrição: " + this.description + "\n" +
            "Vagas: " + this.vacancies
        );
    }

    public void showEvents() {
        for (Event event : this.events) {
            System.out.println(event);
        }
    }

    public Location createLocation() {
        String description = utilities.GetValues.getStringInput("Digite a descrição: ", null);
        Integer vacancies = utilities.GetValues.getIntegerInput("Digite o número de vagas: ", null);
        return new Location(description, vacancies);
    }
}
