package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.global.validation.CommonValidator;

public class InputView {

    public int readAmountHeld() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = Console.readLine();

        CommonValidator.validateIsNumeric(input);
        return Integer.parseInt(input);
    }
}
