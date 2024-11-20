package models;

public class Participant {
    // Attributes
    private Integer personId;
    private Integer eventId;

    // Constructor
    public Participant(Integer personId, Integer eventId) {
        this.personId = personId;
        this.eventId = eventId;
    }

    // Getters
    public Integer getPersonId() {
        return personId;
    }

    public Integer getEventId() {
        return eventId;
    }

    // Setters
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
}
