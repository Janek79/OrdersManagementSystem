package git.javabootcamp.orders;

import static git.javabootcamp.orders.SupportClass.queryToString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Object containing methods to manage in-memory database.
 * There is only one database for the application.
 *
 */
public class InMemoryDatabaseService {
	private static String driverClass = "org.sqlite.JDBC";
	private static String url = "jdbc:sqlite:memory:myDb";
	private static Connection conn;

	private InMemoryDatabaseService() {

	}

	public static Connection getConnection() throws SQLException {
		if (conn != null) {
			return conn;
		} else {
			try {
				Class.forName(driverClass);
				conn = DriverManager.getConnection(url);
				System.out.println("Connection successful!");
				conn.createStatement().execute(queryToString("CreateTable.txt"));
				return conn;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static void connectTest() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection successful!");
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void disconnect() {
		if (conn != null) {
			try {
				conn.createStatement().execute("DROP TABLE orders");
				conn.close();
				conn = null;
				System.out.println("Disconnection succesfull!");
			} catch (SQLException e) {
				System.out.println("Disconnection failed!");
				e.printStackTrace();
			}
		}
	}

	public static void executeQuery(String query) {
		try {
			getConnection().createStatement().execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getResultSet(String query) {
		try {
			return getConnection().createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean saveOrder(Order order) {
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(queryToString("InsertValue.txt"));
			preparedStatement.setInt(1, order.getClientId());
			preparedStatement.setLong(2, order.getRequestId());
			preparedStatement.setString(3, order.getName());
			preparedStatement.setInt(4, order.getQuantity());
			preparedStatement.setFloat(5, order.getPrice());
			preparedStatement.execute();
			System.out.println("Order saved");
			return true;
		} catch (SQLException e) {
			System.out.println("Saving failure");
			return false;
		}
	}

	public static int saveOrderList(List<Order> orders) {
		int savedOrders = 0;
		for(Order order: orders) {
			if(InMemoryDatabaseService.saveOrder(order)) {
				savedOrders++;
			}
		}
		
		return savedOrders;
	}
	
	/*
	 * All raports required in the application
	 */

	public static int getNumberOfOrders() {
		return getOrderList().size();
	}

	public static int getNumberOfOrdersForClient(int clientId) {
		return getOrderListForClient(clientId).size();
	}

	public static float getTotalOrdersAmount() {
		float totalAmount = 0f;
		for (Order o : getOrderList()) {
			totalAmount += o.getPrice();
		}

		return totalAmount;
	}

	public static float getTotalOrdersAmountForClient(int clientId) {
		float totalAmount = 0f;
		for (Order o : getOrderListForClient(clientId)) {
			totalAmount += o.getPrice();
		}

		return totalAmount;
	}

	public static List<Order> getOrderList() {
		List<Order> list = new ArrayList<>();
		ResultSet result = getResultSet(queryToString("ShowAll.txt"));
		try {
			while (result.next()) {
				Order order = new Order(result.getInt(1), result.getLong(2), result.getString(3), result.getInt(4),
						result.getFloat(5));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Order> getOrderListForClient(int clientId) {
		List<Order> list = new ArrayList<>();
		for (Order o : getOrderList()) {
			if (o.getClientId() == clientId) {
				list.add(o);
			}
		}

		return list;
	}

	public static float getAverageOrderAmount() {
		return getTotalOrdersAmount() / getNumberOfOrders();
	}

	public static float getAverageOrderAmountForClient(int clientId) {
		return getTotalOrdersAmountForClient(clientId) / getNumberOfOrdersForClient(clientId);
	}

	public static boolean isClientExists(int clientId) {
		if (getOrderListForClient(clientId).isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isOrderListEmpty() {
		if (getOrderList().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
