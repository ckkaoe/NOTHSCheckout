package Rules;

import java.util.Map;

import checkout.Order;
import checkout.OrderedItem;

//Apply rule for total amount with discountRate for total amount higher than or equal to discountAmount
//discountRate: eg. 0.6 for 40% off
//discountAmount: eg. 60 for total amount higher than or equal to  60 dollars will have the discount rate

public class TotalDiscountPriceWithAmountRule implements PromotionRule{

	private double discountRate;
	private double discountAmount;

	//Total amount larger than discountAmount, will give an overall discountRate for the total amount
	public TotalDiscountPriceWithAmountRule(double discountAmount, double discountRate) {
		this.discountAmount = discountAmount;
		this.discountRate = discountRate;
	}

	@Override
	public Order applyRule(Order order) {
		Map<String, OrderedItem> orderedItem = order.getOrderedItemList();
		order.calFinalAmount();
		if (order.getFinalAmount()>= discountAmount) {
			order.setOrderedItemList(orderedItem);
			order.setTotalDiscountRate(discountRate);
			order.calFinalAmount();
		}else {
			order.setTotalDiscountRate(1);
		}
		return order;
	}

}
