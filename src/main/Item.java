package src.main;

public enum Item {
    APPLE(0.60, 2), ORANGE(0.25, 3);
    private double price;
    private int discountQuantity;
    Item(double price, int discountQuantity) {
        this.price=price;
        this.discountQuantity = discountQuantity;
    }
    public double getPrice(){
        return price;
    }
    public int getDiscountQuantity(){
        return discountQuantity;
    }
}
