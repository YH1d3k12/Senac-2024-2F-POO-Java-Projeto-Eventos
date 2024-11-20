package models;


public class Organizer extends Person {
    private String email;
    private Notification notifications[];

    public Organizer(
        String name,
        String email
    ) {
        super(name);
        this.email = email;
    }

    // Setters.
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotifications(Notification notifications[]) {
        this.notifications = notifications;
    }

    // Getters.
    public String getEmail() {
        return this.email;
    }

    public Notification[] getNotifications() {
        return this.notifications;
    }

    @Override
    public String toString() {
        return (
            "Nome: " + this.getName() + "\n" +
            "Email: " + this.email
        );
    }

    public Organizer createOrganizer() {
        String name = utilities.GetValues.getStringInput("Digite o nome: ", null);
        String email = utilities.GetValues.getStringInput("Digite o email: ", null);
        return new Organizer(name, email);
    }
}