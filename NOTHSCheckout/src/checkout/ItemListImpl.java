package checkout;
import java.util.HashMap;
import java.util.Map;

public class ItemListImpl implements ItemList{

	Map<String, Item> itemList;
	
	public ItemListImpl() {
		itemList = new HashMap<String, Item>();
	}
	
	@Override
	public Map<String, Item> getItemList(){
		return itemList;
	}
	
	@Override
	public void add(Item item) {
		itemList.put(item.getCode(), item);
	}

	@Override
	public String getNamebyCode(String code) {
		if (itemList.get(code)!=null) {
			return (itemList.get(code).getName());
		}
		return "ItemNotFound";
	}

	@Override
	public double getPriceByCode(String code) {
		if (itemList.get(code)!=null) {
			return (itemList.get(code).getPrice());
		}
		return 0.00;
	}

	@Override
	public Boolean isItemExist(String code) {
		return (itemList.get(code)!=null);
	}
}
