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
        int menu = 0, submenu = 0, id = 0;
        Participant participant;
        Organizer organizer;
        Location locationToUpdate;
        Location location;
        List<Participant> participants = new ArrayList<>();
        List<Participant> participantsByEvent = new ArrayList<>();
        List<Organizer> organizers = new ArrayList<>();
        List<Location> locations = LocationServices.getLocations();
        List<Event> events = new ArrayList<>();

        do {
            participant = null;
            id = 0;

            System.out.println("1. Participantes");
            System.out.println("2. Organizadores");
            System.out.println("3. Locais de Eventos");
            System.out.println("4. Eventos");
            System.out.println("5. Pessoas - Eventos");
            System.out.println("0. Sair");
            System.out.println("-----------------------------");
            menu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);

            switch (menu) {
                case 1:
                    System.out.println("1. Listar participantes");
                    System.out.println("2. Buscar um participante");
                    System.out.println("3. Criar um participante");
                    System.out.println("4. Atualizar um participante");
                    System.out.println("5. Deletar um participante");
                    System.out.println("0. Sair");
                    submenu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);
                    switch (submenu) {
                        case 1:
                            participants = ParticipantServices.getParticipants();
                            DAO.closeConnect();
                            for (Participant p : participants) {
                                System.out.println(p);
                                System.out.println("-----------------------------");
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
                        case 0:
                            System.out.println("-----------------------------");
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Operação inválida.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1. Listar organizadores");
                    System.out.println("2. Buscar um organizador");
                    System.out.println("3. Criar um organizador");
                    System.out.println("4. Atualizar um organizador");
                    System.out.println("5. Deletar um organizador");
                    System.out.println("0. Sair");
                    submenu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);
                    switch (submenu) {
                        case 1:
                            organizers = OrganizerServices.getOrganizers();
                            DAO.closeConnect();
                            for (Organizer o : organizers) {
                                System.out.println(o);
                                System.out.println("-----------------------------");
                            }
                            break;
                        case 2:
                            id = utilities.GetValues.getIntInput("Digite o id do organizador: ", scanner);
                            organizer = OrganizerServices.getOrganizerById(id);
                            DAO.closeConnect();
                            if (organizer != null) {
                                System.out.println(organizer);
                            } else {
                                System.out.println("Organizador não encontrado.");
                            }
                            break;
                        case 3:
                            organizer = OrganizerServices.createOrganizer();
                            DAO.closeConnect();
                            System.out.println("Organizador criado com sucesso.");
                            break;
                        case 4:
                            id = utilities.GetValues.getIntInput("Digite o id do organizador: ", scanner);
                            organizer = OrganizerServices.updateOrganizer(id);
                            DAO.closeConnect();
                            System.out.println("Organizador atualizado com sucesso." + "\n\n" + organizer);
                            break;
                        case 5:
                            id = utilities.GetValues.getIntInput("Digite o id do organizador: ", scanner);
                            OrganizerServices.deleteOrganizer(id);
                            DAO.closeConnect();
                            System.out.println("Organizador deletado com sucesso.");
                            break;
                        case 0:
                            System.out.println("-----------------------------");
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Operação inválida.");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1. Listar Locais de Eventos");
                    System.out.println("2. Buscar Locais de Eventos");
                    System.out.println("3. Criar Locais de Eventos");
                    System.out.println("4. Atualizar Locais de Eventos");
                    System.out.println("5. Deletar Locais de Eventos");
                    System.out.println("0. Sair");
                    submenu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);
                    switch (submenu) {
                        case 1:
                            locations = LocationServices.getLocations();
                            DAO.closeConnect();
                            for (Location l : locations) {
                                System.out.println(l);
                                System.out.println("-----------------------------");
                            }
                            break;
                        case 2:
                            id = utilities.GetValues.getIntInput("Digite o id do Local: ", scanner);
                            location = LocationServices.getLocationById(id);
                            DAO.closeConnect();
                            if (location != null) {
                                System.out.println(location);
                            } else {
                                System.out.println("Local não encontrado.");
                            }
                            break;
                        case 3:
                            LocationServices.createLocation(scanner);
                            DAO.closeConnect();
                            System.out.println("Local de Evento criado com sucesso.");
                            break;
                        case 4:
                            id = utilities.GetValues.getIntInput("Digite o id do local de evento: ", scanner);
                            locationToUpdate = LocationServices.updateLocation(id);
                            DAO.closeConnect();
                            if (locationToUpdate != null) {
                                System.out.println("Local atualizado com sucesso." + "\n\n" + locationToUpdate);
                            } else {
                                System.out.println("Local não encontrado ou erro na atualização.");
                            }
                            break;
                        case 5:
                            id = utilities.GetValues.getIntInput("Digite o id do local de evento: ", scanner);
                            LocationServices.deleteLocation(id);
                            DAO.closeConnect();
                            System.out.println("Local de Evento deletado com sucesso.");
                            break;
                        case 0:
                            System.out.println("-----------------------------");
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Operação inválida.");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1. Listar Eventos");
                    System.out.println("2. Buscar Eventos");
                    System.out.println("3. Criar Eventos");
                    System.out.println("4. Atualizar Eventos");
                    System.out.println("5. Deletar Eventos");
                    System.out.println("0. Sair");
                    submenu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);
                    switch (submenu) {

                        case 1:
                            events = EventServices.getEvents();
                            DAO.closeConnect();
                            if (events != null && !events.isEmpty()) {
                                for (Event e : events) {
                                    System.out.println(e);
                                    System.out.println("-----------------------------");
                                }
                            } else {
                                System.out.println("Nenhum evento encontrado.");
                            }
                            break;
                        case 2:
                            id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                            Event event = EventServices.getEventById(id);
                            DAO.closeConnect();
                            if (event != null) {
                                System.out.println(event);
                            } else {
                                System.out.println("Evento não encontrado.");
                            }
                            break;
                        case 3:
                            event = EventServices.createEvent();
                            DAO.closeConnect();
                            if (event != null) {
                                System.out.println("Evento criado com sucesso: " + event);
                            } else {
                                System.out.println("Erro ao criar o evento.");
                            }
                            break;
                        case 4:
                            id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                            event = EventServices.updateEvent(id);
                            DAO.closeConnect();

                            if (event != null) {
                                System.out.println("Evento atualizado com sucesso: " + event);
                            } else {
                                System.out.println("Evento não encontrado ou erro na atualização.");
                            }
                            break;
                        case 5:
                            id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                            EventServices.deleteEvent(id);
                            DAO.closeConnect();
                            System.out.println("Evento deletado com sucesso.");
                            break;
                        case 0:
                            System.out.println("-----------------------------");
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Operação inválida.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("1. Listar participantes de um evento");
                    System.out.println("2. Adicionar participante a um evento");
                    System.out.println("3. Remover participante de um evento");
                    System.out.println("0. Sair");
                    submenu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);

                    switch (submenu) {
                        case 1:
                            id = utilities.GetValues.getIntInput("Digite o id do evento: ", scanner);
                            participantsByEvent = EventServices.getParticipantsByEventId(id);
                            DAO.closeConnect();
                            if (participantsByEvent != null && !participantsByEvent.isEmpty()) {
                                for (Participant pe : participantsByEvent) {
                                    System.out.println(pe);
                                    System.out.println("-----------------------------");
                                }
                            } else {
                                System.out.println("Nenhum participante encontrado.");
                            }
                            break;
                        case 2:
                            EventServices.addParticipantToEvent();
                            DAO.closeConnect();
                            break;
                        case 3:
                            EventServices.removeParticipantFromEvent();
                            DAO.closeConnect();
                            break;
                        case 0:
                            System.out.println("-----------------------------");
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Operação inválida.");
                            break;
                    }
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
    }
}
