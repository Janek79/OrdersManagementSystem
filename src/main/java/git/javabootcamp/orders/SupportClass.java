package git.javabootcamp.orders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Class with helpful, static methods
 */
public class SupportClass {

	/**
	 * 
	 * @param Name of file which contains SQLite query in folder /src/sql/ 
	 * @return SQLite query which can be executed
	 */
	public static String queryToString(String fileName) {
		StringBuilder query = new StringBuilder();

		try (Scanner scanner = new Scanner(new File("src/sql/" + fileName))) {
			System.out.println("File was found");

			while (scanner.hasNextLine()) {
				query.append(scanner.nextLine());
			}

			System.out.println(query.toString());

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			return null;
		}

		return query.toString();
	}

	public static String getFileExtension(File file) {
		String fileName = file.getName();
		StringBuilder extension = new StringBuilder();

		int i = fileName.lastIndexOf(".");
		if (i > 0) {
			for (int j = i; j < fileName.length(); j++) {
				extension.append(fileName.charAt(j));
			}
			return extension.toString();
		} else {
			return "";
		}
	}

	public static void saveCSVFile(File file, String content) {
		String extension = SupportClass.getFileExtension(file);

		if ((extension.equals("") && new File(file + ".csv").exists()) || file.exists()) {
			if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to overwrite the existing file?",
					"Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
		} else if (!extension.equals("")) {
			JOptionPane.showMessageDialog(null, "Don't use extension in file name!", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (extension.equals("")) {
			file = new File(file + ".csv");
		}

		try (FileWriter writer = new FileWriter(file)) {
			writer.write(content);
			JOptionPane.showMessageDialog(null, "Your .csv file has been created", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	public static int saveOrdersFromFileToDatabase(File file) {
		try {
			return InMemoryDatabaseService.saveOrderList(FileConverter.getOrderListFromFile(file));
		} catch (InvalidFileExtension e) {
			JOptionPane.showMessageDialog(null, "Invalid file extension. Must be .csv or .xml", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return 0;
	}
	
	public static int saveOrdersFromFilesListToDatabase(List<File> filesList) {
		int savedOrders = 0;
		
		for(File file: filesList) {
			savedOrders += saveOrdersFromFileToDatabase(file);
		}
		
		JOptionPane.showMessageDialog(null, savedOrders + " orders saved", "Loading complete",
				JOptionPane.INFORMATION_MESSAGE);
		
		return savedOrders;
	}
}
