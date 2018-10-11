package git.javabootcamp.orders;

import java.io.File;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Orders Management System for Java Boot Camp in Core Services
 * 
 * @author Jan Jankowicz
 */
public class App {
	public static void main(String[] args) {
		try {

			InMemoryDatabaseService.getConnection();

			if (args.length != 0) {
				int savedOrders = 0;
				for (String fileName : args) {
					savedOrders += SupportClass.saveOrdersFromFileToDatabase(new File(fileName));
				}
				JOptionPane.showMessageDialog(null, savedOrders + " orders saved", "Orders", JOptionPane.INFORMATION_MESSAGE);
			}
			
			new AppFrame("Order management system");

			while (true) {}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection with in-memory database failed", "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Critical error!", "Critical error!", JOptionPane.ERROR_MESSAGE);
		} finally {
			InMemoryDatabaseService.disconnect();
		}
	}
}