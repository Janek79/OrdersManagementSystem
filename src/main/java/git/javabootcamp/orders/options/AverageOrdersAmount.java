package git.javabootcamp.orders.options;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.ReportsGenerator;

public class AverageOrdersAmount extends GeneralOption{

	@Override
	public String getStringForShow() {
		return "Average orders amount: " + InMemoryDatabaseService.getAverageOrderAmount();
	}

	@Override
	public String getStringForSave() {
		return ReportsGenerator.averageOrderAmount();
	}

	@Override
	public String getOptionText() {
		return "Average orders amount";
	}

}
