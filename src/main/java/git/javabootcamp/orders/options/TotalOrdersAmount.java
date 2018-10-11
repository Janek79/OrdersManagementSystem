package git.javabootcamp.orders.options;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.ReportsGenerator;

public class TotalOrdersAmount extends GeneralOption {

	@Override
	public String getStringForShow() {
		return "Total orders amount: " + InMemoryDatabaseService.getTotalOrdersAmount();
	}

	@Override
	public String getStringForSave() {
		return ReportsGenerator.totalOrdersAmount();
	}

	@Override
	public String getOptionText() {
		return "Total orders amount";
	}

}
