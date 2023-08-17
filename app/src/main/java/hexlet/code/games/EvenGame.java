package hexlet.code.games;

import hexlet.code.Game;

import static hexlet.code.Utils.generateRND;

public class EvenGame implements Game { //Чет/нечет

    private static final String INTRO = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений

    public final String getIntro() {
        return INTRO;
    }

    public final String[] getNewRoundData() {
        String[] roundData = new String[2];
        int number1 = generateRND(MAX_OF_NUMBER); //Выберем случайное число
        //Пропишем пару Вопрос + ответ
        roundData[0] = String.valueOf(number1);
        roundData[1] = calcEven(number1);
        return roundData;
    }
    private static String calcEven(int number1) {
        return ((number1 % 2) == 0) ? "yes" : "no";
    }
}
