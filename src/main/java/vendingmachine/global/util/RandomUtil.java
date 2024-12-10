package vendingmachine.global.util;

public class RandomUtil {

    public static int generateListIndexRandomNumber(int listSize) {
        return (int) (Math.random() * listSize);
    }
}
