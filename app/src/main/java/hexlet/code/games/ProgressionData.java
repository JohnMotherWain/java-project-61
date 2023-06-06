package hexlet.code.games;

import hexlet.code.GameInterface;

public class ProgressionData implements GameInterface { //Дополнить прогрессию
    private static final String INTRO = "What number is missing in the progression?";
    private static final int MAX_DELTA = 10;
    private static final int MIN_MEMBERS_QUANTITY = 5;
    private final int maxNumber;
    public ProgressionData(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    public String getIntro() {
        return INTRO;
    }
    public String[] getNewAskAnswer() {
        String[] askAnswer = new String[2];
        //Выберем случайное число
        int firstMember = (int) (Math.random() * maxNumber / MAX_DELTA);
        int progressionDelta = (int) (Math.random() * MAX_DELTA);
        int membersQuantity = (int) (MIN_MEMBERS_QUANTITY + Math.random() * MIN_MEMBERS_QUANTITY);
        int questMember = (int) (Math.random() * (membersQuantity - 1));
        int[] progressionArray = progressionGenerate(firstMember, progressionDelta, membersQuantity);
        //Пропишем пару Вопрос + ответ
        askAnswer[0] = questString(progressionArray, questMember);
        askAnswer[1] = String.valueOf(progressionArray[questMember]);
        return askAnswer;
    }
    public int[] progressionGenerate(int firstMember, int progressionDelta, int membersQuantity) {
        //Арифмитическая прогрессия
        int[] returnArray = new int[membersQuantity];
        for (int i = 0; i < membersQuantity; i++) {
            returnArray[i] = firstMember + progressionDelta * i;
        }
        return returnArray;
    }
    public String questString(int[] progressionArray, int questMember) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < progressionArray.length; i++) {
            if (i == questMember) {
                returnString.append(" ..");
            } else {
                returnString.append(" ").append(progressionArray[i]);
            }
        }
        return returnString.toString();
    }
}
