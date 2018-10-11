package git.javabootcamp.orders.gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

import git.javabootcamp.orders.SupportClass;

/**
 * FileFilter used to show only .csv files
 *
 */

public class CSVFileFilter extends FileFilter {

	@Override
	public String getDescription() {
		return ".csv files";
	}

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = SupportClass.getFileExtension(f);

		if (extension.equals(".csv")) {
			return true;
		}

		return false;
	}

}
