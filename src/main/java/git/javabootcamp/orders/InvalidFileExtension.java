package git.javabootcamp.orders;

public class InvalidFileExtension extends Exception {	
	@Override
	public String getMessage() {
		return "Invalid file extension";
	}
}
