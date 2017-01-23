package src.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.main.Item;
import src.main.ShoppingCart;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setup(){
        cart = new ShoppingCart();
    }

    @Test
    public void noItemsReturnsZero(){
        Assert.assertThat("Given no items, ShoppingCart.getCost() should return 0", cart.getCost(new Item[]{}), is(equalTo(0d)));
    }
    @Test
    public void anAppleCostsSixty(){
        Assert.assertThat("Given an apple, ShoppingCart.getCost() should return 0.60", cart.getCost(new Item[]{Item.APPLE}), is(equalTo(0.6d)));
    }
    @Test
    public void anOrangeCostsTwentyFive(){
        Assert.assertThat("Given an orange, ShoppingCart.getCost() should return 0.25", cart.getCost(new Item[]{Item.ORANGE}), is(equalTo(0.25d)));
    }
    @Test
    public void buyOneAppleGetOneFree(){
        Assert.assertThat("Given 2 apples, ShoppingCart.getPrice() should return 0.60", cart.getCost(new Item[]{Item.APPLE, Item.APPLE}), is(equalTo(0.6d)));
        Assert.assertThat("Given 3 apples, ShoppingCart.getPrice() should return 1.20", cart.getCost(new Item[]{Item.APPLE, Item.APPLE, Item.APPLE}), is(equalTo(1.2d)));
        Assert.assertThat("Given 4 apples, ShoppingCart.getPrice() should return 1.20", cart.getCost(new Item[]{Item.APPLE, Item.APPLE, Item.APPLE, Item.APPLE}), is(equalTo(1.2d)));
        Assert.assertThat("Given 5 apples, ShoppingCart.getPrice() should return 1.80", cart.getCost(new Item[]{Item.APPLE, Item.APPLE, Item.APPLE, Item.APPLE, Item.APPLE}), is(equalTo(1.8d)));
    }
    @Test
    public void buyTwoOrangesGetOneFree(){
        Assert.assertThat("Given 2 oranges, ShoppingCart.getPrice() should return 0.50", cart.getCost(new Item[]{Item.ORANGE, Item.ORANGE}), is(equalTo(0.5d)));
        Assert.assertThat("Given 3 oranges, ShoppingCart.getPrice() should return 0.50", cart.getCost(new Item[]{Item.ORANGE, Item.ORANGE, Item.ORANGE}), is(equalTo(0.5d)));
        Assert.assertThat("Given 4 oranges, ShoppingCart.getPrice() should return 0.75", cart.getCost(new Item[]{Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE}), is(equalTo(0.75d)));
        Assert.assertThat("Given 5 oranges, ShoppingCart.getPrice() should return 1", cart.getCost(new Item[]{Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE}), is(equalTo(1d)));
        Assert.assertThat("Given 6 oranges, ShoppingCart.getPrice() should return 1", cart.getCost(new Item[]{Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE, Item.ORANGE}), is(equalTo(1d)));
    }
    @Test
    public void aMixOfApplesAndOrangesReturnsTheCorrectPrice(){
        Assert.assertThat("Given an apple and orange, ShoppingCart.getCost() should return 0.85", cart.getCost(new Item[]{Item.APPLE, Item.ORANGE}), is(equalTo(0.85d)));
        Assert.assertThat("Given an apple, apple, orange and apple, ShoppingCart.getCost() should return 1.45", cart.getCost(new Item[]{Item.APPLE, Item.APPLE, Item.ORANGE, Item.APPLE}), is(equalTo(1.45d)));
        Assert.assertThat("Given 3 apples and 3 oranges ShoppingCart.getCost() should return 1.7", cart.getCost(new Item[]{Item.APPLE, Item.ORANGE, Item.ORANGE, Item.APPLE, Item.ORANGE, Item.APPLE}), is(equalTo(1.7d)));
    }
}
