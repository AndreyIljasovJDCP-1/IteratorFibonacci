package example.iterator;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Fibonacci implements Collection {

    private long[] sequence;
    private long uBound;
    public Fibonacci(long uBound) {
        this.uBound = uBound;
        this.sequence = generateSequence(uBound, 0, 1);
    }

    private long[] generateSequence(long uBound, long first, long next) {
        AtomicInteger i = new AtomicInteger(1);
        long size = Stream.iterate(new long[]{first, next, 1},
                        arr -> new long[]{arr[1], arr[0] + arr[1], i.incrementAndGet()})
                .filter(arr -> arr[1] > uBound)
                .findFirst()
                .map(arr -> arr[2])
                .get();
        return Stream.iterate(
                        new long[]{first, next}, arr -> new long[]{arr[1], arr[0] + arr[1]})
                .limit(size)
                .mapToLong(el -> el[0])
                .toArray();
    }

    public void setUBound(long uBound, Iterator iterator) {

        if (uBound > this.uBound) {
            long last = iterator.last();
            long current = last + iterator.previous();
            if (current > uBound) {
                iterator.resetIndex();//сбрасываем индекс, т.к. сейчас он на предыдущем
                return;
            }

            long next = current + last;

            if (next > uBound) {
                long[] joined = Arrays.copyOf(sequence, sequence.length + 1);
                joined[joined.length - 1] = current;
                sequence = joined;
                this.uBound = uBound;
                iterator.resetIndex();//сбрасываем индекс, т.к. сейчас он на предыдущем и 1 эл-т добавился
                return;
            }
            long[] upSequence = generateSequence(uBound, current, next);
            long[] joined = Arrays.copyOf(sequence, sequence.length + upSequence.length);
            System.arraycopy(upSequence, 0, joined, sequence.length, upSequence.length);
            this.sequence = joined;
            this.uBound = uBound;
            iterator.resetIndex();//сбрасываем индекс, т.к. новая последовательность
        }
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
        public long last() {
            index = sequence.length - 1;
            return sequence[index];
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public long previous() {
            if (hasPrevious()) {
                return sequence[--index];
            } else {
                throw new RuntimeException("Нет предыдущего элемента");
            }
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
