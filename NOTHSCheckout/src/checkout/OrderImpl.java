package checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderImpl implements Order{

	private ItemList shopItemList= new ItemListImpl();
	private List <String> shopItemCodeList  = new ArrayList<String>();
	private List <String> orderedItemCodeList = new ArrayList<String>();
	private Map<String, Long> shopItemGroup;
	private Map<String, OrderedItem> orderedItemList = new HashMap<String, OrderedItem>();
	private double finalAmount = 0.0;
	private double totalDiscountRate = 1.0;
	private final String filepath = ".//data/Item.csv";

	public OrderImpl() {
		readItemList();
	}

	@Override
	public void addItemToShop(ItemList shopItemList) {
		this.shopItemList = shopItemList;
		for (Map.Entry<String, Item> item : shopItemList.getItemList().entrySet()) {
			shopItemCodeList.add(item.getKey());
		} 
	}

	//Read Item list into the shop from csv
	private void readItemList() {
		ItemList itemList= new ItemListImpl();
		ImportItemFromCSV csv = new ImportItemFromCSV();
		itemList = csv.readFile(filepath);
		addItemToShop(itemList);
	}

	@Override
	public Map<String, OrderedItem> addItemInShoppingCart(Item item) {
		orderedItemCodeList.add(item.getCode());
		shopItemGroup = orderedItemCodeList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for (Map.Entry<String, Long> itemData : shopItemGroup.entrySet()) {
			String itemCode = itemData.getKey();
			Long qty = itemData.getValue();
			double price = shopItemList.getPriceByCode(itemCode);	
			OrderedItem orderedItem = new OrderedItem(item, qty, price, price, false);
			orderedItemList.put(itemCode, orderedItem);
		}
		return orderedItemList;
	}


	@Override
	public double calFinalAmount() {
		OrderedItem orderedItem;
		double totalAmount = 0.0;
		for (Map.Entry<String, OrderedItem> orderedItemData : orderedItemList.entrySet()) {
			orderedItem = orderedItemData.getValue();
			if (orderedItem.getIsWithDiscount()) {
				totalAmount = totalAmount + orderedItem.getOrderQty()*orderedItem.getDiscountPrice();
			}else {
				totalAmount = totalAmount + orderedItem.getOrderQty()*orderedItem.getOriginalPrice();
			}
		} 
		totalAmount = totalAmount * totalDiscountRate;
		this.setFinalAmount(totalAmount);
		return totalAmount;
	}

	@Override
	public long getOrderQty(String itemCode){
		long orderQty = 0L;
		if (orderedItemList.get(itemCode)!= null)
			orderQty = orderedItemList.get(itemCode).getOrderQty();
		return orderQty;
	}

	@Override
	public double getOriginalPrice(String itemCode){
		double originalPrice = 0.0;
		if (orderedItemList.get(itemCode)!= null)
			originalPrice = orderedItemList.get(itemCode).getOriginalPrice();
		return originalPrice;
	}

	@Override
	public long getItemQty(String itemCode) {
		return shopItemGroup.get(itemCode);
	}

	@Override
	public Map<String, OrderedItem> getOrderedItemList() {
		return orderedItemList;
	}

	@Override
	public void setOrderedItemList(Map<String, OrderedItem> orderedItemList) {
		this.orderedItemList = orderedItemList;
	}

	@Override
	public double getFinalAmount() {
		return finalAmount;
	}
	@Override
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}
	@Override
	public double getTotalDiscountRate() {
		return totalDiscountRate;
	}
	@Override
	public void setTotalDiscountRate(double totalDiscountRate) {
		this.totalDiscountRate = totalDiscountRate;
	}


}
