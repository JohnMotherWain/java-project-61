package hexlet.code.games;

import hexlet.code.GameInterface;

public class CalcData implements GameInterface { //Калькулятор
    private static final String INTRO = "What is the result of the expression?";
    private final int maxNumber;
    public CalcData(int maxNumberExternal) {
        this.maxNumber = maxNumberExternal;
    }
    public final String getIntro() {
        return INTRO;
    }
    public final String[] getNewAskAnswer() {
        String[] askAnswer = new String[2];
        //Выберем случайные числа и операцию
        int number1 = (int) (Math.random() * maxNumber);
        int number2 = (int) (Math.random() * maxNumber);
        String[] digitOperators = {"+", "-", "*"};
        int operandIndex = (int) (Math.random() * digitOperators.length);
        //Пропишем пару Вопрос + ответ
        askAnswer[0] = number1 + " " + digitOperators[operandIndex] + " " + number2;
        int intResult = operandIndex == 0 ? number1 + number2
                : operandIndex == 1 ? number1 - number2 : number1 * number2;
        askAnswer[1] = String.valueOf(intResult);
        return askAnswer;
    }
}
