package hexlet.code;
import java.util.Scanner;
public class Cli {
    public static String Greetings() {  //Сбор имени через Scanner
        Scanner gamerName = new Scanner(System.in);
        System.out.println("May I have your name?");
        String retGamerName =  gamerName.nextLine();
        System.out.println("Hello, " + retGamerName + "!");
        gamerName.close();
        return retGamerName;
    }
}
