package hexlet.code.games;

import hexlet.code.GameInterface;

public class GcdData implements GameInterface { //Наибольший общий делитель 2-х чисел
    private static final String INTRO = "Find the greatest common divisor of given numbers.";
    private final int maxNumber;
    public GcdData(int maxNumberExternal) {
        this.maxNumber = maxNumberExternal;
    }
    public final String getIntro() {
        return INTRO;
    }
    public final String[] getNewAskAnswer() {
        String[] askAnswer = new String[2];
        //Выберем случайные числа
        int number1 = (int) (Math.random() * maxNumber);
        int number2 = (int) (Math.random() * maxNumber);
        //Пропишем пару Вопрос + ответ
        askAnswer[0] = String.valueOf(number1) + " " + String.valueOf(number2);
        askAnswer[1] = String.valueOf(isGCD(number1, number2));
        return askAnswer;
    }
    private static int isGCD(int number1, int number2) {    //по методу Евклида
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
