package git.javabootcamp.orders.gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import git.javabootcamp.orders.SupportClass;

/**
 * FileChooser for showing only .csv or .xml files
 *
 */

public class XMLorCSVFileChooser extends JFileChooser {
	public XMLorCSVFileChooser() {
		this.setMultiSelectionEnabled(true);
		this.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return ".csv or .xml files";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}

				String extension = SupportClass.getFileExtension(f);

				if (extension.equals(".csv") || extension.equals(".xml")) {
					return true;
				}

				return false;
			}
		});
	}
}
