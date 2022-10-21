import example.iterator.Collection;
import example.iterator.Fibonacci;
import example.iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        Collection fibonacci = new Fibonacci(144);
        Iterator iterator = fibonacci.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Текущий элемент: " + iterator.current());
        System.out.println("Предыдущий элемент: " + iterator.previous());
        System.out.println("Сброс индекса: " + iterator.resetIndex());
        System.out.println("Текущий элемент: " + iterator.current());
        System.out.println("Предыдущий элемент: " + iterator.previous());

        fibonacci.setUpperBound(55);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        fibonacci.setLowerBound(21);

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

    }
}