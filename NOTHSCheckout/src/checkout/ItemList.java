package checkout;

import java.util.Map;

public interface ItemList {
	void add(Item product);
	String getNamebyCode(String code);
	double getPriceByCode(String code);
	Boolean isItemExist(String code);
	Map<String, Item> getItemList();
	
}
