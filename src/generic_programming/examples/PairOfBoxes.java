package generic_programming.examples;

public class PairOfBoxes<S, T> extends Pair<Box<S>, Box<T>> {

	public PairOfBoxes(Box<S> first, Box<T> second) {
		super(first, second);
	}

	public PairOfBoxes(S firstContent, T secondContent) {
		super(new Box<S>(firstContent), new Box<T>(secondContent));
	}

	public S getFirstContent() {
		return this.getFirst().getContent();
	}

	public T getSecondContent() {
		return this.getSecond().getContent();
	}

	public void setFirstContent(S content) {
		this.getFirst().setContent(content);
	}

	public void setSecondContent(T content) {
		this.getSecond().setContent(content);
	}
	
	public static void main(String[] args) {

		PairOfBoxes<String, Integer> pairOfBoxes = new PairOfBoxes<>("HelloWorld", 200);

		Box<String> box1 = pairOfBoxes.getFirst();
        System.out.println(box1.getContent());
        Box<Integer> box2 = pairOfBoxes.getSecond();
        System.out.println(box2.getContent());

		String s = pairOfBoxes.getFirstContent();
        System.out.println(s);
        Integer i = pairOfBoxes.getSecondContent();
        System.out.println(i);
    }
}
