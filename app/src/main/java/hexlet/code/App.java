package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Map;
import java.util.Scanner;

public class App {

    private static final int CH_GREET = 1;

    private static final Map<Integer, Game> GAMES = Map.of(
            2, new EvenGame(),
            3, new CalcGame(),
            4, new GcdGame(),
            5, new ProgressionGame(),
            6, new PrimeGame()
    );

    private static final int CH_EXIT = 0;

    public static void main(String[] args) {
        showMenu();
        playGame(selectGame());
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

    private static void playGame(int gameNumber) { //Обработка номера игры
        if (gameNumber == CH_GREET) {
            Cli.askGreetings();
        } else if (GAMES.containsKey(gameNumber)) {
            Engine.processGameData(GAMES.get(gameNumber));
        } else if (gameNumber != CH_EXIT) {
            System.out.println("The wrong number " + gameNumber + " was selected.\nTry again.");
        }
    }

}
