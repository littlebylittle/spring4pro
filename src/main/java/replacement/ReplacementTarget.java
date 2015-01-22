package replacement;

public class ReplacementTarget {
	public String formatMessage(String s) {
		return "<orig>" + s + "</orig>";
	}

	public String formatMessage(Object o) {
		return "<b>" + o + "</b>";
	}

}
