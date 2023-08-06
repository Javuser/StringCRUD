package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       String s;
       Scanner sc = new Scanner(System.in);
       Validator validator = new Validator();

       StringDB stringDB = new StringDB();
       Service service = new Service(stringDB);

       Parser parser = new Parser(validator);
            while (true) {
                try {
                    s = sc.nextLine();
                    if (s.equals("QUIT")) {
                        break;
                    }
                    Command command = parser.parse(s);
                    service.execute(command);
                    System.out.println(command);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

    }
}
