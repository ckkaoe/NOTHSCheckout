package test;

import static org.junit.jupiter.api.Assertions.*;
import checkout.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private String item1Code = "001";
	private String item1Name = "Travel Card Holder";
	private double item1price = 9.25;

	private ItemList itemList;
	private Item item;


	@Before
	public void setup() {
		itemList = new ItemListImpl();
		item = new Item(item1Code,item1Name,item1price);
		itemList.add(item);
	}

	@Test
	public void isItemExistTest() {
		assertTrue(itemList.isItemExist(item1Code));
	}

	@Test
	public void addTest() {
		assertTrue(itemList.getNamebyCode(item1Code).equals(item1Name));

	}

	@Test
	public void getNamebyCodeTest() {
		assertTrue(item1Name.equals(itemList.getNamebyCode(item1Code)));
	}

	@Test
	public void getPriceByCode() {
		assertTrue(item1price==itemList.getPriceByCode(item1Code));
	}

}
