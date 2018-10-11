package git.javabootcamp.orders.options;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.ReportsGenerator;

public class NumberOfOrders extends GeneralOption {

	@Override
	public String getStringForShow() {
		return "Number of orders: " + InMemoryDatabaseService.getNumberOfOrders();
	}

	@Override
	public String getStringForSave() {
		return ReportsGenerator.numberOfOrders();
	}

	@Override
	public String getOptionText() {
		return "Number of orders";
	}

}
