package models;

import java.sql.Date;

public abstract class Notification {
    protected Integer id;
    protected String message;
    protected Date date;

    public Notification(
        String message,
        Date date
    ) {
        this.message = message;
        this.date = date;
    }

    // Setters.
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getters.
    public Integer getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return (
            "Mensagem: " + this.message + "\n" +
            "Data: " + this.date
        );
    }

    public abstract void sendNotification();
}
