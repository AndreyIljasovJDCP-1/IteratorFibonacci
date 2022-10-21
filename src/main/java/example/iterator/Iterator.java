package example.iterator;

public interface Iterator {
    boolean hasNext();

    int next();

    boolean resetIndex();

    boolean hasPrevious();

    int current();

    int previous();
}
