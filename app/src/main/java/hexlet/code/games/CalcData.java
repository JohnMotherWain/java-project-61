package hexlet.code.games;

import hexlet.code.GameInterface;

public class CalcData implements GameInterface { //Калькулятор
    private static final String INTRO = "What is the result of the expression?";
    private final int maxNumber;
    public CalcData(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    public String getIntro() {
        return INTRO;
    }
    public String[] getNewAskAnswer() {
        String[] askAnswer = new String[2];
        //Выберем случайные числа и операцию
        int number1 = (int) (Math.random() * maxNumber);
        int number2 = (int) (Math.random() * maxNumber);
        String[] digitOperators = {"+", "-", "*"};
        int operIndx = (int) (Math.random() * digitOperators.length);
        //Пропишем пару Вопрос + ответ
        askAnswer[0] = number1 + digitOperators[operIndx] + number2;
        switch (digitOperators[operIndx]) {
            case "+" -> askAnswer[1] = String.valueOf(number1 + number2);
            case "-" -> askAnswer[1] = String.valueOf(number1 - number2);
            default -> askAnswer[1] = String.valueOf(number1 * number2);
        }
        return askAnswer;
    }
}
