package git.javabootcamp.orders;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import git.javabootcamp.orders.gui.LoadXMLorCSVFilesButton;
import git.javabootcamp.orders.gui.SaveReportButton;
import git.javabootcamp.orders.gui.ShowReportButton;
import git.javabootcamp.orders.gui.XMLorCSVFileChooser;
import git.javabootcamp.orders.options.AverageOrdersAmount;
import git.javabootcamp.orders.options.AverageOrdersAmountForClient;
import git.javabootcamp.orders.options.NumberOfOrders;
import git.javabootcamp.orders.options.NumberOfOrdersForClient;
import git.javabootcamp.orders.options.Option;
import git.javabootcamp.orders.options.OptionWithID;
import git.javabootcamp.orders.options.OrderList;
import git.javabootcamp.orders.options.OrderListForClient;
import git.javabootcamp.orders.options.TotalOrdersAmount;
import git.javabootcamp.orders.options.TotalOrdersAmountForClient;

public class AppFrame extends JFrame {
	public AppFrame(String title) {
		this.setTitle(title);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(620, 100);
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				InMemoryDatabaseService.disconnect();
				super.windowClosing(e);
			}
		});

		// main panel for all other panels
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.add(panel);

		// panel for JFileChooser
		JPanel filePanel = new JPanel();
		filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.PAGE_AXIS));

		JFileChooser fileChooser = new XMLorCSVFileChooser();

		JButton loadFilesButton = new LoadXMLorCSVFilesButton(this, fileChooser);
		filePanel.add(loadFilesButton);

		panel.add(filePanel);

		panel.add(Box.createRigidArea(new Dimension(0, 10)));

		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));

		Option[] options = { new NumberOfOrders(), new NumberOfOrdersForClient(), new TotalOrdersAmount(),
				new TotalOrdersAmountForClient(), new OrderList(), new OrderListForClient(), new AverageOrdersAmount(),
				new AverageOrdersAmountForClient() };
		JComboBox<Option> optionList = new JComboBox<>(options);
		optionPanel.add(optionList);

		optionPanel.add(Box.createRigidArea(new Dimension(10, 0)));

		JLabel idText = new JLabel("Client ID:");
		idText.setVisible(false);
		optionPanel.add(idText);

		JTextField id = new JTextField();
		id.setVisible(false);
		optionPanel.add(id);

		optionList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (optionList.getSelectedItem() instanceof OptionWithID) {
					id.setVisible(true);
					idText.setVisible(true);
					AppFrame.this.revalidate();
				} else {
					idText.setVisible(false);
					id.setVisible(false);
				}
			}
		});

		optionPanel.add(Box.createRigidArea(new Dimension(10, 0)));

		optionPanel.add(new ShowReportButton(this, optionList, id));

		optionPanel.add(Box.createRigidArea(new Dimension(5, 0)));

		optionPanel.add(new SaveReportButton(this, optionList, id));

		panel.add(optionPanel);

		this.revalidate();
		this.repaint();
	}
}
