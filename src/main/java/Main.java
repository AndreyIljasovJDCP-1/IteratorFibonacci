import example.iterator.Collection;
import example.iterator.Fibonacci;
import example.iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection fibonacci = new Fibonacci(34);
        Iterator iterator = fibonacci.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        fibonacci.setUBound(100, iterator);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}