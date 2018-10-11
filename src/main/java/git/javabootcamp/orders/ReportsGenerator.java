package git.javabootcamp.orders;

import java.util.List;

/**
 * Class contains methods which can generate String for saving in .csv file 
 *
 */
public class ReportsGenerator {
	private static String sep = System.lineSeparator();
	
	private ReportsGenerator() {}
	
	public static String numberOfOrders() {
		return "Number of all orders" + sep + InMemoryDatabaseService.getNumberOfOrders();
	}
	
	public static String numberOfOrdersForClient(int clientId) {
		return "Number of all orders for client " + clientId + sep + InMemoryDatabaseService.getNumberOfOrdersForClient(clientId);
	}
	
	public static String totalOrdersAmount() {
		return "Total orders amount" + sep + InMemoryDatabaseService.getTotalOrdersAmount();
	}
	
	public static String totalOrdersAmountForClient(int clientId) {
		return "Total orders amount for client " + clientId + sep + InMemoryDatabaseService.getTotalOrdersAmountForClient(clientId);
	}
	
	public static String orderList() {
		StringBuilder str = new StringBuilder("Client_Id,Request_id,Name,Quantity,Price" + sep);
		List<Order> list = InMemoryDatabaseService.getOrderList();
		
		for(Order o: list) {
			str.append(o.getClientId() + "," + o.getRequestId() + "," + o.getName() + "," + o.getQuantity() + "," + o.getPrice() + sep);
		}
		
		return str.toString();
	}
	
	public static String orderListForClient(int clientId) {
		StringBuilder str = new StringBuilder("Client_Id,Request_id,Name,Quantity,Price" + sep);
		List<Order> list = InMemoryDatabaseService.getOrderListForClient(clientId);
		
		for(Order o: list) {
			str.append(o.getClientId() + "," + o.getRequestId() + "," + o.getName() + "," + o.getQuantity() + "," + o.getPrice() + sep);
		}
		
		return str.toString();
	}
	
	public static String averageOrderAmount() {
		return "Average order amount" + sep + InMemoryDatabaseService.getAverageOrderAmount();
	}
	
	public static String averageOrderAmountForClient(int clientId) {
		return "Average order amount for client " + clientId + sep + InMemoryDatabaseService.getAverageOrderAmountForClient(clientId);
	}
}
