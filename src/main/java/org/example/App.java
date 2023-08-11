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
       Loader loader = new Loader();
       Scanner sc = new Scanner(System.in);
       Validator validator = new Validator();


       StringDB stringDB = new StringDB(loader.loadFromFile());
       Service service = new Service(stringDB);

       Parser parser = new Parser(validator);
            while (true) {
                try {
                    s = sc.nextLine();//CREATE some string
                    if (s.equals("QUIT")) {
                        loader.saveToFile(service.getHashMap());
                        break;
                    }
                    Command command = parser.parse(s);
                    service.execute(command);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

    }
}
