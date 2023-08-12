package hexlet.code;

import hexlet.code.games.EvenData;
import hexlet.code.games.CalcData;
import hexlet.code.games.GcdData;
import hexlet.code.games.ProgressionData;
import hexlet.code.games.PrimeData;

import java.util.Map;
import java.util.Scanner;

public class App {
    private static final int CH_GREET = 1;
    private static final Map<Integer, Game> GAMES = Map.of(
            2, new EvenData(),
            3, new CalcData(),
            4, new GcdData(),
            5, new ProgressionData(),
            6, new PrimeData()
    );
    //private static final int CH_LAST = 6;
    private static final int CH_EXIT = 0;
    public static void main(String[] args) {
        playGameNumber(collectGameNumber());
    }
    private static int collectGameNumber() {
        Scanner enterFromGamer = new Scanner(System.in);
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
        if (gameNumber < CH_EXIT || gameNumber > (GAMES.size() + 1)) {
            System.out.println("The wrong number " + gameNumber + " was selected.\nTry again.");
            return;
        }

        switch (gameNumber) {
            case CH_GREET -> Cli.greetings();
            case CH_EXIT -> { }
            default -> Engine.processGameData(GAMES.get(gameNumber));
        }
    }
}
