package vendingmachine.domain;

import static vendingmachine.global.constant.ErrorMessage.NOT_FOUND_PRODUCT;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;
    private int inputAmount;

    public VendingMachine(List<Product> products, int inputAmount) {
        this.products = products;
        this.inputAmount = inputAmount;
    }

    public void purchaseProduct(Product product) {
        inputAmount -= product.getPrice();
        product.purchaseProduct();
    }

    public boolean isPossiblePurchase() {
        return getMinimumPrice() < inputAmount && !isSoldOut();
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public Product findProductByName(String name) {
        return products.stream()
                .filter(product -> product.isSameName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_PRODUCT.get()));
    }

    private boolean isSoldOut() {
        int count = (int) products.stream()
                .filter(Product::isNotSoldOut)
                .count();
        return count == 0;
    }

    private int getMinimumPrice() {
        return products.stream()
                .map(Product::getPrice)
                .min(Integer::compare)
                .get();
    }
}
