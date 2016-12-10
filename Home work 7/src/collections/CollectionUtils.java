package collections;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

     CollectionUtils() {
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> result = new ArrayList<>();
        for (E element : elements) {
            if (filter.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (!predicate.test(element)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        return !anyMatch(elements, predicate);
    }

    public static <T, R extends Function<T, R>> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> result = new ArrayList<>();
        for (T element : elements) {
            result.add(mappingFunction.apply(element));
        }
        return result;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        E max = elements.get(0);
        for (E element : elements) {
            if (comparator.compare(max, element) < 0) {
                max = element;
            }
        }
        return Optional.of(max);
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        E min = elements.get(0);
        for (E element : elements) {
            if (comparator.compare(min, element) >= 0) {
                min = element;
            }
        }
        return Optional.of(min);
    }

    public static <E> List<E> distinct(List<E> elements) {
        return new ArrayList<>(new HashSet<>(elements));
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
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
        Map<Boolean, List<E>> result = new HashMap<>();
        List<E> isTrue = null;
        List<E> isFalse = null;
        for (E element : elements) {
            if (predicate.test(element)) {
                isTrue.add(element);
            } else {
                isFalse.add(element);
            }
        }
        result.put(true, isTrue);
        result.put(false, isFalse);
        return result;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        Map<K, List<T>> result = new HashMap<>();
        for (T element : elements) {
            K type = classifier.apply(element);
            List<T> obj = result.computeIfAbsent(type, k -> new ArrayList<>());
            obj.add(element);
        }
        return result;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        //TODO Implement me
        return null;
    }
}