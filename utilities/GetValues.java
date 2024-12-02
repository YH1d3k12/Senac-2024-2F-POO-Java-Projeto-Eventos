package utilities;

import java.sql.Date;
import java.util.Scanner;

public class GetValues {

    // Método para capturar um valor do tipo double
    public static double getDoubleInput(String text, Scanner scanner) {
        double value = 0;
        boolean valid;
        do {
            valid = false;
            System.out.println(text); // Exibe o texto para o usuário
            try {
                value = scanner.nextDouble();
                valid = true;
            } catch (Exception e) {
                System.out.println("Valor inválido!\nErro: " + e);
                scanner.next(); // Limpa o buffer do scanner
            }
        } while (!valid);
        return value;
    }

    // Método para capturar um valor do tipo int
    public static int getIntInput(String text, Scanner scanner) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(text); // Exibe o texto para o usuário
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt();
                    valid = true;
                } else {
                    System.out.println("Valor inválido! Por favor, insira um número inteiro.");
                    scanner.nextLine(); // Limpar o buffer de entrada
                }
            } catch (Exception e) {
                System.out.println("Erro ao ler o valor. Tente novamente.");
                scanner.nextLine(); // Limpar o buffer de entrada em caso de erro
            }
        }
        scanner.nextLine(); // Consumir o caractere de nova linha remanescente
        return value;
    }

    // Método para capturar uma string
    public static String getStringInput(String text, Scanner scanner) {
        String value = "";
        boolean valid;
        do {
            valid = false;
            System.out.print(text); // Exibe o texto para o usuário
            try {
                value = scanner.nextLine(); // Lê a linha completa
                valid = true;
            } catch (Exception e) {
                System.out.println("Valor inválido!\nErro: " + e);
            }
        } while (!valid);
        return value;
    }

    // Método para capturar uma data (formato: yyyy-mm-dd)
    public static Date getDateInput(String text, Scanner scanner) {
        Date value = null;
        boolean valid;
        Integer year, month, day;

        do {
            valid = false;
            System.out.print(text); // Exibe o texto para o usuário
            try {
                year = getIntInput("Ano: ", scanner); // Captura o ano
                month = getIntInput("Mês: ", scanner); // Captura o mês
                day = getIntInput("Dia: ", scanner); // Captura o dia

                // Verificação para evitar uma data inválida
                if (month < 1 || month > 12 || day < 1 || day > 31) {
                    System.out.println("Data inválida! Verifique o mês e o dia.");
                    continue;
                }

                value = Date.valueOf(year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day)); // Cria
                                                                                                                    // a
                                                                                                                    // data
                                                                                                                    // no
                                                                                                                    // formato
                                                                                                                    // yyyy-mm-dd
                valid = true;
            } catch (Exception e) {
                System.out.println("Valor inválido! Verifique se a data foi digitada corretamente.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        } while (!valid);
        return value;
    }

    // Método para capturar hora no formato HH:mm
    public static String getHourInput(String text, Scanner scanner) {
        String time = "";
        boolean valid;
        Integer hours, minutes;
    
        do {
            valid = false;
            System.out.print(text); // Exibe o texto para o usuário
            try {
                hours = getIntInput("Hora: ", scanner); // Captura a hora
                minutes = getIntInput("Minutos: ", scanner); // Captura os minutos
    
                // Verificação para evitar horas e minutos inválidos
                if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
                    System.out.println("Hora ou minutos inválidos! A hora deve estar entre 00 e 23 e os minutos entre 00 e 59.");
                    continue;
                }
    
                // Formata a hora no formato HH:mm
                time = String.format("%02d:%02d", hours, minutes);
                valid = true;
            } catch (Exception e) {
                System.out.println("Valor inválido! Verifique se a hora foi digitada corretamente.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        } while (!valid);
        return time;
    }
    
}
