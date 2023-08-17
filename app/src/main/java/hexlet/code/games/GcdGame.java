package hexlet.code.games;

import hexlet.code.Game;

import static hexlet.code.Utils.generateRND;

public class GcdGame implements Game { //Наибольший общий делитель 2-х чисел

    private static final String INTRO = "Find the greatest common divisor of given numbers.";

    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений

    public final String getIntro() {
        return INTRO;
    }

    public final String[] getNewRoundData() {
        String[] roundData = new String[2];
        //Выберем случайные числа
        int number1 = generateRND(MAX_OF_NUMBER);
        int number2 = generateRND(MAX_OF_NUMBER);
        //Пропишем пару Вопрос + ответ
        roundData[0] = number1 + " " + number2;
        roundData[1] = String.valueOf(getGCD(number1, number2));
        return roundData;
    }

    private static int getGCD(int number1, int number2) {    //по методу Евклида
        int tmpAnswer = 0;
        while (number2 != 0) {
            int tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;
            tmpAnswer = number1;
        }
        return tmpAnswer;
    }
}
