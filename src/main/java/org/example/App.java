package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String line;
        Loader loader = new Loader();
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();

        StringDB stringDB = new StringDB(loader.loadFromFile());
        Service service = new Service(stringDB);

        Parser parser = new Parser(validator);
        while (true) {
            try {
                line = sc.nextLine();
                if (line.equals("QUIT")) {
                    loader.saveToFile(service.getHashMap());
                    break;
                }
                Command command = parser.parse(line );
                service.execute(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
