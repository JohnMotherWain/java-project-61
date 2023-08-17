package hexlet.code.games;

import hexlet.code.Game;

import static hexlet.code.Utils.generateRND;

public class ProgressionGame implements Game { //Дополнить прогрессию

    private static final String INTRO = "What number is missing in the progression?";

    private static final int MAX_DELTA = 10;

    private static final int MIN_MEMBERS_QUANTITY = 6;

    private static final int FLOW_MEMBERS_QUANTITY = 4;

    private static final int MAX_OF_NUMBER = 100; //Максимальное число для рандомных значений

    public final String getIntro() {
        return INTRO;
    }

    public final String[] getNewRoundData() {
        String[] roundData = new String[2];
        //Выберем случайное число
        int firstMember = generateRND(MAX_OF_NUMBER / MAX_DELTA);
        int progressionDelta = generateRND(MAX_DELTA);
        int membersQuantity = MIN_MEMBERS_QUANTITY + generateRND(FLOW_MEMBERS_QUANTITY);
        int questMember = generateRND(membersQuantity - 1);
        int[] progressionArray = generateProgression(firstMember, progressionDelta, membersQuantity);
        //Пропишем пару Вопрос + ответ
        roundData[0] = generateQuestionString(progressionArray, questMember);
        roundData[1] = String.valueOf(progressionArray[questMember]);
        return roundData;
    }

    private static int[] generateProgression(int firstMember, int progressionDelta, int membersQuantity) {
        //Арифмитическая прогрессия
        int[] returnArray = new int[membersQuantity];
        for (int i = 0; i < membersQuantity; i++) {
            returnArray[i] = firstMember + progressionDelta * i;
        }
        return returnArray;
    }

    private static String generateQuestionString(int[] progressionArray, int questMember) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < progressionArray.length; i++) {
            if (i != 0) {
                returnString.append(" ");
            }
            if (i == questMember) {
                returnString.append("..");
            } else {
                returnString.append(progressionArray[i]);
            }

        }
        return returnString.toString();
    }
}
