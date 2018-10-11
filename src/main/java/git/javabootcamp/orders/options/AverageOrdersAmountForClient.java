package git.javabootcamp.orders.options;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.ReportsGenerator;

public class AverageOrdersAmountForClient extends OptionWithID {

	@Override
	public String getStringForShow(int clientId) {
		return "Average orders amount for client: " + clientId + ": "
				+ InMemoryDatabaseService.getAverageOrderAmountForClient(clientId);
	}

	@Override
	public String getStringForSave(int clientId) {
		return ReportsGenerator.averageOrderAmountForClient(clientId);
	}

	@Override
	public String getOptionText() {
		return "Average orders amount for the chosen client";
	}

}
