package git.javabootcamp.orders.options;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.ReportsGenerator;

public class NumberOfOrdersForClient extends OptionWithID {

	@Override
	public String getStringForShow(int clientId) {
		return "Number of orders for client " + clientId + ": "
				+ InMemoryDatabaseService.getNumberOfOrdersForClient(clientId);
	}

	@Override
	public String getStringForSave(int clientId) {
		return ReportsGenerator.numberOfOrdersForClient(clientId);
	}

	@Override
	public String getOptionText() {
		return "Number of orders for the chosen client";
	}

}
