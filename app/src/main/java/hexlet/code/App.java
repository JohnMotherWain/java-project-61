package hexlet.code;

import hexlet.code.data.EvenData;
import java.util.Scanner;

public class App {
    private static final int CH_GREET = 1;
    private static final int CH_EVEN = 2;
    private static final int CH_EXIT = 0;
    public static final int NUMBER_OF_ATTEMPTS = 3; //Количество попыток проверки
    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений
    private static Scanner enterFromGamer;
    private static String gamerName;
    public static void main(String[] args) {
        enterFromGamer = new Scanner(System.in);

        playGameNumber(collectGameNumber());

        enterFromGamer.close();
    }
    public static String getGamerNamer() {
        return gamerName;
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
        int gameNumber = enterFromGamer.nextInt();
        System.out.println("Your choice: " + gameNumber);
        enterFromGamer.nextLine();  //Компенсатор багов Scanner-а
        return gameNumber;
    }
    public static void playGameNumber(int gameNumber) { //Обработка номера игры
        switch (gameNumber) {
            case CH_GREET -> Cli.greetings();
            case CH_EVEN -> {
                gamerName = Cli.greetings();
                processGameData(new EvenData(MAX_OF_NUMBER));
            }
            case CH_EXIT -> { }
            default -> System.out.println("The wrong number " + gameNumber + " was selected.\nTry again.");
        }
    }
    public static void processGameData(GameInterface game) {
        System.out.println(game.getIntro());

        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            String[] askAnswer = game.getNewAskAnswer();
            System.out.println("Question: " + askAnswer[0]);

            String gamerAnswer = enterFromGamer.nextLine();
            System.out.println("Your answer: " + gamerAnswer);
            if (gamerAnswer.equals(askAnswer[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + gamerAnswer + "'" + " is wrong answer. Correct answer was "
                        + "'" + askAnswer[1] + "'" + ". Let's try again, " + getGamerNamer() + "!");
                System.out.println("=".repeat(25));
                return;
            }
        }
        System.out.println("Congratulations, " + getGamerNamer() + "!");
    }
}
