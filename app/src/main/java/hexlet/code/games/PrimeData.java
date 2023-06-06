package hexlet.code.games;

import java.math.BigInteger;
import hexlet.code.GameInterface;

public class PrimeData implements GameInterface { //Простое число
    private static final String INTRO = "Is given number is prime? ('yes' or 'no')";
    private final int maxNumber;
    public PrimeData(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    public String getIntro() {
        return INTRO;
    }
    public String[] getNewAskAnswer() {
        String[] askAnswer = new String[2];
        //Выберем случайное число
        int number1 = (int) (Math.random() * maxNumber);
        //Пропишем пару Вопрос + ответ
        askAnswer[0] = String.valueOf(number1);
        askAnswer[1] = (isProbablePrime(number1)) ? "yes" : "no";
        return askAnswer;
    }
    private boolean isProbablePrime(Integer testNumber) {
        BigInteger bigInteger = BigInteger.valueOf(testNumber);
        return bigInteger.isProbablePrime((int) Math.log(testNumber));
    }
}