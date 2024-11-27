package models;

import java.util.Scanner;

public class Organizer extends Person {
    private String email;

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

    // Getters.
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return (
            "Id: " + this.getId() + "\n" +
            "Nome: " + this.getName() + "\n" +
            "Email: " + this.email
        );
    }

    public static Organizer createOrganizer(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome: ", scanner);
        String email = utilities.GetValues.getStringInput("Digite o email: ", scanner);
        return new Organizer(name, email);
    }
}