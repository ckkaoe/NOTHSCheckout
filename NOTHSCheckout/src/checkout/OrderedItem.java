package checkout;

public class OrderedItem {
	private Item item;
	private long orderQty = 0;
	private double originalPrice = 0.0;
	private double discountPrice = 0.0;
	private boolean isWithDiscount= false;
	

	public OrderedItem(Item item, long orderQty, double originalPrice, double discountPrice, boolean isWithDiscount) {
		this.item = item;
		this.orderQty = orderQty;
		this.originalPrice = originalPrice;
		this.discountPrice = discountPrice;
		this.isWithDiscount = isWithDiscount;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public long getOrderQty() {
		return orderQty;
	}


	public void setOrderQty(long orderQty) {
		this.orderQty = orderQty;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}


	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}


	public double getDiscountPrice() {
		return discountPrice;
	}


	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}


	public boolean getIsWithDiscount() {
		return isWithDiscount;
	}


	public void setIsWithDiscount(boolean isWithDiscount) {
		this.isWithDiscount = isWithDiscount;
	}
	







}
