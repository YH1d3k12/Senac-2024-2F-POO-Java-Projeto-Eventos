import java.sql.DriverManager;
import java.util.Scanner;

import DAO.DAO;

public class app {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Participant> participants = new ArrayList<>();

        int menu = 0;
        do {
            System.out.println("1. Listar participantes");
            System.out.println("2. Buscar um participante");
            System.out.println("3. Criar um participante");
            System.out.println("4. Atualizar um participante");
            menu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);

            switch (menu) {
                case 1:
                    participants = ParticipantServices.getParticipants();
                    DAO.closeConnect();
                    for (Participant participant : participants) {
                        System.out.println(participant);
                    }
                    break;
                case 2:
                    Integer id = utilities.GetValues.getIntInput("Digite o id do participante: ", scanner);
                    Participant participant = ParticipantServices.getParticipantById(id);
                    DAO.closeConnect();
                    if (participant != null) {
                        System.out.println(participant);
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                case 3:
                    Participant newParticipant = ParticipantServices.createParticipant();
                    participants.add(newParticipant);
                    System.out.println("Participante criado com sucesso.");
                    break;
                case 4:
                    Integer id = utilities.GetValues.getIntInput("Digite o id do participante: ", scanner);
                    Participant participant = ParticipantServices.getParticipantById(id);
                    DAO.closeConnect();
                    if (participant != null) {
                        System.out.println(participant);
                        Participant updatedParticipant = ParticipantServices.updateParticipant(participant);
                        System.out.println("Participante atualizado com sucesso.");
                    } else {
                        System.out.println("Participante não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
    }
}
