package vendingmachine.global.constant;

public enum MessageConstant {
    // Output
    OUTPUT_INPUT_AMOUNT("투입 금액: %d"),
    OUTPUT_COIN_AND_QUANTITY("%d원 - %d개"),
    OUTPUT_AMOUNT_HELD("자판기가 보유한 동전"),
    OUTPUT_CHANGE("잔돈"),

    // Input
    INPUT_PURCHASE_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    INPUT_AMOUNT_HELD("자판기가 보유하고 있는 금액을 입력해 주세요."),
    INPUT_PRODUCTS_INFO("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_INPUT_AMOUNT("투입 금액을 입력해 주세요"),

    NEW_LINE(System.lineSeparator())
    ;

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public String get(Object... value) {
        return String.format(message, value);
    }
}