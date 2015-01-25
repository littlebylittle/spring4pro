package replacement;

public class MyString {
	private final String core;

	public MyString(String core) {
		this.core = core;
	}

	public String getCore() {
		return core;
	}

	@Override
	public String toString() {
		return "MyString{" + core + '}';
	}
}
