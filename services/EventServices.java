package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.DAO;
import models.Event;
import models.Participant;
import utilities.GetValues;

public class EventServices {

    // Método para listar todos os eventos
    public static List<Event> getEvents() {
        List<Event> events = new ArrayList<>();

        try {
            ResultSet sql = DAO.executeQuery("SELECT * FROM eventdetails");

            while (sql.next()) {
                Event event = new Event (
                    sql.getString("name"),
                    sql.getInt("organizer_id"),
                    sql.getInt("location_id"),
                    sql.getDate("date"),
                    sql.getTime("hour"),
                    sql.getString("description"),
                    sql.getInt("vacancies")
                );
                event.setId(sql.getInt("id"));
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar eventos: " + e.getMessage());
        }
        return events;
    }

    // Método para buscar um evento específico pelo id
    public static Event getEventById(Integer id) {
        Event event = null;

        try {
            String query = "SELECT * FROM eventdetails WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();

            if (sql.next()) {
                event = new Event(
                    sql.getString("name"),
                    sql.getInt("organizer_id"),
                    sql.getInt("location_id"),
                    sql.getDate("date"),
                    sql.getTime("hour"),
                    sql.getString("description"),
                    sql.getInt("vacancies")
                );
                event.setId(sql.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar evento: " + e.getMessage());
        }
        return event;
    }

    // Método para criar um evento com hora e data
    public static Event createEvent() {
        Scanner scanner = new Scanner(System.in);

        try {
            Event newEvent = Event.createEvent(scanner);
            PreparedStatement stmt = DAO.prepareStatement("INSERT INTO eventdetails (name, organizer_id, location_id, date, hour, description, vacancies) VALUES (?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, newEvent.getName());
            stmt.setInt(2, newEvent.getOrganizerId());
            stmt.setInt(3, newEvent.getLocationId());
            stmt.setDate(4, newEvent.getDate());
            stmt.setTime(5, newEvent.getHour());
            stmt.setString(6, newEvent.getDescription());
            stmt.setInt(7, newEvent.getVacancies());
            stmt.execute();
            return newEvent;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o evento: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar um evento
    public static Event updateEvent(int id) {
        Scanner scanner = new Scanner(System.in);
        try {
            Event event = EventServices.getEventById(id);
            
            if (event == null) {
                System.out.println("Evento não encontrado.");
                return null;
            }

            String newName = GetValues.getStringInput("Digite o novo nome do evento (atual: " + event.getName() + "): ", scanner);
            int newOrganizerId = GetValues.getIntInput("Digite o ID do organizador: ", scanner);
            int newLocationId = GetValues.getIntInput("Digite o ID do local: ", scanner);
            Date newEventDate = GetValues.getDateInput("Digite a nova data do evento (atual: " + event.getDate() + "): ", scanner);
            String newEventTime = GetValues.getHourInput("Digite o novo horário do evento (atual: " + event.getHour() + "): ", scanner);
            String newDescription = GetValues.getStringInput("Digite a nova descrição do evento (atual: " + event.getDescription() + "): ", scanner);
            int newVacancies = GetValues.getIntInput("Digite o novo número de vagas (atual: " + event.getVacancies() + "): ", scanner);
        
            // Adiciona os segundos como "00" para a hora
            String newTimeWithSeconds = newEventTime + ":00";  // Exemplo: "18:30" -> "18:30:00"
            Time eventTimeUpdated = Time.valueOf(newTimeWithSeconds);  // Converte a string para java.sql.Time

            String query = "UPDATE eventdetails SET name = ?, organizer_id = ?, location_id = ?, date = ?, hour = ?, description = ?, vacancies = ? WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);

            stmt.setString(1, newName);
            stmt.setInt(2, newOrganizerId);
            stmt.setInt(3, newLocationId);
            stmt.setDate(4, newEventDate);
            stmt.setTime(5, eventTimeUpdated);
            stmt.setString(6, newDescription);
            stmt.setInt(7, newVacancies);
            stmt.setInt(8, id);
            stmt.execute();
            return event;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o evento: " + e.getMessage());
            return null;
        }
    }

    // Método para deletar um evento
    public static void deleteEvent(Integer id) {
        try {
            String query = "DELETE FROM eventdetails WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o evento: " + e.getMessage());
        }
    }

    // Método de atualização no banco de dados
    public static boolean updateEventInDatabase(Event event) {
        try {
            String query = "UPDATE eventdetails SET name = ?, organizer_id = ?, location_id = ?, date = ?, hour = ?, description = ?, vacancies = ? WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setString(1, event.getName());
            stmt.setInt(2, event.getOrganizerId());
            stmt.setInt(3, event.getLocationId());
            stmt.setDate(4, event.getDate());
            stmt.setTime(5, event.getHour());
            stmt.setString(6, event.getDescription());
            stmt.setInt(7, event.getVacancies());
            stmt.setInt(8, event.getId());

            int rowsUpdated = stmt.executeUpdate();

            return rowsUpdated > 0;  // Retorna verdadeiro se algum evento foi atualizado
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o evento: " + e.getMessage());
            return false;
        }
    }

    public static void addParticipantToEvent() {
        Scanner scanner = new Scanner(System.in);
        try {
            int eventId = GetValues.getIntInput("Digite o ID do evento: ", scanner);
            Event event = EventServices.getEventById(eventId);
            if (event == null) {
                System.out.println("Evento não encontrado.");
                return;
            }

            int participantId = GetValues.getIntInput("Digite o ID do participante: ", scanner);
            Participant participant = ParticipantServices.getParticipantById(participantId);
            if (participant == null) {
                System.out.println("Participante não encontrado.");
                return;
            }

            String query = "INSERT INTO eventparticipants (event_id, participant_id) VALUES (?, ?)";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setInt(2, participantId);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar participante ao evento: " + e.getMessage());
        }
    }

    public static void removeParticipantFromEvent() {
        Scanner scanner = new Scanner(System.in);
        try {
            int eventId = GetValues.getIntInput("Digite o ID do evento: ", scanner);
            Event event = EventServices.getEventById(eventId);
            if (event == null) {
                System.out.println("Evento não encontrado.");
                return;
            }

            int participantId = GetValues.getIntInput("Digite o ID do participante: ", scanner);
            Participant participant = ParticipantServices.getParticipantById(participantId);
            if (participant == null) {
                System.out.println("Participante não encontrado.");
                return;
            }

            String query = "DELETE FROM eventparticipants WHERE event_id = ? AND participant_id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, eventId);
            stmt.setInt(2, participantId);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao remover participante do evento: " + e.getMessage());
        }
    }

    public static List<Participant> getParticipantsByEventId(Integer id) {
        List<Participant> participants = new ArrayList<>();

        try {
            Event event = EventServices.getEventById(id);
            if (event == null) {
                System.out.println("Evento não encontrado.");
                return participants;
            }

            String query = "SELECT * FROM eventparticipants WHERE event_id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, event.getId());
            ResultSet sql = stmt.executeQuery();

            while (sql.next()) {
                Participant participant = ParticipantServices.getParticipantById(sql.getInt("participant_id"));
                participants.add(participant);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar participantes do evento: " + e.getMessage());
        }
        return participants;
    }
}
