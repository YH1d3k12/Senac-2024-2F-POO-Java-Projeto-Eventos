package services;

import models.Organizer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DAO.DAO;

public class OrganizerServices {
    
    public static List<Organizer> getOrganizers() {
        List<Organizer> Organizers = new ArrayList<>();
        
        try {
            ResultSet sql = DAO.executeQuery("SELECT * FROM organizer");
            
            while (sql.next()) {
                Organizer Organizer = new Organizer(
                    sql.getString("name"),
                    sql.getString("email")
                );
                Organizer.setId(sql.getInt("id"));
                Organizers.add(Organizer); 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Organizers;
    }

    public static Organizer getOrganizerById(Integer id) {
        Organizer Organizer = null;
        
        try {
            String query = "SELECT * FROM organizer WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();
            
            if (sql.next()) {
                Organizer = new Organizer(
                    sql.getString("name"),
                    sql.getString("email")
                );
                Organizer.setId(sql.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Organizer;
    }

    public static Organizer createOrganizer() {
        Scanner scanner = new Scanner(System.in);
        try {
            Organizer newOrganizer = Organizer.createOrganizer(scanner);

            String query = "INSERT INTO organizer (name, email) VALUES (?, ?)";
            PreparedStatement stmt = DAO.prepareStatement(query);

            stmt.setString(1, newOrganizer.getName());
            stmt.setString(2, newOrganizer.getEmail());
            stmt.execute();            
            return newOrganizer;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o organizador: " + e.getMessage());
            return null;
        }
    }

    public static Organizer updateOrganizer(Integer id) {
        Scanner scanner = new Scanner(System.in);
        try {
            Organizer Organizer = getOrganizerById(id);
            if (Organizer == null) {
                System.out.println("Organizador não encontrado.");
                scanner.close();
                return null;
            }

            String newName = utilities.GetValues.getStringInput("Digite o novo nome: ", scanner);
            Organizer.setName(newName);
            String newEmail = utilities.GetValues.getStringInput("Digite o novo email: ", scanner);
            Organizer.setEmail(newEmail);

            String query = "UPDATE organizer SET name = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);

            stmt.setString(1, Organizer.getName());
            stmt.setString(2, Organizer.getEmail());
            stmt.setInt(3, Organizer.getId());
            stmt.execute();
            return Organizer;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o organizador: " + e.getMessage());
            return null;
        }
    }

    public static void deleteOrganizer(Integer id) {
        try {
            String query = "DELETE FROM organizer WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o organizador: " + e.getMessage());
        }
    }
}