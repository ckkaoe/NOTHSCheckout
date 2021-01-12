package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import checkout.OrderImpl;
import checkout.Item;

class OrderTest {
	private String itemCode1 ="001";
	private double originalPrice = 9.25;

	private OrderImpl order =  new OrderImpl();	

	@Before
	public void setup() {
			
	}

	@Test
	public void getOrderQtyTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", 9.25);	
		order.addItemInShoppingCart(item);
		assertTrue(order.getOrderQty(itemCode1)==001);
	}
	
	@Test
	public void getOriginalPriceTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", originalPrice);
		order.addItemInShoppingCart(item);
		assertTrue(order.getOriginalPrice(itemCode1)==9.25);
	}
	
	
	@Test
	public void getItemQtyTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", originalPrice);
		order.addItemInShoppingCart(item);	
		assertTrue(order.getItemQty(itemCode1)==1);
	}
	
	@Test
	public void addItemInShoppingCartTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", originalPrice);	
		order.addItemInShoppingCart(item);
		assertTrue(order.getOrderedItemList().get(itemCode1).getItem().equals(item));
	}
	
	@Test
	public void calFinalAmountTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", originalPrice);
		order.addItemInShoppingCart(item);	
		order.addItemInShoppingCart(item);
		order.calFinalAmount();
		assertTrue(order.getFinalAmount()==(originalPrice*2));
	}


}
