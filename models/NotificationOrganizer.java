package models;

import java.sql.Date;

public class NotificationOrganizer extends Notification {
    private Integer organizerId;
    private Organizer organizer;

    public NotificationOrganizer(
        String message,
        Date date,
        Integer organizerId
    ) {
        super(message, date);
        this.organizerId = organizerId;
    }

    // Setters.
    public void setOrganizerId(Integer organizerId) {
        this.organizerId = organizerId;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    // Getters.
    public Integer getOrganizerId() {
        return this.organizerId;
    }

    public Organizer getOrganizer() {
        return this.organizer;
    }

    @Override
    public String toString() {
        return (
            "Mensagem: " + this.message + "\n" +
            "Data: " + this.date + "\n" +
            "Para: " + this.organizer.getEmail()
        );
    }

    @Override
    public void sendNotification() {
        System.out.println(this.toString());
    }
    
}
