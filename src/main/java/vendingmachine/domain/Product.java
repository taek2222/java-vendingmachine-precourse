package vendingmachine.domain;

import static vendingmachine.global.validation.AmountValidator.validateMultipleOfTen;

public class Product {

    private final String name;
    private final int price;
    private final int quantity;

    public Product(String name, int price, int quantity) {
        validatorPrice(price);
        validateMultipleOfTen(price);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isNotSoldOut() {
        return quantity != 0;
    }

    public int getPrice() {
        return price;
    }

    private void validatorPrice(int price) {
        if (price < 100) {
            throw new IllegalArgumentException();
        }
    }
}
