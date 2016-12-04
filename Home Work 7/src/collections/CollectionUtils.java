package collections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        //TODO Implement me

        return null;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        if (predicate == null) {
        throw new NullPointerException();
    }
    ListIterator<E> iterator = elements.listIterator();
        for(int i = 0; iterator.hasNext(); i++) {
            final E element = iterator.next();
            if (predicate.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {

        if (predicate == null) {
            throw new NullPointerException();
        }
        ListIterator<E> iterator = elements.listIterator();
            while (iterator.hasNext()) {
                final E element = iterator.next();
                if (!predicate.equals(element)) {
                    return false;
                }
            }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        if (predicate == null) {
            throw new NullPointerException();
        }
        ListIterator<E> iterator = elements.listIterator();
        for(int i = 0; iterator.hasNext(); i++) {
            final E element = iterator.next();
            if (predicate.equals(element)) {
                return false;
            }
        }
        return true;
    }


    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        //TODO Implement me
        return null;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        //TODO Implement me
        return null;
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        //TODO Implement me
        return null;
    }

    public static <E> List<E> distinct(List<E> elements) {
        //TODO Implement me
        return null;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        //TODO Implement me
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        return null;
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        //TODO Implement me
        return null;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        //TODO Implement me
        return null;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        //TODO Implement me
        return null;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        //TODO Implement me
        return null;
    }
}