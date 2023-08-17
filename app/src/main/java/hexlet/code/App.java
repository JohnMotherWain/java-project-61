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

    private static final int CH_EXIT = 0;

    public static void main(String[] args) {
        showMenu();
        playGameNumber(selectGame());
    }

    private static void showMenu() {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
    }
    private static int selectGame() {
        Scanner enterFromGamer = new Scanner(System.in);
        int gameNumber = enterFromGamer.nextInt();
        System.out.println("Your choice: " + gameNumber);
        enterFromGamer.nextLine();  //Компенсатор багов Scanner-а
        return gameNumber;
    }

    private static void playGameNumber(int gameNumber) { //Обработка номера игры
        if (gameNumber == CH_GREET) {
            Cli.greetings();
        } else if (gameNumber == CH_EXIT) {
            return;
        } else if (GAMES.containsKey(gameNumber)) {
            Engine.processGameData(GAMES.get(gameNumber));
        } else {
            System.out.println("The wrong number " + gameNumber + " was selected.\nTry again.");
        }
    }

}
