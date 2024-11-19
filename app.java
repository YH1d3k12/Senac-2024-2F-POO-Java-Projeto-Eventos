import java.sql.DriverManager;
import java.util.Scanner;

import DAO.DAO;

public class app {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int menu = 0;
        do {
            System.out.println("1. Opção");
            menu = utilities.GetValues.getIntInput("Digite a opção desejada: ", scanner);

            switch (menu) {
                case 1:
                    // students = StudentDAO.getStudents(con);
                    DAO.closeConnect();
                    // for (Student student : students) {
                    //     System.out.println(student);
                    // }
                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (menu != 0);
    }
}
