package services;

import models.Participant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import DAO.DAO;

public class ParticipantServices {
    
    public static List<Participant> getParticipants() {
        List<Participant> participants = new ArrayList<>();
        
        try {
            ResultSet sql = DAO.executeQuery("SELECT * FROM participante");
            
            while (sql.next()) {
                Participant participant = new Participant(
                    sql.getString("name"),
                    sql.getString("phone")
                );
                participant.setId(sql.getInt("id"));
                participants.add(participant); 
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return participants;
    }

    public static Participant getParticipantById(Integer id) {
        Participant participant = null;
        
        try {
            String query = "SELECT * FROM participante WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet sql = stmt.executeQuery();
            
            if (sql.next()) {
                participant = new Participant(
                    sql.getString("name"),
                    sql.getString("phone")
                );
                participant.setId(sql.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return participant;
    }

    public static Participant createParticipant() {
        Scanner scanner = new Scanner(System.in);
        try {
            Participant newParticipant = Participant.createParticipant(scanner);

            String query = "INSERT INTO participante (name, phone) VALUES (?, ?)";
            PreparedStatement stmt = DAO.prepareStatement(query);

            stmt.setString(1, newParticipant.getName());
            stmt.setString(2, newParticipant.getPhone());
            stmt.execute();            
            return newParticipant;
        } catch (SQLException e) {
            System.out.println("Erro ao criar o participante: " + e.getMessage());
            return null;
        }
    }

    // Update
    public static Participant updateParticipant(Integer id) {
        Scanner scanner = new Scanner(System.in);
        try {
            Participant participant = getParticipantById(id);
            if (participant == null) {
                System.out.println("Participante não encontrado.");
                scanner.close();
                return null;
            }

            String newName = utilities.GetValues.getStringInput("Digite o novo nome: ", scanner);
            participant.setName(newName);
            String newPhone = utilities.GetValues.getStringInput("Digite o novo phone: ", scanner);
            participant.setPhone(newPhone);

            String query = "UPDATE participante SET name = ?, phone = ? WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);

            stmt.setString(1, participant.getName());
            stmt.setString(2, participant.getPhone());
            stmt.setInt(3, participant.getId());
            stmt.execute();
            return participant;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o participante: " + e.getMessage());
            return null;
        }
    }

    public static void deleteParticipant(Integer id) {
        try {
            String query = "DELETE FROM participante WHERE id = ?";
            PreparedStatement stmt = DAO.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o participante: " + e.getMessage());
        }
    }
}