package example.iterator;

public interface Collection {
    Iterator getIterator();
    void setUBound(long uBound, Iterator iterator);
}
