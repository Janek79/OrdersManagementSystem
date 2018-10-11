package git.javabootcamp.orders.options;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.ReportsGenerator;

public class TotalOrdersAmountForClient extends OptionWithID {

	@Override
	public String getStringForShow(int clientId) {
		return "Total orders amount for client " + clientId + ": "
				+ InMemoryDatabaseService.getTotalOrdersAmountForClient(clientId);
	}

	@Override
	public String getStringForSave(int clientId) {
		return ReportsGenerator.totalOrdersAmountForClient(clientId);
	}

	@Override
	public String getOptionText() {
		return "Total orders amount for the chosen client";
	}

}
