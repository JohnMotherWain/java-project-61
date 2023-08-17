package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUMBER_OF_ATTEMPTS = 3; //Количество попыток проверки

    public static void processGameData(Game game) {
        String gamerName = Cli.greetings();     // Сначало приветсвие
        System.out.println(game.getIntro());    // Потом Интро
        Scanner enterFromGamer = new Scanner(System.in);    // Scaner для сбора ответов
        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            String[] roundData = game.getNewRoundData();
            System.out.println("Question: " + roundData[0]);
            System.out.print("Your answer: ");
            String gamerAnswer = enterFromGamer.nextLine();
            if (gamerAnswer.equals(roundData[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + gamerAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + roundData[1] + "'" + ". \nLet's try again, " + gamerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + gamerName + "!");
    }
}
