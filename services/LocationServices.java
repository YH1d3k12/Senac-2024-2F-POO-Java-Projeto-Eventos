package services;

import DAO.DAO;
import models.Location;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utilities.GetValues;
import java.util.Scanner;

public class LocationServices {

    // Método para listar todos os locais de eventos
    public static List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        
        try {
            ResultSet sql = DAO.executeQuery("SELECT * FROM location");
            
            while (sql.next()) {
                Location location = new Location(
                    sql.getString("description"),
                    sql.getInt("vacancies") // O parâmetro vagas deve ser um Integer, não String
                );
                location.setId(sql.getInt("id"));
                locations.add(location);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar locais: " + e.getMessage());
        }
        return locations;
    }

    // Método para buscar um local específico pelo id
    public static Location getLocationById(Integer id) {
        Location location = null;
        
        try {
            String query = "SELECT * FROM location WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();
            
            if (sql.next()) {
                location = new Location(
                    sql.getString("description"),
                    sql.getInt("vacancies")
                );
                location.setId(sql.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar local: " + e.getMessage());
        }
        return location;
    }

    // Método para criar um novo local de evento

    public static Location createLocation(Scanner scanner) {
        try {
            String description = GetValues.getStringInput("Digite a descrição do local: ", scanner);
            Integer vacancies = GetValues.getIntInput("Digite o número de vagas: ", scanner);
    
            Location newLocation = new Location(description, vacancies);
    
            String query = "INSERT INTO location (description, vacancies) VALUES (?, ?)";
            PreparedStatement stmt = DAO.prepareStatement(query);
    
            stmt.setString(1, newLocation.getDescription());
            stmt.setInt(2, newLocation.getVacancies());
            stmt.execute();
    
            return newLocation;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o local de evento: " + e.getMessage());
            return null;
        }
    }
    

    // Método para atualizar um local de evento
    public static Location updateLocation(Integer id) {
        Location location = getLocationById(id);
        
        if (location == null) {
            System.out.println("Local de evento não encontrado.");
            return null;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            String newDescription = GetValues.getStringInput("Digite a nova descrição: ", scanner);
            Integer newVacancies = GetValues.getIntInput("Digite o novo número de vagas: ", scanner);

            location.setDescription(newDescription);
            location.setVacancies(newVacancies);

            String query = "UPDATE local_evento SET description = ?, vacancies = ? WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);

            stmt.setString(1, location.getDescription());
            stmt.setInt(2, location.getVacancies());
            stmt.setInt(3, location.getId());
            stmt.execute();

            return location;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o local de evento: " + e.getMessage());
            return null;
        }
    }

    // Método para deletar um local de evento
    public static void deleteLocation(Integer id) {
        try {
            String query = "DELETE FROM location WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o local de evento: " + e.getMessage());
        }
    }
}
