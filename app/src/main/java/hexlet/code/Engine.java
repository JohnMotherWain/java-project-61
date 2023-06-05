package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUMBER_OF_ATTEMPTS = 3; //Количество попыток проверки
    public static void processGameData(String gamerName, GameInterface game, Scanner enterFromGamer) {
        System.out.println(game.getIntro());

        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            String[] askAnswer = game.getNewAskAnswer();
            System.out.println("Question: " + askAnswer[0]);
            System.out.print("Your answer: ");
            String gamerAnswer = enterFromGamer.nextLine();
            if (gamerAnswer.equals(askAnswer[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + gamerAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + askAnswer[1] + "'" + ". \nLet's try again, " + gamerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + gamerName + "!");
    }
}
