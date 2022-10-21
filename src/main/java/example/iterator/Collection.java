package example.iterator;

public interface Collection {
    Iterator getIterator();
    void setLowerBound(int lowerBound);
    void setUpperBound(int uBound);
}
