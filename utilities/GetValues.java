package utilities;

import java.util.Scanner;
import java.sql.Date;

public class GetValues {
    public static double getDoubleInput(String text, Scanner scanner) {
        double value = 0; boolean valid;
        do {
            valid = false;
            // Printa um texto informativo.
            System.out.println(text);
            try { 
                value = scanner.nextDouble();
                valid = true;
            }
            catch (Exception e) {
                System.out.println("Valor invalido!\nErro: " + e);
                scanner.next(); // Limpa o buffer do scanner.
            }
        } while (!valid);
        return value;
    }

    public static int getIntInput(String text, Scanner scanner) {
        int value = 0; boolean valid;
        do {
            valid = false;
            // Printa um texto informativo.
            System.out.println(text);
            try { 
                value = scanner.nextInt();  // Lê o número inteiro
                scanner.nextLine(); // Consome a nova linha gerada ao pressionar Enter
                valid = true;
            }
            catch (Exception e) {
                System.out.println("Valor inválido! Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa a linha, para continuar a leitura corretamente
            }
        } while (!valid);
        return value;
    }
    
    
    public static String getStringInput(String text, Scanner scanner) {
        String value = ""; boolean valid;
        do {
            valid = false;
            // Printa um texto informativo.
            System.out.print(text);
            try { 
                value = scanner.next();
                valid = true;
            }
            catch (Exception e) {
                System.out.println("Valor invalido!\nErro: " + e);
                scanner.next(); // Limpa o buffer do scanner.
            }
        } while (!valid);
        return value;
    }

    public static Date getDateInput(String text, Scanner scanner) {
        Date value = null; 
        boolean valid;
        Integer year, month, day;

        do {
            valid = false;
            // Printa um texto informativo.
            System.out.print(text);
            try { 
                year = getIntInput("Ano: ", scanner);
                month = getIntInput("Mês: ", scanner);
                day = getIntInput("Dia: ", scanner);
                value = Date.valueOf(year + "-" + month + "-" + day);
                valid = true;
            }
            catch (Exception e) {
                System.out.println("Valor invalido!\nErro: " + e);
                scanner.next(); // Limpa o buffer do scanner.
            }
        } while (!valid);
        return value;
    }
}