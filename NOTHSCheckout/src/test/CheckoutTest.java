package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import checkout.CheckoutImpl;
import checkout.Item;


class CheckoutTest {

	private String itemCode1 = "001";
	private double itemprice1 = 9.25;	
	private String itemCode2 = "002";
	private double itemprice2 = 45;

	@Before
	public void setup() {

	}

	
	@Test
	void scanTest() {
		CheckoutImpl co = new CheckoutImpl();
		Item item = new Item(itemCode1, "Travel Card Holder", 9.25);
		co.scan(item);
		assertTrue(co.total()==9.25);
		
	}
	
	@Test
	void totalTest() {
		CheckoutImpl co = new CheckoutImpl();
		Item item1 = new Item(itemCode1, "Travel Card Holder", 9.25);
		Item item2 = new Item(itemCode2, "Personalised cufflinks", 45);
		co.scan(item1);
		co.scan(item2);
		assertTrue(co.total()==(itemprice1+itemprice2));
	}

}
