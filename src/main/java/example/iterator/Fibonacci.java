package example.iterator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Fibonacci implements Collection {

    private long[] sequence;

    public Fibonacci(long uBound) {
        this.sequence = generateSequence(uBound);
    }

    private long[] generateSequence(long uBound) {
        AtomicInteger i = new AtomicInteger(1);
        long size = Stream.iterate(new long[]{0, 1, 1},
                        arr -> new long[]{arr[1], arr[0] + arr[1], i.incrementAndGet()})
                .filter(arr -> arr[1] > uBound)
                .findFirst()
                .map(arr -> arr[2])
                .get();
        return Stream.iterate(
                new long[]{0, 1}, arr -> new long[]{arr[1], arr[0] + arr[1]})
                .limit(size)
                .mapToLong(el -> el[0])
                .toArray();
    }

    public void setUBound(long uBound) {
        this.sequence = generateSequence(uBound);

    }

    public long[] getSequence() {
        return sequence;
    }

    @Override
    public Iterator getIterator() {
        return new F_Iterator();
    }

    private class F_Iterator implements Iterator {
        int index;

        public void resetIndex() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < sequence.length;
        }

        @Override
        public long next() {
            return sequence[index++];
        }
    }
}
