package com.github.aelmod.geekhub.homework6.task2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;


/**
 * Created by aelmod-notebook on 04.12.2016.
 */
@Test
public class CollectionUtilsTest {
    LinkedList<Integer> linkedList;
    public static final Integer TEST_DATA = 1337;

    @BeforeMethod
    public void before() {
        linkedList = new LinkedList<>();
    }

    public void filterTest() {
        linkedList.add(TEST_DATA);
        List<Integer> filter = CollectionUtils.filter(linkedList, integer -> integer > 6);
        assertEquals(filter.get(0), TEST_DATA);
    }

    public void reduceWith2Params1() {
        linkedList.add(TEST_DATA);
        linkedList.add(228);
        Optional<Integer> reduce = CollectionUtils.reduce(linkedList, (o1, o2) -> o1 > o2 ? o1 : o2);
        assertEquals(reduce.get(), TEST_DATA);
    }

    public void reduceWith2Params2() {
        Optional<Integer> reduce = CollectionUtils.reduce(linkedList, (o1, o2) -> o1 > o2 ? o1 : o2);
        assertFalse(reduce.isPresent());
    }

    public void reduceWith3Params1() {
        linkedList.add(TEST_DATA);
        linkedList.add(2);
        linkedList.add(1);
        Integer reduce = CollectionUtils.reduce(1, linkedList, (o1, o2) -> o1 * o2);
        assertEquals(reduce, new Integer(TEST_DATA * 2));
    }

    public void reduceWith3Params2() {
        Integer reduce = CollectionUtils.reduce(1, linkedList, (o1, o2) -> o1 * o2);
        assertEquals(reduce, new Integer(1));
    }

    public void allMatchTest1() {
        linkedList.add(TEST_DATA);
        linkedList.add(228);
        boolean isAllMatch = CollectionUtils.allMatch(linkedList, integer -> integer > 5);
        assertTrue(isAllMatch);
    }

    public void allMatchTest2() {
        linkedList.add(TEST_DATA);
        linkedList.add(228);
        linkedList.add(3);
        boolean isAllMatch = CollectionUtils.allMatch(linkedList, integer -> integer > 5);
        assertFalse(isAllMatch);
    }

    public void anyMatchTest1() {
        linkedList.add(TEST_DATA);
        linkedList.add(3);
        boolean isAnyMatch = CollectionUtils.anyMatch(linkedList, integer -> integer > 5);
        assertTrue(isAnyMatch);
    }

    public void anyMatchTest2() {
        linkedList.add(3);
        boolean isAnyMatch = CollectionUtils.anyMatch(linkedList, integer -> integer > 5);
        assertFalse(isAnyMatch);
    }

    public void noneMatchTest1() {
        linkedList.add(TEST_DATA);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(55);
        boolean isNoneMatch = CollectionUtils.noneMatch(linkedList, integer -> Objects.equals(integer, TEST_DATA));
        assertFalse(isNoneMatch);
    }

    public void noneMatchTest2() {
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(55);
        boolean isNoneMatch = CollectionUtils.noneMatch(linkedList, integer -> Objects.equals(integer, TEST_DATA));
        assertTrue(isNoneMatch);
    }

    public void distinctTest() {
        linkedList.add(11);
        linkedList.add(TEST_DATA);
        linkedList.add(TEST_DATA);
        linkedList.add(11);
        linkedList.add(88);
        linkedList.add(88);
        List<Integer> distinct = CollectionUtils.distinct(linkedList);
        assertEquals(distinct.size(), 3);
    }

    public void forEachTest() {
        linkedList.add(11);
        linkedList.add(TEST_DATA);
        linkedList.add(TEST_DATA);
        linkedList.add(11);
        linkedList.add(88);
        linkedList.add(88);

        List<Integer> listMock = new ArrayList<>();
        CollectionUtils.forEach(linkedList, listMock::add);

        assertEquals(linkedList.size(), listMock.size());

        for (int i = 0; i < linkedList.size(); i++) {
            assertEquals(linkedList.get(i), listMock.get(i));
        }
    }

    public void minTest1() {
        linkedList.add(TEST_DATA);
        linkedList.add(555);
        linkedList.add(3);
        linkedList.add(11);
        linkedList.add(8);
        Optional<Integer> min = CollectionUtils.min(linkedList, Integer::compareTo);
        assertTrue(min.isPresent());
        assertEquals(min.get(), new Integer(3));
    }

    public void minTest2() {
        Optional<Integer> min = CollectionUtils.min(linkedList, Integer::compareTo);
        assertFalse(min.isPresent());
    }

    public void maxTest1() {
        linkedList.add(555);
        linkedList.add(3);
        linkedList.add(TEST_DATA);
        linkedList.add(11);
        linkedList.add(8);
        Optional<Integer> max = CollectionUtils.max(linkedList, Integer::compareTo);
        assertTrue(max.isPresent());
        assertEquals(max.get(), TEST_DATA);
    }

    public void maxTest2() {
        Optional<Integer> max = CollectionUtils.max(linkedList, Integer::compareTo);
        assertFalse(max.isPresent());
    }

    public void mapTest() {
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        List<Integer> res = CollectionUtils.map(linkedList, e -> e * 5);
        assertEquals(res.size(), linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            assertEquals(res.get(i), new Integer(linkedList.get(i) * 5));
        }

    }

    public void groupByTest() {
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }
        Map<Integer, List<Integer>> res = CollectionUtils.groupBy(linkedList, integer -> integer % 3);
        assertEquals(res.size(), 3);
        assertEquals(res.get(0).size(), 334);
        assertEquals(res.get(1).size(), 333);
        assertEquals(res.get(2).size(), 333);
    }

    public void partitionByTest() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        Map<Boolean, List<Integer>> res = CollectionUtils.partitionBy(linkedList, integer -> integer % 3 == 0);
        assertEquals(res.size(), 2);
        assertEquals(res.get(true).size(), 4);
        assertEquals(res.get(false).size(), 6);
    }

    public void toMapTest() {
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        Map<Integer, Integer> res = CollectionUtils.toMap(linkedList, e -> e % 3, e -> e + 2, (e, e2) -> e + e2);
        assertEquals(res.size(), 3);
        assertEquals(res.get(0), new Integer(26));
        assertEquals(res.get(1), new Integer(18));
        assertEquals(res.get(2), new Integer(21));
    }
}
