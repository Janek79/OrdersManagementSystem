package git.javabootcamp.orders.options;

import java.io.File;

import javax.swing.JOptionPane;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.SupportClass;

/**
 * Option which doesn't need any parameters
 * 
 * @author user
 *
 */
public abstract class GeneralOption extends Option {

	public abstract String getStringForShow();

	public abstract String getStringForSave();

	public final void showRaport() {
		if (validate()) {
			JOptionPane.showMessageDialog(null, getStringForShow(), "Raport", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public final void saveRaport(File file) {
		if (validate()) {
			SupportClass.saveCSVFile(file, getStringForSave());
		}
	}

	private boolean validate() {
		if (InMemoryDatabaseService.isOrderListEmpty()) {
			JOptionPane.showMessageDialog(null, "There is nothing in memory!", "Lack of data",
					JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
}
