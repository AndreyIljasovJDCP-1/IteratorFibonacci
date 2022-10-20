import example.iterator.Fibonacci;
import example.iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(145);
        Iterator iterator = fibonacci.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        fibonacci.setUBound(233);
        iterator.resetIndex();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}