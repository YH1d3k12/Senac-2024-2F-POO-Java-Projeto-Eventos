import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import models.Participant;
import services.ParticipantServices;

import DAO.DAO;

public class app {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Participant> participants = new ArrayList<>();
        int menu = 0;
        Participant participant;
        int id;

        do {
            participant = null;
            id = 0;

            System.out.println("1. Listar participantes");
            System.out.println("2. Buscar um participante");
            System.out.println("3. Criar um participante");
            System.out.println("4. Atualizar um participante");
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
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
    }
}
