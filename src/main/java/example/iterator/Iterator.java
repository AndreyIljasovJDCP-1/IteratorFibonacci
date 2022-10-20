package example.iterator;

public interface Iterator {
    boolean hasNext();
    long next();
    void resetIndex();
    boolean hasPrevious();
    long last();
    long previous();
}
