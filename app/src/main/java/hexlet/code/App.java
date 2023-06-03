package hexlet.code;

import java.util.Scanner;

public class App {
    private static final int CH_GREET = 1;
    private static final int CH_EXIT = 0;
    public static void main(String[] args) {
        playGameNumber(collectGameNumber());
    }
    public static int collectGameNumber() {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit""");
        Scanner chooseGame = new Scanner(System.in);
        int gameNumber = chooseGame.nextInt();
        System.out.println("Your choice: " + gameNumber);
        chooseGame.nextLine();  //Компенсатор багов Scanner-а
        //chooseGame.close();
        return gameNumber;
    }
    public static void playGameNumber(int gameNumber) { //Обработка номера игры
        switch (gameNumber) {
            case CH_GREET -> Cli.greetings();
            case CH_EXIT -> { }
            default -> System.out.println("The wrong number " + gameNumber + " was selected.\nTry again.");
        }
    }
}
