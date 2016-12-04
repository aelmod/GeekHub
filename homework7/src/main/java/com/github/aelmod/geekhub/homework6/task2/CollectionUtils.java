package com.github.aelmod.geekhub.homework6.task2;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

    private CollectionUtils() {
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
        for (E e : elements) {
            if (predicate.test(e)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E e : elements) {
            if (!predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for (E e : elements) {
            if (predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> res = new ArrayList<>();
        for (T element : elements) {
            res.add(mappingFunction.apply(element));
        }
        return res;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        return reduce(elements, (e, e2) -> comparator.compare(e, e2) < 0 ? e2 : e);
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        return reduce(elements, (e, e2) -> comparator.compare(e, e2) > 0 ? e2 : e);
    }

    public static <E> List<E> distinct(List<E> elements) {
        Set<E> set = new HashSet<>();
        for (E e : elements) {
            set.add(e);
        }
        return new ArrayList<>(set);
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E e : elements) {
            consumer.accept(e);
        }
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }
        E seed = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            seed = accumulator.apply(seed, elements.get(i));
        }
        return Optional.of(seed);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        for (E e : elements) {
            seed = accumulator.apply(seed, e);
        }
        return seed;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        return groupBy(elements, predicate::test);
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        HashMap<K, List<T>> res = new HashMap<>();
        for (T e : elements) {
            K key = classifier.apply(e);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(e);
        }
        return res;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {

        HashMap<K, List<U>> tempMap = new HashMap<>();
        for (T e : elements) {
            K key = keyFunction.apply(e);
            U value = valueFunction.apply(e);
            if (!tempMap.containsKey(key)) {
                tempMap.put(key, new ArrayList<U>());
            }
            tempMap.get(key).add(value);
        }

        HashMap<K, U> res = new HashMap<>();
        for (K k : tempMap.keySet()) {
            Optional<U> reduceRes = reduce(tempMap.get(k), mergeFunction);
            res.put(k, reduceRes.get());
        }
        return res;
    }
}