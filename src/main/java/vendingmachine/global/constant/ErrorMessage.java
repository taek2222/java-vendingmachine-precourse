package vendingmachine.global.constant;

public enum ErrorMessage {
    INVALID_INPUT("유효 하지 않은 입력 입니다."),
    INVALID_NUMERIC("숫자만 입력 가능합니다."),
    INVALID_MULTIPLE("10원 단위의 금액만 입력 가능합니다."),
    NOT_FOUND_PRODUCT("입력한 물품을 찾을 수 없습니다."),
    INVALID_PRODUCT_PRICE("최소 물품 가격은 %d원 이상입니다.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String RETRY = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message + RETRY;
    }

    public String get(Object... value) {
        return PREFIX + String.format(message, value) + RETRY;
    }
}