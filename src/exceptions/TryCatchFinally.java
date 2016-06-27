package exceptions;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.println("A");
        } catch (RuntimeException re) {
            System.out.println("B");
        } catch (Exception e) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
        System.out.println("E");
    }

    private static void badMethod() {
        throw new RuntimeException();
    }
}
