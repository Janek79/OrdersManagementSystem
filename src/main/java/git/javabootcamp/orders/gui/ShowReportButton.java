package git.javabootcamp.orders.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import git.javabootcamp.orders.options.GeneralOption;
import git.javabootcamp.orders.options.Option;
import git.javabootcamp.orders.options.OptionWithID;

public class ShowReportButton extends JButton {
	/**
	 * Button for creating raports about stored orders
	 * 
	 * @param optionList
	 *            JComboBox which enables to choose kind of raport
	 * 
	 * @param idField
	 *            JTextField which enables to type in client id
	 */
	public ShowReportButton(JFrame frame, JComboBox<Option> optionList, JTextField idField) {
		this.setText("Show raport");

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object chosedOption = optionList.getSelectedItem();
				if (chosedOption instanceof GeneralOption) {
					((GeneralOption) chosedOption).showRaport();
				} else if (chosedOption instanceof OptionWithID) {
					((OptionWithID) chosedOption).showRaport(idField);
				}
			}

		});
	}

}

// if (!InMemoryDatabaseService.isOrderListEmpty()) {
// int i = optionList.getSelectedIndex();
// if (i == 0) {
// JOptionPane.showMessageDialog(frame,
// "Number of orders: " + InMemoryDatabaseService.getNumberOfOrders(), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// } else if (i == 1) {
// try {
// int id = Integer.parseInt(idField.getText());
// if (InMemoryDatabaseService.isClientExists(id)) {
// JOptionPane.showMessageDialog(frame,
// "Number of orders for client " + id + ": "
// + InMemoryDatabaseService.getNumberOfOrdersForClient(id),
// "Raport", JOptionPane.INFORMATION_MESSAGE);
// } else {
// JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// }
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(null, "Type in valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// }
//
// } else if (i == 2) {
// JOptionPane.showMessageDialog(frame,
// "Total orders amount: " + InMemoryDatabaseService.getTotalOrdersAmount(),
// "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// } else if (i == 3) {
// try {
// int id = Integer.parseInt(idField.getText());
// if (InMemoryDatabaseService.isClientExists(id)) {
// JOptionPane.showMessageDialog(frame,
// "Total orders amount for client " + id + ": "
// + InMemoryDatabaseService.getTotalOrdersAmountForClient(id),
// "Raport", JOptionPane.INFORMATION_MESSAGE);
// } else {
// JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// }
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(null, "Type in valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// }
//
// } else if (i == 4) {
// StringBuilder orderStringList = new StringBuilder();
// List<Order> orderList = InMemoryDatabaseService.getOrderList();
// for (Order o : orderList) {
// orderStringList.append(o + "\n");
// }
// System.out.println(RaportsGenerator.orderList()); // TODO
// JOptionPane.showMessageDialog(frame, "Order list\n" +
// orderStringList.toString(), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// } else if (i == 5) {
// try {
// int id = Integer.parseInt(idField.getText());
// if (InMemoryDatabaseService.isClientExists(id)) {
// StringBuilder orderStringListForClient = new StringBuilder();
// List<Order> orderListForClient =
// InMemoryDatabaseService.getOrderListForClient(id);
// for (Order o : orderListForClient) {
// orderStringListForClient.append(o + "\n");
// }
// JOptionPane.showMessageDialog(frame,
// "Order list for client " + id + "\n" + orderStringListForClient.toString(),
// "Raport", JOptionPane.INFORMATION_MESSAGE);
// } else {
// JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// }
//
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(null, "Type in valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// }
//
// } else if (i == 6) {
// JOptionPane.showMessageDialog(frame,
// "Average orders amount: " + InMemoryDatabaseService.getAverageOrderAmount(),
// "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// } else if (i == 7) {
// try {
// int id = Integer.parseInt(idField.getText());
// if (InMemoryDatabaseService.isClientExists(id)) {
// JOptionPane.showMessageDialog(frame,
// "Average orders amount for client: " + id + ": "
// + InMemoryDatabaseService.getAverageOrderAmountForClient(id),
// "Raport", JOptionPane.INFORMATION_MESSAGE);
// } else {
// JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
// "Error",
// JOptionPane.ERROR_MESSAGE);
// }
//
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(null, "Type in valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// }
//
// }
//
// } else {
// JOptionPane.showMessageDialog(frame, "No data to show", "Error",
// JOptionPane.ERROR_MESSAGE);
//
// }

// showRaport.addActionListener(new ActionListener() {
//
// @Override
// public void actionPerformed(ActionEvent e) {
// int clientId = 0;
//
// switch (optionList.getSelectedIndex()) {
// case 0:
// JOptionPane.showMessageDialog(frame, "Number of orders: " +
// InMemoryDatabaseService.getNumberOfOrders(), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// case 1:
// try {
// clientId = Integer.parseInt(id.getText());
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(fileChooser, "Type valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// break;
// }
//
// JOptionPane.showMessageDialog(frame, "Number of orders for client " +
// clientId + ": " +
// InMemoryDatabaseService.getNumberOfOrdersForClient(clientId), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// case 2:
// JOptionPane.showMessageDialog(frame, "Total orders amount: " +
// InMemoryDatabaseService.getTotalOrdersAmount(), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// case 3:
// try {
// clientId = Integer.parseInt(id.getText());
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(fileChooser, "Type valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// break;
// }
//
// JOptionPane.showMessageDialog(frame, "Total orders amount for client " +
// clientId + ": " +
// InMemoryDatabaseService.getTotalOrdersAmountForClient(clientId), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// case 4:
// StringBuilder orderStringList = new StringBuilder();
// List<Order> orderList = InMemoryDatabaseService.getOrderList();
// for(Order o: orderList) {
// orderStringList.append(o + "\n");
// }
// JOptionPane.showMessageDialog(frame, "Order list\n" +
// orderStringList.toString(), "Raport", JOptionPane.INFORMATION_MESSAGE);
// break;
// case 5:
// try {
// clientId = Integer.parseInt(id.getText());
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(fileChooser, "Type valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// break;
// }
//
// StringBuilder orderStringListForClient = new StringBuilder();
// List<Order> orderListForClient =
// InMemoryDatabaseService.getOrderListForClient(clientId);
// for(Order o: orderListForClient) {
// orderStringListForClient.append(o + "\n");
// }
// JOptionPane.showMessageDialog(frame, "Order list for client " + clientId +
// "\n" + orderStringListForClient.toString(), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// case 6:
// JOptionPane.showMessageDialog(frame, "Average orders amount: " +
// InMemoryDatabaseService.getAverageOrderAmount(), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// case 7:
// try {
// clientId = Integer.parseInt(id.getText());
// } catch (NumberFormatException f) {
// JOptionPane.showMessageDialog(fileChooser, "Type valid client ID!", "Error",
// JOptionPane.ERROR_MESSAGE);
// break;
// }
//
// JOptionPane.showMessageDialog(frame, "Average orders amount for client: " +
// clientId + ": " +
// InMemoryDatabaseService.getAverageOrderAmountForClient(clientId), "Raport",
// JOptionPane.INFORMATION_MESSAGE);
// break;
// }
//
// }
// });
