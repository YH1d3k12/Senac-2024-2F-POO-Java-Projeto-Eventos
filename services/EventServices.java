package services;

import DAO.DAO;
import models.Event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utilities.GetValues;

public class EventServices {

    // Método para listar todos os eventos
    public static List<Event> getEvents() {
        List<Event> events = new ArrayList<>();

        try {
            ResultSet sql = DAO.executeQuery("SELECT * FROM EventDetails");

            while (sql.next()) {
                Event event = new Event(
                        sql.getString("name"),
                        sql.getInt("organizer_id"),
                        sql.getInt("location_id"),
                        sql.getDate("date"),
                        sql.getTime("hour"),
                        sql.getString("description"),
                        sql.getInt("vacancies"));
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
            String query = "SELECT * FROM EventDetails WHERE id = ?";
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
                        sql.getInt("vacancies"));
                event.setId(sql.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar evento: " + e.getMessage());
        }
        return event;
    }

    // Método para criar um evento com hora e data
    public static Event createEvent(Scanner scanner) {
        String name = GetValues.getStringInput("Digite o nome do evento: ", scanner);
        String description = GetValues.getStringInput("Digite a descrição do evento: ", scanner);
        Date eventDate = GetValues.getDateInput("Digite a data do evento (Ano, Mês, Dia): ", scanner);
        String time = GetValues.getHourInput("Digite a hora do evento (HH:mm): ", scanner);

        Integer organizerId = GetValues.getIntInput("Digite o id do organizador: ", scanner);
        Integer locationId = GetValues.getIntInput("Digite o id do local: ", scanner);
        Integer vacancies = GetValues.getIntInput("Digite o número de vagas: ", scanner);

        // Adiciona os segundos como "00" para a hora
        String timeWithSeconds = time + ":00";  // Exemplo: "18:30" -> "18:30:00"
        Time eventTime = Time.valueOf(timeWithSeconds);  // Converte a string para java.sql.Time

        // Criação do evento com a data e hora separadas
        Event newEvent = new Event(name, organizerId, locationId, eventDate, eventTime, description, vacancies);

        return newEvent;
    }

    // Método para atualizar um evento
    public static Event updateEvent(int id) {
        Scanner scanner = new Scanner(System.in);
        
        // Buscar o evento atual no banco de dados usando o ID
        Event event = EventServices.getEventById(id);
        if (event == null) {
            System.out.println("Evento não encontrado.");
            return null;
        }
    
        // Solicitar os novos dados para o evento
        String name = GetValues.getStringInput("Digite o novo nome do evento (atual: " + event.getName() + "): ", scanner);
        int organizerId = GetValues.getIntInput("Digite o ID do organizador: ", scanner);
        int locationId = GetValues.getIntInput("Digite o ID do local: ", scanner);
        Date eventDate = GetValues.getDateInput("Digite a nova data do evento (atual: " + event.getDate() + "): ", scanner);
        String eventTime = GetValues.getHourInput("Digite o novo horário do evento (atual: " + event.getHour() + "): ", scanner);
        String description = GetValues.getStringInput("Digite a nova descrição do evento (atual: " + event.getDescription() + "): ", scanner);
        int vacancies = GetValues.getIntInput("Digite o novo número de vagas (atual: " + event.getVacancies() + "): ", scanner);
    
        // Adiciona os segundos como "00" para a hora
        String timeWithSeconds = eventTime + ":00";  // Exemplo: "18:30" -> "18:30:00"
        Time eventTimeUpdated = Time.valueOf(timeWithSeconds);  // Converte a string para java.sql.Time

        // Criação do evento com os novos dados
        Event updatedEvent = new Event(name, organizerId, locationId, eventDate, eventTimeUpdated, description, vacancies);
    
        // Atualização do evento no banco de dados
        boolean isUpdated = EventServices.updateEventInDatabase(updatedEvent);
    
        if (isUpdated) {
            System.out.println("Evento atualizado com sucesso!");
            return updatedEvent;
        } else {
            System.out.println("Erro ao atualizar o evento.");
            return null;
        }
    }

    // Método para deletar um evento
    public static void deleteEvent(Integer id) {
        try {
            String query = "DELETE FROM EventDetails WHERE id = ?";
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
            String query = "UPDATE EventDetails SET name = ?, organizer_id = ?, location_id = ?, date = ?, hour = ?, description = ?, vacancies = ? WHERE id = ?";
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
}
