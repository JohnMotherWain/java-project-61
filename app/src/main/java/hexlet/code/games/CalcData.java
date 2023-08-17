package hexlet.code.games;

import hexlet.code.Game;

public class CalcData implements Game { //Калькулятор

    private static final String INTRO = "What is the result of the expression?";

    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений

    public final String getIntro() {
        return INTRO;
    }

    public final String[] getNewRoundData() {
        String[] roundData = new String[2];
        //Выберем случайные числа и операцию
        int number1 = (int) (Math.random() * MAX_OF_NUMBER);
        int number2 = (int) (Math.random() * MAX_OF_NUMBER);
        String[] digitOperators = {"+", "-", "*"};
        int operandIndex = (int) (Math.random() * digitOperators.length);
        //Пропишем пару Вопрос + ответ
        roundData[0] = number1 + " " + digitOperators[operandIndex] + " " + number2;
        int intResult = operandIndex == 0 ? number1 + number2
                : operandIndex == 1 ? number1 - number2 : number1 * number2;
        roundData[1] = String.valueOf(intResult);
        return roundData;
    }
}
