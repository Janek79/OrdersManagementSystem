package git.javabootcamp.orders;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class RequiredReportsTest {
	@BeforeClass
	public static void init() throws SQLException {
		InMemoryDatabaseService.getConnection();
		List<Order> list = new ArrayList<>();
		list.add(new Order(1, 1, "Bułka", 1, 10.00f));
		list.add(new Order(1, 2, "Chleb", 2, 15.00f));
		list.add(new Order(1, 2, "Chleb", 5, 15.00f));
		list.add(new Order(2, 1, "Chleb", 1, 10.00f));
		list.add(new Order(2, 1, "Kawior", 3, 20.00f));
		list.add(new Order(20, 10, "Pieczywo", 0, 10.00f));

		for (Order o : list) {
			InMemoryDatabaseService.saveOrder(o);
		}

	}

	@DataProvider
	public static Object[][] numbersClients() {
		return new Object[][] { { 3, 1 }, { 2, 2 }, { 1, 20 } };
	}

	@DataProvider
	public static Object[][] amountsClients() {
		return new Object[][] { { 40, 1 }, { 30, 2 }, { 10, 20 } };
	}

	@DataProvider
	public static Object[][] averagesClients() {
		return new Object[][] { { 13.33f, 1 }, { 15, 2 }, { 10, 20 } };
	}

	@Test
	public void testGetNumberOfOrders() {
		assertEquals(6, InMemoryDatabaseService.getNumberOfOrders());
	}

	@Test
	@UseDataProvider("numbersClients")
	public void testGetNumberOfOrdersForClient(int input, int id) {
		assertEquals(input, InMemoryDatabaseService.getNumberOfOrdersForClient(id));
	}

	@Test
	public void testGetTotalOrdersAmount() {
		assertEquals(80.00f, InMemoryDatabaseService.getTotalOrdersAmount(), 0.005);
	}

	@Test
	@UseDataProvider("amountsClients")
	public void testGetTotalOrdersAmountForClient(float input, int id) {
		assertEquals(input, InMemoryDatabaseService.getTotalOrdersAmountForClient(id), 0.005);
	}

	@Test
	public void testGetAverageOrderAmount() {
		assertEquals(13.33f, InMemoryDatabaseService.getAverageOrderAmount(), 0.005);
	}

	@Test
	@UseDataProvider("averagesClients")
	public void testGetAverageOrderAmountForClient(float input, int id) {
		assertEquals(input, InMemoryDatabaseService.getAverageOrderAmountForClient(id), 0.005);
	}

	@AfterClass
	public static void afterClass() {
		InMemoryDatabaseService.disconnect();
	}

}
