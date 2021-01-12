package Rules;

import checkout.Order;

public interface PromotionRule {
	Order applyRule(Order order);
}
