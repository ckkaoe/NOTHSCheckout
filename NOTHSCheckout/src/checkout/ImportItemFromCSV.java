package checkout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportItemFromCSV {

	private static final char COMMA_DELIMITER = ',';
	private String itemCode;
	private String itemName;
	private double price;
	
	public ImportItemFromCSV() {
		
	}

	public ItemList readFile(String filepath) {
		ItemList itemList = new ItemListImpl();
		Item item;
		List<String> dataRow;
		String csvDataRow = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

			//Skip title role
			 br.readLine();
			//Get data from CSV
			while ((csvDataRow = br.readLine()) != null) {
				dataRow = readDataLineToArrayList(csvDataRow);
				try {
					if (!dataRow.isEmpty()) {
						if (dataRow.get(1).length()>0) {
							itemCode = dataRow.get(0);
						}
						if (dataRow.get(1).length()>0) {
							itemName = dataRow.get(1);
						}
						if (dataRow.get(2).length()>0) {
							price = Double.valueOf(dataRow.get(2));
						}
						item = new Item(itemCode, itemName, price);
						//item.setCode(itemCode);
						//item.setName(itemName);
						//item.setPrice(price);
						itemList.add(item);
					}
					
					
				}  catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return itemList;
	}
	
	private static List<String> readDataLineToArrayList(String dataLine) {
		StringBuilder data = new StringBuilder();
		List dataArrayList = new ArrayList<>();
		char[] csvCharLine = dataLine.toCharArray();        
		int columnCounter = 0;

		for (char csvChar : csvCharLine) {
			if (csvChar == COMMA_DELIMITER && !(csvChar == '"')) {
				dataArrayList.add(data.toString());
				data = new StringBuilder();              
			}
			else {
				data.append(csvChar);
			}

			columnCounter++;
			//Last Column
			if (columnCounter == csvCharLine.length-1) { 
				dataArrayList.add(data.toString());
			}
		}
		return dataArrayList;
	}
}
