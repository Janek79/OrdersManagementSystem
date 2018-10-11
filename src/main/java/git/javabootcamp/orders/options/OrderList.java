package git.javabootcamp.orders.options;

import java.util.List;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.Order;
import git.javabootcamp.orders.ReportsGenerator;

public class OrderList extends GeneralOption {

	@Override
	public String getStringForShow() {
		StringBuilder orderStringList = new StringBuilder();
		List<Order> orderList = InMemoryDatabaseService.getOrderList();
		for (Order o : orderList) {
			orderStringList.append(o + "\n");
		}
		
		return "Order list\n" + orderStringList.toString();
	}

	@Override
	public String getStringForSave() {
		return ReportsGenerator.orderList();
	}

	@Override
	public String getOptionText() {
		return "Order list";
	}

}
