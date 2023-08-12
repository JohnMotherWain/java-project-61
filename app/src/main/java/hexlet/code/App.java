package hexlet.code;

import hexlet.code.games.EvenData;
import hexlet.code.games.CalcData;
import hexlet.code.games.GcdData;
import hexlet.code.games.ProgressionData;
import hexlet.code.games.PrimeData;
import java.util.Scanner;

public class App {
    private static final int CH_GREET = 1;
    private static final int CH_EVEN = 2;
    private static final int CH_CALC = 3;
    private static final int CH_GCD = 4;
    private static final int CH_PROGRESSION = 5;
    private static final int CH_PRIME = 6;
    private static final int CH_EXIT = 0;
    private static Scanner enterFromGamer;
    public static void main(String[] args) {
        enterFromGamer = new Scanner(System.in);

        playGameNumber(collectGameNumber());
    }
    private static int collectGameNumber() {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
        int gameNumber = enterFromGamer.nextInt();
        System.out.println("Your choice: " + gameNumber);
        enterFromGamer.nextLine();  //Компенсатор багов Scanner-а
        return gameNumber;
    }
    private static void playGameNumber(int gameNumber) { //Обработка номера игры
        switch (gameNumber) {
            case CH_GREET -> Cli.greetings(enterFromGamer);
            case CH_EVEN -> Engine.processGameData(Cli.greetings(enterFromGamer),
                    new EvenData(), enterFromGamer);
            case CH_CALC -> Engine.processGameData(Cli.greetings(enterFromGamer),
                    new CalcData(), enterFromGamer);
            case CH_GCD -> Engine.processGameData(Cli.greetings(enterFromGamer),
                    new GcdData(), enterFromGamer);
            case CH_PROGRESSION -> Engine.processGameData(Cli.greetings(enterFromGamer),
                    new ProgressionData(), enterFromGamer);
            case CH_PRIME -> Engine.processGameData(Cli.greetings(enterFromGamer),
                    new PrimeData(), enterFromGamer);
            case CH_EXIT -> { }
            default -> System.out.println("The wrong number " + gameNumber + " was selected.\nTry again.");
        }
    }
}
