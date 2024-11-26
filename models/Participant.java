package models;

public class Participant extends Person {
    private String phone;

    public Participant(
        String name,
        String phone
    ) {
        super(name);
        this.phone = phone;
    }

    // Setters.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getters.
    public String getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        return (
            "Nome: " + this.getName() + "\n" +
            "phone: " + this.phone
        );
    }

    public Participant createParticipant(Scanner scanner) {
        String name = utilities.GetValues.getStringInput("Digite o nome: ", scanner);
        String phone = utilities.GetValues.getStringInput("Digite o phone: ", scanner);
        return new Participant(name, phone);
    }
}