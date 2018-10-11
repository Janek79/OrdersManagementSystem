package git.javabootcamp.orders.options;

import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.SupportClass;

/**
 * Option which need JTextField contained client ID
 * 
 * @author user
 *
 */
public abstract class OptionWithID extends Option {

	public abstract String getStringForShow(int clientId);

	public abstract String getStringForSave(int clientId);

	public final void showRaport(JTextField idField) {
		Integer id = validate(idField);
		if (id != null) {
			JOptionPane.showMessageDialog(null, getStringForShow(id), "Raport", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public final void saveRaport(JTextField idField, File file) {
		Integer id = validate(idField);
		if (id != null) {
			SupportClass.saveCSVFile(file, getStringForSave(id));
		}

	}

	/**
	 * 
	 * @param idField
	 * @return client ID if everything is correct, otherwise - null
	 */
	private Integer validate(JTextField idField) {
		int id;

		try {
			id = Integer.parseInt(idField.getText());
			if (InMemoryDatabaseService.isOrderListEmpty() || !InMemoryDatabaseService.isClientExists(id)) {
				JOptionPane.showMessageDialog(null, "Such client doesn't exist. Lack of data.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return null;
			} else {
				return id;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Type in valid client ID!", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
