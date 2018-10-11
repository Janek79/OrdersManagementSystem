package git.javabootcamp.orders.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import git.javabootcamp.orders.FileConverter;
import git.javabootcamp.orders.InMemoryDatabaseService;
import git.javabootcamp.orders.InvalidFileExtension;
import git.javabootcamp.orders.Order;
import git.javabootcamp.orders.SupportClass;

public class LoadXMLorCSVFilesButton extends JButton {
	public LoadXMLorCSVFilesButton(JFrame parentFrame, JFileChooser fileChooser) {
		this.setText("Load orders...");

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = fileChooser.showDialog(LoadXMLorCSVFilesButton.this, "Load");

				if (result == JFileChooser.APPROVE_OPTION) {
					File[] files = fileChooser.getSelectedFiles();
					
					SupportClass.saveOrdersFromFilesListToDatabase(Arrays.asList(files));
					
//					int i = 0;
//					for (File f : files) {
//						try {
//							for (Order o : FileConverter.getOrderListFromFile(f)) {
//								InMemoryDatabaseService.saveOrder(o);
//								System.out.println(o + " [SAVED]");
//								i++;
//							}
//						} catch (InvalidFileExtension e1) {
//							JOptionPane.showMessageDialog(parentFrame, "Invalid file extension. Must be .csv or .xml", "Error", JOptionPane.ERROR_MESSAGE);
//						}
//					}
//					JOptionPane.showMessageDialog(parentFrame, i + " orders saved", "Loading complete",
//							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
