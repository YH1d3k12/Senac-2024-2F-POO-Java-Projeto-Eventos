package models;

import java.sql.Date;
import java.util.Scanner;
public class NotificationPhone extends Notification {
    private Integer participantId;
    private Participant participant;

    public NotificationPhone(
        String message,
        Date date,
        Integer participantId
    ) {
        super(message, date);
        this.participantId = participantId;
    }

    // Setters.
    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    // Getters.
    public Integer getParticipantId() {
        return this.participantId;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    @Override
    public String toString() {
        return (
            "Participante: " + this.participant.getName() + "\n" +
            "Telefone: " + this.participant.getPhone() + "\n" +
            "Mensagem: " + this.getMessage() + "\n" +
            "Data: " + this.getDate() + "\n"
        );
    }

    @Override
    public void sendNotification() {
        System.out.println(
            "Notificação para: " + this.participant.getName() + "\n\n" +
            "Telefone: " + this.participant.getPhone() + "\n" +
            "Mensagem: " + this.getMessage() + "\n" +
            "Data: " + this.getDate()
        );
    }
    
    public NotificationPhone createNotificationPhone(Scanner scanner) {
        String message = utilities.GetValues.getStringInput("Digite a mensagem: ", scanner);
        Date date = utilities.GetValues.getDateInput("Digite a data: ", scanner);
        Integer participantId = utilities.GetValues.getIntInput("Digite o ID do participante: ", scanner);
        return new NotificationPhone(message, date, participantId);
    }
}
