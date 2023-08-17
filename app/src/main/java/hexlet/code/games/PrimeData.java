package hexlet.code.games;

import java.math.BigInteger;
import hexlet.code.Game;

public class PrimeData implements Game { //Простое число

    private static final String INTRO = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений

    public final String getIntro() {
        return INTRO;
    }

    public final String[] getNewRoundData() {
        String[] roundData = new String[2];
        //Выберем случайное число
        int number1 = (int) (Math.random() * MAX_OF_NUMBER);
        //Пропишем пару Вопрос + ответ
        roundData[0] = String.valueOf(number1);
        roundData[1] = (isProbablePrime(number1)) ? "yes" : "no";
        return roundData;
    }

    private static boolean isProbablePrime(Integer testNumber) {
        BigInteger bigInteger = BigInteger.valueOf(testNumber);
        return bigInteger.isProbablePrime((int) Math.log(testNumber));
    }
}
