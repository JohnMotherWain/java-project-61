package hexlet.code;



public class Utils {
    public static int generateRND(int maxNumber) {  //генерирует случайное число
        return (int) (Math.random() * maxNumber);
    }
}
