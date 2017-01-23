package src.main;

public enum Item {
    APPLE(0.60), ORANGE(0.25);
    private double price;
    Item(double price) {
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
}
