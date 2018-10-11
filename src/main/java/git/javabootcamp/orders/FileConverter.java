package git.javabootcamp.orders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Exception;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class which allows to retrieve Order objects from .csv and .xml files
 *
 */

public class FileConverter {
	public static List<Order> getOrderListFromCSV(File csvFile) throws InvalidFileExtension {

		if (SupportClass.getFileExtension(csvFile).equals(".csv")) {

			List<Order> list = new ArrayList<>();

			try (Scanner scanner = new Scanner(csvFile)) {

				if (scanner.nextLine().replaceAll(" ", "")
						.equalsIgnoreCase("client_id,request_id,name,quantity,price")) { 
																							// "Client_Id,Request_id,Name,Quantity,Price"

					while (scanner.hasNext()) {

						String line = scanner.nextLine();
						String[] elements = line.split(",");

						if (elements.length == 5) {
							try {
								list.add(new Order(Integer.parseInt(elements[0].trim()),
										Long.parseLong(elements[1].trim()), elements[2].trim(),
										Integer.parseInt(elements[3].trim()), Float.parseFloat(elements[4].trim())));
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"File has invalid data lines:\n " + line
												+ "\n Only correct lines will be loaded",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"File has invalid data lines:\n" + line + "\n Only correct lines will be loaded",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "File hasn't correct headline or there is problem with encoding", "Error", JOptionPane.ERROR_MESSAGE);
				}

				return list;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "File is invalid or does not exist", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			throw new InvalidFileExtension();
		}

		return null;
	}

	public static List<Order> getOrderListFromXML(File xmlFile) throws InvalidFileExtension {

		if (SupportClass.getFileExtension(xmlFile).equals(".xml")) {

			List<Order> list = new ArrayList<>();

			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
				doc.getDocumentElement().normalize();

				NodeList requests = doc.getElementsByTagName("request");

				for (int i = 0; i < requests.getLength(); i++) {
					Element element = (Element) requests.item(i);

					int clientId = 0;
					long requestId = 0l;
					String name = "";
					int quantity = 0;
					float price = 0.00f;

					try {
						clientId = Integer.parseInt(element.getElementsByTagName("clientId").item(0).getTextContent());
					} catch (NullPointerException n) {
					}

					try {
						requestId = Long.parseLong(element.getElementsByTagName("requestId").item(0).getTextContent());
					} catch (NullPointerException n) {
					}

					try {
						name = element.getElementsByTagName("name").item(0).getTextContent();
					} catch (NullPointerException n) {
					}

					try {
						quantity = Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent());
					} catch (NullPointerException n) {
					}

					try {
						price = Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent());
					} catch (NullPointerException n) {
					}

					list.add(new Order(clientId, requestId, name, quantity, price));

				}

				return list;

			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
		} else {
			throw new InvalidFileExtension();
		}

		return null;
	}

	/**
	 * This method is able to get order list from .csv or .xml file
	 * 
	 * @return
	 * @throws InvalidFileExtension
	 */
	public static List<Order> getOrderListFromFile(File file) throws InvalidFileExtension {
		if (SupportClass.getFileExtension(file).equals(".csv")) {
			return getOrderListFromCSV(file);
		} else if (SupportClass.getFileExtension(file).equals(".xml")) {
			return getOrderListFromXML(file);
		} else {
			throw new InvalidFileExtension();
		}
	}

}
