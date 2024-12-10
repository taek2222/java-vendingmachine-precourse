package vendingmachine.domain;

import static vendingmachine.global.constant.ErrorMessage.INVALID_PRODUCT_PRICE;
import static vendingmachine.global.validation.AmountValidator.validateMultipleOfTen;

public class Product {

    private static final int MINIMUM_PRICE = 100;
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        validatorPrice(price);
        validateMultipleOfTen(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void purchaseProduct() {
        quantity--;
    }

    public boolean isNotSoldOut() {
        return quantity != 0;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public int getPrice() {
        return price;
    }

    private void validatorPrice(int price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(INVALID_PRODUCT_PRICE.get(MINIMUM_PRICE));
        }
    }
}
