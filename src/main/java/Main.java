import example.iterator.Collection;
import example.iterator.Fibonacci;
import example.iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection fibonacci = new Fibonacci(55);
        Iterator iterator = fibonacci.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        fibonacci.setUBound(144, iterator);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}