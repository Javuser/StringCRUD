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

        Parser parser = new Parser(validator, stringDB);
            while (true) {
                try {
                    s = sc.nextLine();
                    if (s.equals("QUIT")) {
                        break;
                    }
                    // System.out.println(s);

                    //validator.validate(s);
                    Command command = parser.parse(s);
                    System.out.println(command);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

    }
}
