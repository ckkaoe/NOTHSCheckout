package Rules;

import java.util.Map;

import checkout.Order;
import checkout.OrderedItem;

//The rule implements buy an item more than or equal to discountQty, the unit price will discount to discountUnitPrice.
public class BuyMoreDiscountRule implements PromotionRule{
	private String itemCode;
	private int discountQty;
	private double discountUnitPrice;
	private double originalUnitPrice;

	public BuyMoreDiscountRule(String itemCode, int discountQty, double discountUnitPrice) {
		this.itemCode = itemCode;
		this.discountQty = discountQty;
		this.discountUnitPrice = discountUnitPrice;
	}
	
	@Override
	public Order applyRule(Order order) {
		Map<String, OrderedItem> orderedItem = order.getOrderedItemList();
		if (orderedItem.get(itemCode)!= null) {
			if (orderedItem.get(itemCode).getOrderQty()>=discountQty) {
				orderedItem.get(itemCode).setDiscountPrice(discountUnitPrice);
				orderedItem.get(itemCode).setIsWithDiscount(true);
			}else {
				originalUnitPrice = orderedItem.get(itemCode).getOriginalPrice();
				orderedItem.get(itemCode).setDiscountPrice(originalUnitPrice);
				orderedItem.get(itemCode).setIsWithDiscount(false);
			}
		}
		order.calFinalAmount();
		return order;
			
	}
}
