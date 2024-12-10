package vendingmachine.global.validation;

import static vendingmachine.global.constant.ErrorMessage.INVALID_NUMERIC;

public class CommonValidator {

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMERIC.get());
        }
    }
}
