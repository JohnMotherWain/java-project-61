package hexlet.code.games;

import hexlet.code.Game;

import static hexlet.code.Utils.generateRND;

public class CalcGame implements Game { //Калькулятор

    private static final String INTRO = "What is the result of the expression?";

    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений

    public final String getIntro() {
        return INTRO;
    }

    public final String[] getNewRoundData() {
        String[] roundData = new String[2];
        //Выберем случайные числа и операцию
        int number1 = generateRND(MAX_OF_NUMBER);
        int number2 = generateRND(MAX_OF_NUMBER);
        String[] digitOperators = {"+", "-", "*"};
        int operandIndex = generateRND(digitOperators.length);
        //Пропишем пару Вопрос + ответ
        roundData[0] = number1 + " " + digitOperators[operandIndex] + " " + number2;
        roundData[1] = String.valueOf(calcValue(number1, number2, operandIndex));
        return roundData;
    }

    private static int calcValue(int number1, int number2, int operandIndex) {    //вычислим калькулятор
        switch (operandIndex) {
            case 0 -> {
                return number1 + number2; }
            case 1 -> {
                return number1 - number2; }
            default -> {
                return number1 * number2; }
        }
    }
}
