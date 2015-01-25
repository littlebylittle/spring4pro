package replacement;

public class ReplacementTarget {
	public String formatMessage(Object o) {
		return "<b>" + o + "</b>";
	}
	public String formatMessage(String s) {
		return "<orig>" + s + "</orig>";
	}

	public MyString formatMessage(MyString s) {
		return new MyString(s.getCore() + "wrap");
	}
}