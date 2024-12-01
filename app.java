import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import models.Participant;
import models.Organizer;
import models.Location;
import services.ParticipantServices;
import services.LocationServices;
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
        List<Location> locations = LocationServices.getLocations();
        Location locationToUpdate;
        Location location;

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
            System.out.println("11. Listar Locais de Eventos");
            System.out.println("12. Buscar Locais de Eventos");
            System.out.println("13. Criar Locais de Eventos");
            System.out.println("14. Atualizar Locais de Eventos");
            System.out.println("15. Deletar Locais de Eventos");
            System.out.println("---------------------------");
            System.out.println("16. Listar Eventos");
            System.out.println("17. Buscar Eventos");
            System.out.println("18. Criar Eventos");
            System.out.println("19. Atualizar Eventos");
            System.out.println("20. Deletar Eventos");
            System.out.println("---------------------------");
            System.out.println("21. Enviar notificação por telefone");
            System.out.println("22. Enviar notificação por email");
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
                case 11:
                    locations = LocationServices.getLocations(); // Chama o serviço de listagem de locais
                    DAO.closeConnect();
                    for (Location l : locations) { // Agora a iteração é feita sobre 'locations'
                        System.out.println(l); // Imprime cada local encontrado
                    }
                    break;
                case 12:
                    id = utilities.GetValues.getIntInput("Digite o id do Local: ", scanner);
                    location = LocationServices.getLocationById(id); // Corrigido para usar uma única variável Location
                    DAO.closeConnect();
                    if (location != null) { // Verifica se a localização foi encontrada
                        System.out.println(location); // Imprime a localização encontrada
                    } else {
                        System.out.println("Local não encontrado.");
                    }
                    break;
                case 13:
                    // "13. Criar Locais de Eventos"
                    LocationServices.createLocation(scanner);
                    DAO.closeConnect();
                    System.out.println("Local de Evento criado com sucesso.");
                    break;
                case 14:
                    id = utilities.GetValues.getIntInput("Digite o id do local de evento: ", scanner);
                    locationToUpdate = LocationServices.updateLocation(id); // Use um nome diferente para a
                                                                            // variável
                    DAO.closeConnect();
                    if (locationToUpdate != null) {
                        System.out.println("Local atualizado com sucesso." + "\n\n" + locationToUpdate);
                    } else {
                        System.out.println("Local não encontrado ou erro na atualização.");
                    }
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
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
