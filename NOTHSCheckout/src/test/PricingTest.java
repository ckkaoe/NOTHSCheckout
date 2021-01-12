package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import Rules.*;
import checkout.CheckoutImpl;
import checkout.Item;

class PricingTest {

	private List<PromotionRule> rules;
	private String itemCode1 = "001";
	private double itemprice1 = 9.25;

	
	@Before
	public void setup() {
		
	}

	@Test
	void BuyMoreDiscountRuleWithDiscountTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", itemprice1);
        rules = new ArrayList<PromotionRule>();
        rules.add(new BuyMoreDiscountRule(itemCode1, 2, 8.5));
		CheckoutImpl co = new CheckoutImpl(rules);
		co.scan(item);
		co.scan(item);
		assertTrue(co.total()==(2*8.5));
	}
	
	@Test
	void BuyMoreDiscountRuleWithoutDiscountTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", itemprice1);
        rules = new ArrayList<PromotionRule>();
        rules.add(new BuyMoreDiscountRule(itemCode1, 3, 8.5));
		CheckoutImpl co = new CheckoutImpl(rules);
		co.scan(item);
		co.scan(item);
		assertTrue(co.total()==(2*itemprice1));
		
	}
	
	@Test
	void TotalDiscountPriceRuleAboveAmountTest() {
		Item item = new Item(itemCode1, "Travel Card Holder", itemprice1);
		double discountAmount = 20.0;
		double discountRate = 0.7;
        rules = new ArrayList<PromotionRule>();
        rules.add(new TotalDiscountPriceWithAmountRule(discountAmount, discountRate));
		CheckoutImpl co = new CheckoutImpl(rules);
		co.scan(item);
		co.scan(item);
		co.scan(item);
		assertTrue(co.total()==(itemprice1+itemprice1+itemprice1)*discountRate);
		
	}
	
	@Test
	void TotalDiscountPriceRuleBelowAmountTest() {
		double discountAmount = 90.0;
		double discountRate = 0.7;
		Item item = new Item(itemCode1, "Travel Card Holder", itemprice1);
        rules = new ArrayList<PromotionRule>();
        rules.add(new TotalDiscountPriceWithAmountRule(discountAmount, discountRate));
		CheckoutImpl co = new CheckoutImpl(rules);
		co.scan(item);
		co.scan(item);
		co.scan(item);
		assertTrue(co.total()==(itemprice1+itemprice1+itemprice1));
	}
	
	@Test
	void BuyMoreDiscountRuleDiscountPriceRuleWithDiscountTest() {
		double discountAmount = 10.0;
		double discountRate = 0.7;
		Item item = new Item(itemCode1, "Travel Card Holder", itemprice1);
        rules = new ArrayList<PromotionRule>();
        rules.add(new BuyMoreDiscountRule(itemCode1, 2, 8.5));
        rules.add(new TotalDiscountPriceWithAmountRule(discountAmount, discountRate));
        
		CheckoutImpl co = new CheckoutImpl(rules);
		co.scan(item);
		co.scan(item);
		assertTrue(co.total()==(2*8.5*discountRate));
		
	}
	

}
