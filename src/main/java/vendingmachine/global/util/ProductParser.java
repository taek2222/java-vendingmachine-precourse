package vendingmachine.global.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.domain.Product;

public class ProductParser {

    public static List<Product> parseProducts(String input) {
        List<Product> products = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\[([가-힣]*),(\\d+),(\\d+)]$");

        String[] split = input.split(";");
        for (String s : split) {
            Matcher matcher = pattern.matcher(s);

            if (!matcher.find())
                throw new IllegalArgumentException();

            String name = matcher.group(1);
            int price = Integer.parseInt(matcher.group(2));
            int quantity = Integer.parseInt(matcher.group(3));

            Product product = new Product(name, price, quantity);
            products.add(product);
        }
        return products;
    }
}
