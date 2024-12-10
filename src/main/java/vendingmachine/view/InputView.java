package vendingmachine.view;

import static vendingmachine.global.constant.MessageConstant.INPUT_AMOUNT_HELD;
import static vendingmachine.global.constant.MessageConstant.INPUT_INPUT_AMOUNT;
import static vendingmachine.global.constant.MessageConstant.INPUT_PRODUCTS_INFO;
import static vendingmachine.global.constant.MessageConstant.INPUT_PURCHASE_PRODUCT_NAME;
import static vendingmachine.global.constant.MessageConstant.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.global.validation.CommonValidator;

public class InputView {

    public String readPurchaseProductName() {
        System.out.println(INPUT_PURCHASE_PRODUCT_NAME);
        return Console.readLine();
    }

    public int readAmountHeld() {
        System.out.println(INPUT_AMOUNT_HELD);
        String input = Console.readLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public String readProductsInfo() {
        System.out.println(NEW_LINE.get() + INPUT_PRODUCTS_INFO);
        return Console.readLine();
    }

    public int readInputAmount() {
        System.out.println(NEW_LINE.get() + INPUT_INPUT_AMOUNT);
        String input = Console.readLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }
}
