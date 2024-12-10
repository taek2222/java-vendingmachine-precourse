package vendingmachine.global.validation;

public class AmountValidator {

    public static void validateMultipleOfTen(int amount) { // todo : 네이밍 메모
        if (amount % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
