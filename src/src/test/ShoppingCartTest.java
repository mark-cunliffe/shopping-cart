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
    public void aMixOfApplesAndOrangesReturnsTheCorrectPrice(){
        Assert.assertThat("Given an apple, apple, orange and apple, ShoppingCart.getCost() should return 2.05", cart.getCost(new Item[]{Item.APPLE, Item.APPLE, Item.ORANGE, Item.APPLE}), is(equalTo(2.05d)));
    }
}
