package models;

import java.sql.Date;
import java.util.Scanner;
public class NotificationEmail extends Notification {
    private Integer organizerId;
    private Organizer organizer;

    public NotificationEmail(
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
            "Mensagem: " + this.getMessage() + "\n" +
            "Data: " + this.getDate() + "\n" +
            "Organizador: " + this.organizer.getName()
        );
    }

    @Override
    public void sendNotification() {
        System.out.println(
            "Notificação para: " + this.organizer.getName() + "\n\n" +
            "Email: " + this.organizer.getEmail() + "\n" +
            "Mensagem: " + this.getMessage() + "\n" +
            "Data: " + this.getDate()
        );
    }

    public NotificationEmail createNotificationEmail(Scanner scanner) {
        String message = utilities.GetValues.getStringInput("Digite a mensagem: ", scanner);
        Date date = utilities.GetValues.getDateInput("Digite a data: ", scanner);
        Integer organizerId = utilities.GetValues.getIntInput("Digite o ID do organizador: ", scanner);
        return new NotificationEmail(message, date, organizerId);
    }
}
