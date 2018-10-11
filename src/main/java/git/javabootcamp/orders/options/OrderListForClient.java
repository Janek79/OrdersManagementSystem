package git.javabootcamp.orders.options;

import java.util.List;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.Order;
import git.javabootcamp.orders.ReportsGenerator;

public class OrderListForClient extends OptionWithID {

	@Override
	public String getStringForShow(int clientId) {
		StringBuilder orderStringListForClient = new StringBuilder();
		List<Order> orderListForClient = InMemoryDatabaseService.getOrderListForClient(clientId);
		for (Order o : orderListForClient) {
			orderStringListForClient.append(o + "\n");
		}

		return "Order list for client " + clientId + "\n" + orderStringListForClient.toString();
	}

	@Override
	public String getStringForSave(int clientId) {
		return ReportsGenerator.orderListForClient(clientId);
	}

	@Override
	public String getOptionText() {
		return "Order list for the chosen client";
	}

}
