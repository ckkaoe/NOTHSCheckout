package checkout;

import java.util.Map;

public interface Order {
	Map<String, OrderedItem> addItemInShoppingCart(Item item);
	long getOrderQty(String itemCode);
	double getOriginalPrice(String itemCode);
	void addItemToShop(ItemList shopItemList);
	long getItemQty(String itemCode);
	void setOrderedItemList(Map<String, OrderedItem> orderedItemList);
	Map<String, OrderedItem> getOrderedItemList();
	void setFinalAmount(double finalAmount);
	double getFinalAmount();
	double calFinalAmount();
	double getTotalDiscountRate();
	void setTotalDiscountRate(double totalDiscountRate);

}
