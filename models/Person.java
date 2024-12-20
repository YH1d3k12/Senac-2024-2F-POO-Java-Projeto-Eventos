package models;

import java.util.List;
public class Person {
    private Integer id;
    private String name;
    private List<Notification> notifications;

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
    
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    // Getters.
    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }

    @Override
    public String toString() {
        return (
            "Nome: " + this.name
        );
    }
}
