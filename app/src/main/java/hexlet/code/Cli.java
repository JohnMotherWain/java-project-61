package hexlet.code;
import java.util.Scanner;
public class Cli {
    public static String askGreetings() {  //Сбор имени через Scanner
        Scanner getScanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String retGamerName = getScanner.nextLine();
        System.out.println("Hello, " + retGamerName + "!");
        return retGamerName;
    }
}
