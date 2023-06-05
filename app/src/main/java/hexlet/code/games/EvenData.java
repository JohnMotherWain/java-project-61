package hexlet.code.games;

import hexlet.code.GameInterface;

public class EvenData implements GameInterface { //Чет/нечет
    private static final String INTRO = "Answer 'yes' if number even otherwise answer 'no'.";
    private final int maxNumber;
    public EvenData(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    public String getIntro() {
        return INTRO;
    }
    public String[] getNewAskAnswer() {
        String[] askAnswer = new String[2];
        int number1 = (int) (Math.random() * maxNumber); //Выберем случайное число
        //Пропишем пару Вопрос + ответ
        askAnswer[0] = String.valueOf(number1);
        askAnswer[1] = ((number1 % 2) == 0) ? "yes" : "no";
        return askAnswer;
    }
}
