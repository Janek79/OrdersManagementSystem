package git.javabootcamp.orders;

import static org.junit.Assert.assertArrayEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FilesConvertionTest {

	@Test
	public void testGetOrderListFromXML() throws InvalidFileExtension {
		List<Order> list = new ArrayList<>();
		List<Order> listFromFile = FileConverter.getOrderListFromXML(new File("src/resources/raport2.xml"));
		
		list.add(new Order(1, 1, "Gulasz", 1, 10.00f));
		list.add(new Order(1, 2, "Chleb", 2, 15.00f));
		list.add(new Order(1, 2, "Chleb", 5, 15.00f));
		list.add(new Order(2, 1, "Chleb", 1, 10.00f));
		list.add(new Order(20, 10, "Pieczywo", 0, 10.00f));
		
		assertArrayEquals(list.toArray(new Order[list.size()]), listFromFile.toArray(new Order[listFromFile.size()]));
	}
	
	@Test
	public void testGetOrderListFromCSV() throws InvalidFileExtension {
		List<Order> list = new ArrayList<>();
		List<Order> listFromFile = FileConverter.getOrderListFromCSV(new File("src/resources/raport1.csv"));
		
		list.add(new Order(1, 1, "Gulasz", 1, 10.00f));
		list.add(new Order(1, 1, "Ser", 2, 15.00f));
		list.add(new Order(1, 2, "Kotlet", 5, 15.00f));
		list.add(new Order(2, 1, "Pieczarki", 1, 10.00f));
		
		assertArrayEquals(list.toArray(new Order[list.size()]), listFromFile.toArray(new Order[listFromFile.size()]));
	}
	
	@Test(expected = InvalidFileExtension.class)
	public void testWrongFileExtension() throws InvalidFileExtension {
		FileConverter.getOrderListFromCSV(new File("src/resources/raport2.xml"));
	}

}
