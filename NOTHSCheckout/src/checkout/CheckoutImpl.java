package checkout;
import java.util.ArrayList;
import java.util.List;

import Rules.PromotionRule;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckoutImpl implements Checkout{
	private List<PromotionRule> ruleList = new ArrayList<PromotionRule>();
	private Order order = new OrderImpl();
	private List <String> itemCodeList = new ArrayList<String>();
	 private final static Logger LOG = Logger.getLogger(CheckoutImpl.class.getName());
	
	public CheckoutImpl(List<PromotionRule> ruleList) {
		this.ruleList = ruleList;	
	}
	
	public CheckoutImpl() {

	}
	
	
	@Override
	public void scan(Item item){
		LOG.log(Level.INFO, "Scan Item with code: {0}", item.getCode());
		itemCodeList.add(item.getCode());
		order.addItemInShoppingCart(item);
	}
 
	@Override
	public double total() {
		for (PromotionRule rule: ruleList) {
			LOG.log(Level.INFO, "Apply rule: {0}", rule.getClass());
			order = rule.applyRule(order);
		}
		order.calFinalAmount();
		return order.getFinalAmount();

	}
	
	
	
	


}
