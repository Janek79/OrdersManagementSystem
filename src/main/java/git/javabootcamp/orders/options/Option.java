package git.javabootcamp.orders.options;

/**
 * You can use option to choose report you want to generate in application
 *
 */
public abstract class Option {
	/**
	 * @return String which will be display on screen
	 */
	public abstract String getOptionText();

	@Override
	public final String toString() {
		return getOptionText();
	}

}
