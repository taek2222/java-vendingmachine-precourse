package vendingmachine.view;

import static vendingmachine.global.constant.MessageConstant.NEW_LINE;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.global.validation.CommonValidator;

public class InputView {

    public String readPurchaseProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        return Console.readLine();
    }

    public int readAmountHeld() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = Console.readLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    public String readProductsInfo() {
        System.out.println(NEW_LINE.get() + "상품명과 가격, 수량을 입력해 주세요.");
        return Console.readLine();
    }

    public int readInputAmount() {
        System.out.println(NEW_LINE.get() + "상품명과 가격, 수량을 입력해 주세요.");
        String input = Console.readLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }
}
