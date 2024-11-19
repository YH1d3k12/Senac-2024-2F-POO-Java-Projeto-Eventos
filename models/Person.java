package models;

public class Person {
    private Integer id;
    private String name;

    public Person(
        String name
    ) {
        this.name = name;
    }

    // Setters.
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters.
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return (
            "Nome: " + this.name
        );
    }
}
