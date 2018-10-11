package git.javabootcamp.orders.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import git.javabootcamp.orders.options.GeneralOption;
import git.javabootcamp.orders.options.Option;
import git.javabootcamp.orders.options.OptionWithID;

public class SaveReportButton extends JButton {
	public SaveReportButton(JFrame parentFrame, JComboBox<Option> optionList, JTextField idField) {
		this.setText("Save raport...");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveChooser = new JFileChooser();
				saveChooser.setFileFilter(new CSVFileFilter());
				if(saveChooser.showSaveDialog(parentFrame) == JFileChooser.APPROVE_OPTION) {
					File file = saveChooser.getSelectedFile();
					
					Object chosedOption = optionList.getSelectedItem();
					if (chosedOption instanceof GeneralOption) {
						((GeneralOption) chosedOption).saveRaport(file);
					} else if (chosedOption instanceof OptionWithID) {
						((OptionWithID) chosedOption).saveRaport(idField, file);
					}
				}
				
				
			}
		});

	}


}

//public static void saveCSVFile(String fileName, String content) {
//	try (FileWriter writer = new FileWriter(fileName)) {
//		writer.write(content);
//		JOptionPane.showMessageDialog(null, "Your .csv file has been created", "Success",
//				JOptionPane.INFORMATION_MESSAGE);
//	} catch (IOException e1) {
//		JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
//	}
//}

//int option = optionList.getSelectedIndex();
//int idx;
//try {
//	idx = Integer.parseInt(idField.getText());
//} catch (NumberFormatException f) {
//	if (option == 1 || option == 3 || option == 5 || option == 7) {
//		JOptionPane.showMessageDialog(null, "Type in correct id!", "Error", JOptionPane.ERROR_MESSAGE);
//		return;
//	}
//}
//
//if (InMemoryDatabaseService.isOrderListEmpty()) {
//	JOptionPane.showMessageDialog(parentFrame, "No data to save", "Error", JOptionPane.ERROR_MESSAGE);
//	return;
//}
//
//JFileChooser fileSaver = new JFileChooser();
//fileSaver.setFileFilter(new CSVFileFilter());
//int i = fileSaver.showSaveDialog(parentFrame);
//
//if (i == JFileChooser.APPROVE_OPTION) {
//
//	String extension = SupportClass.getFileExtension(fileSaver.getSelectedFile());
//	String fileName = fileSaver.getSelectedFile().toString();
//
//	if (extension.equals("") || (extension.equals(".csv") && fileSaver.getSelectedFile().exists())) {
//
//		// file overwriting
//		int overwriting = 10;
//		System.out.println(fileSaver.getSelectedFile() + ".csv");
//		if ((extension.equals("") && new File(fileSaver.getSelectedFile() + ".csv").exists())
//				|| fileSaver.getSelectedFile().exists()) {
//			overwriting = JOptionPane.showConfirmDialog(parentFrame,
//					"Are you sure that you want to overwrite the existing file?", "Warning",
//					JOptionPane.YES_NO_OPTION);
//		} else if (extension.equals("")) {
//			fileName = fileName + ".csv";
//		}
//
//		if (overwriting == JOptionPane.OK_OPTION || overwriting == 10) {
//			int op = optionList.getSelectedIndex();
//			if (op == 0) {
//				saveCSVFile(fileName, RaportsGenerator.numberOfOrders());
//			} else if (op == 1) {
//				int id = Integer.parseInt(idField.getText());
//				if (InMemoryDatabaseService.isClientExists(id)) {
//					saveCSVFile(fileName, RaportsGenerator.numberOfOrdersForClient(id));
//				} else {
//					JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
//							"Error", JOptionPane.ERROR_MESSAGE);
//				}
//			} else if (op == 2) {
//				saveCSVFile(fileName, RaportsGenerator.totalOrdersAmount());
//			} else if (op == 3) {
//				int id = Integer.parseInt(idField.getText());
//				if (InMemoryDatabaseService.isClientExists(id)) {
//					saveCSVFile(fileName, RaportsGenerator.totalOrdersAmountForClient(id));
//				} else {
//					JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
//							"Error", JOptionPane.ERROR_MESSAGE);
//				}
//			} else if (op == 4) {
//				saveCSVFile(fileName, RaportsGenerator.orderList());
//			} else if (op == 5) {
//				int id = Integer.parseInt(idField.getText());
//				if (InMemoryDatabaseService.isClientExists(id)) {
//					saveCSVFile(fileName, RaportsGenerator.orderListForClient(id));
//				} else {
//					JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
//							"Error", JOptionPane.ERROR_MESSAGE);
//				}
//			} else if (op == 6) {
//				saveCSVFile(fileName, RaportsGenerator.averageOrderAmount());
//			} else if (op == 7) {
//				int id = Integer.parseInt(idField.getText());
//				if (InMemoryDatabaseService.isClientExists(id)) {
//					saveCSVFile(fileName, RaportsGenerator.averageOrderAmountForClient(id));
//				} else {
//					JOptionPane.showMessageDialog(null, "There isn't any order for that client!",
//							"Error", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		}
//	} else {
//		JOptionPane.showMessageDialog(parentFrame, "Don't use extension in file name!", "Error",
//				JOptionPane.ERROR_MESSAGE);
//	}
//}
