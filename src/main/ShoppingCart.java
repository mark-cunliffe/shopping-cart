package src.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {
    public double getCost(Item[] items) {
        Map<Item, Integer> totalItems = Arrays.stream(items).collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + 1));
        return totalItems.keySet().stream().map(e -> {
            int total = totalItems.get(e);
            double freeItems = Math.floor(total / e.getDiscountQuantity());
            return new BigDecimal(total * e.getPrice() - (freeItems * e.getPrice())).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }).reduce(0d, (a, b) -> a + b);
    }
}
