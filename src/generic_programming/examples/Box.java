package generic_programming.examples;

public class Box<T> {

	private T content;

	public Box(T content) {
		this.content = content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public T getContent() {
		return this.content;
	}

	public static void main(String[] args) {

		Box<String> stringBox = new Box<>("HelloWorld");
		String s = stringBox.getContent();

		Box<Integer> integerBox = new Box<>(100);
		int i = integerBox.getContent();

		Box<Box<Integer>> doubleIntegerBox = new Box<>(integerBox);
		int j = doubleIntegerBox.getContent().getContent();
	}
}