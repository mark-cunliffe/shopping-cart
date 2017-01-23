package src.main;

import java.util.Arrays;

public class ShoppingCart {
    public double getCost(Item[] items) {
        return Arrays.stream(items).map(e -> e.getPrice()).reduce(0d, (a, b) -> a + b);
    }
}
