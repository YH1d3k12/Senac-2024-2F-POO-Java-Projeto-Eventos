import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import models.Participant;
import models.Organizer;
import models.Location;
import models.Event;
import services.ParticipantServices;
import services.EventServices;
import services.LocationServices;
import services.OrganizerServices;
import DAO.DAO;

public class app {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int menu = 0, id = 0;
        Participant participant;
        Organizer organizer;
        Location locationToUpdate;
        Location location;
        List<Participant> participants = new ArrayList<>();
        List<Organizer> organizers = new ArrayList<>();
        List<Location> locations = LocationServices.getLocations();
        List<Event> events = new ArrayList<>();

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
                    locationToUpdate = LocationServices.updateLocation(id);
                    DAO.closeConnect();
                    if (locationToUpdate != null) {
                        System.out.println("Local atualizado com sucesso." + "\n\n" + locationToUpdate);
                    } else {
                        System.out.println("Local não encontrado ou erro na atualização.");
                    }
                    break;
                case 15:
                    id = utilities.GetValues.getIntInput("Digite o id do local de evento: ", scanner);
                    LocationServices.deleteLocation(id);
                    DAO.closeConnect();
                    System.out.println("Local de Evento deletado com sucesso.");
                    break;
                case 16:
                    // Listar eventos
                    events = EventServices.getEvents(); // Chama o serviço para pegar a lista de eventos
                    DAO.closeConnect(); // Fecha a conexão com o banco de dados
                    if (events != null && !events.isEmpty()) { // Verifica se a lista de eventos não está vazia
                        for (Event e : events) {
                            System.out.println(e); // Imprime cada evento encontrado
                        }
                    } else {
                        System.out.println("Nenhum evento encontrado.");
                    }
                    break;
                case 17:
                    id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                    Event event = EventServices.getEventById(id); // Método para buscar evento pelo ID
                    DAO.closeConnect();
                    if (event != null) {
                        System.out.println(event); // Exibe os detalhes do evento encontrado
                    } else {
                        System.out.println("Evento não encontrado.");
                    }
                    break;
                case 18:
                    event = EventServices.createEvent(scanner);
                    DAO.closeConnect();
                    if (event != null) {
                        System.out.println("Evento criado com sucesso: " + event);
                    } else {
                        System.out.println("Erro ao criar o evento.");
                    }
                    break;
                    case 19:
                    id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                    event = EventServices.updateEvent(id); // Chama o método updateEvent passando o id
                    DAO.closeConnect(); // Fecha a conexão com o banco de dados
                
                    if (event != null) {
                        System.out.println("Evento atualizado com sucesso: " + event); // Exibe o evento atualizado
                    } else {
                        System.out.println("Evento não encontrado ou erro na atualização.");
                    }
                    break;
                case 20:
                    id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                    EventServices.deleteEvent(id);
                    DAO.closeConnect();
                    System.out.println("Evento deletado com sucesso.");
                    break;
                case 21:
                    // Enviar notificação por telefone
                    break;
                case 22:
                    // Enviar notificação por email
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
