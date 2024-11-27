import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import models.Participant;
import models.Organizer;
import services.ParticipantServices;
import services.OrganizerServices;

import DAO.DAO;

public class app {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menu = 0, id = 0;
        List<Participant> participants = new ArrayList<>();
        Participant participant;
        List<Organizer> organizers = new ArrayList<>();
        Organizer organizer;

        do {
            participant = null;
            id = 0;

            System.out.println("1. Listar participantes");
            System.out.println("2. Buscar um participante");
            System.out.println("3. Criar um participante");
            System.out.println("4. Atualizar um participante");
            System.out.println("5. Deletar um participante");
            System.out.println("---------------------------");
            System.out.println("6. Listar organizadores");
            System.out.println("7. Buscar um organizador");
            System.out.println("8. Criar um organizador");
            System.out.println("9. Atualizar um organizador");
            System.out.println("10. Deletar um organizador");
            System.out.println("---------------------------");
            System.out.println("0. Sair");
            menu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);

            switch (menu) {
                case 1:
                    participants = ParticipantServices.getParticipants();
                    DAO.closeConnect();
                    for (Participant p : participants) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    id = utilities.GetValues.getIntInput("Digite o id do participante: ", scanner);
                    participant = ParticipantServices.getParticipantById(id);
                    DAO.closeConnect();
                    if (participant != null) {
                        System.out.println(participant);
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                case 3:
                    participant = ParticipantServices.createParticipant();
                    DAO.closeConnect();
                    participants.add(participant);
                    System.out.println("Participante criado com sucesso.");
                    break;
                case 4:
                    id = utilities.GetValues.getIntInput("Digite o id do participante: ", scanner);
                    participant = ParticipantServices.updateParticipant(id);
                    DAO.closeConnect();
                    System.out.println("Participante atualizado com sucesso." + "\n\n" + participant);
                    break;
                case 5:
                    id = utilities.GetValues.getIntInput("Digite o id do participante: ", scanner);
                    ParticipantServices.deleteParticipant(id);
                    DAO.closeConnect();
                    System.out.println("Participante deletado com sucesso.");
                    break;
                case 6:
                    organizers = OrganizerServices.getOrganizers();
                    DAO.closeConnect();
                    for (Organizer o : organizers) {
                        System.out.println(o);
                    }
                    break;
                case 7:
                    id = utilities.GetValues.getIntInput("Digite o id do organizador: ", scanner);
                    organizer = OrganizerServices.getOrganizerById(id);
                    DAO.closeConnect();
                    if (organizer != null) {
                        System.out.println(organizer);
                    } else {
                        System.out.println("Organizador não encontrado.");
                    }
                    break;
                case 8:
                    organizer = OrganizerServices.createOrganizer();
                    DAO.closeConnect();
                    System.out.println("Organizador criado com sucesso.");
                    break;
                case 9:
                    id = utilities.GetValues.getIntInput("Digite o id do organizador: ", scanner);
                    organizer = OrganizerServices.updateOrganizer(id);
                    DAO.closeConnect();
                    System.out.println("Organizador atualizado com sucesso." + "\n\n" + organizer);
                    break;
                case 10:
                    id = utilities.GetValues.getIntInput("Digite o id do organizador: ", scanner);
                    OrganizerServices.deleteOrganizer(id);
                    DAO.closeConnect();
                    System.out.println("Organizador deletado com sucesso.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
    }
}
