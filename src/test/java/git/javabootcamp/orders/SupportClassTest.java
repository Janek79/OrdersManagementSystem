package git.javabootcamp.orders;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class SupportClassTest {

	@Test
	public void testTextFileToString() {
		assertEquals("CREATE TABLE IF NOT EXISTS orders(" + 
				"ClientId integer(6)," + 
				"RequestId long," + 
				"Name varchar(255)," + 
				"Quantity int," + 
				"Price DOUBLE PRECISION" + 
				");", SupportClass.queryToString("CreateTable.txt"));
	}
	
	@Test
	public void testQueryToString() {
		assertEquals("SELECT * FROM orders;", SupportClass.queryToString("ShowAll.txt"));
	}

	@DataProvider
	public static Object[][] namesExtensions(){
		return new Object[][] {
			{"bfdfsaf.csa", ".csa"},{"sadasdasd.gr", ".gr"}, {"gadscx", ""}, {"", ""}
		};
	}
	
	@Test
	@UseDataProvider("namesExtensions")
	public void testGetFileExtension(String fileName, String extension) {
		assertEquals(extension, SupportClass.getFileExtension(new File(fileName)));
	}

}
