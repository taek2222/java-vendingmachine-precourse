package vendingmachine.domain;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;
    private int inputAmount;

    public VendingMachine(List<Product> products, int inputAmount) {
        this.products = products;
        this.inputAmount = inputAmount;
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
                .orElseThrow(() -> new IllegalArgumentException());
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
