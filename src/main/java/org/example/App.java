package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String line;
        try ( PersonDAO personDAO = new PersonDAO()){
            Scanner sc = new Scanner(System.in);
            Validator validator = new Validator();
            Service service = new Service(personDAO);
            Parser parser = new Parser(validator);
            while (true) {
                try {
                    line = sc.nextLine();
                    if (line.equals("QUIT")) {
                        break;
                    }
                    Command command = parser.parse(line);
                    service.execute(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
