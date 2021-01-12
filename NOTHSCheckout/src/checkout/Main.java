package checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Rules.*;

public class Main {


	
	public static void main(String[] args) {
		/*
		 List<PromotionRule> rules;
		//ItemListImpl itemList = new ItemListImpl();
		  rules = new ArrayList<PromotionRule>();
	        rules.add(new BuyMoreDiscountRule("001", 2, 8.5));
	      //  rules.add(new TotalDiscountPriceWithAmountRule(15.0, 0.8));
		//itemList.init();
	
	        
	    CheckoutImpl co = new CheckoutImpl(rules);
		Item item = new Item("001", "Travel Card Holder", 9.25);
		
		co.scan(item);
		//co.scan(item);
		//co.scan("001");
		System.out.println(co.total());
		
		
		long orderQty = 3;
		long discountQty = 0;
		double originalPrice = 9.25;
		double discountPrice = 8;
		
		List <String> itemCodeList = new ArrayList<String>();
		itemCodeList.add("001");
		
		ItemList itemList = new ItemListImpl();
		itemList.add(item);		

		OrderedItem orderedItem = new OrderedItem(item, orderQty, originalPrice);
		Map<String, OrderedItem> shopList = new HashMap<String, OrderedItem>();
		shopList.put("001", orderedItem);
		
		OrderImpl order =  new OrderImpl();
		order.addItemToShop(itemList);
		order.calFinalAmount();
	
		order.calFinalAmount();
		System.out.println(order.getFinalAmount());
		*/
		
		ImportItemFromCSV csv = new ImportItemFromCSV();
		csv.readFile(".//data/Item.csv");
	}

}
