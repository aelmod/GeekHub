package com.github.aelmod.geekhub.homework6.task1;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Євгеній on 04.12.2016.
 */
@Test
public class LinkedListImplTest {
    public static final Long TEST_DATA = 1337L;
    LinkedListImpl<Long> linkedList;

    @BeforeMethod
    public void before() {
        linkedList = new LinkedListImpl<>();
    }


    public void size0Test() {
        assertEquals(linkedList.size(), 0);
    }


    public void size1AndAddTest() {
        linkedList.add(TEST_DATA);
        assertEquals(linkedList.size(), 1);
    }


    public void size10AndAddTest() {
        for (int i = 0; i < 10; i++) {
            linkedList.add((long) i);
        }
        assertEquals(linkedList.size(), 10);
        assertEquals(linkedList.get(0), new Long(0));
        assertEquals(linkedList.get(9), new Long(9));
    }


    public void deleteByValueTest() {
        linkedList.add(TEST_DATA);
        assertEquals(linkedList.size(), 1);
        assertTrue(linkedList.delete(TEST_DATA));
        assertTrue(linkedList.isEmpty());
        assertEquals(linkedList.size(), 0);
        assertFalse(linkedList.delete(TEST_DATA));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void deleteByIndexFailedTest1() {
        linkedList.delete(0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void deleteByIndexFailedTest2() {
        linkedList.delete(1);
    }


    public void getTest() {
        linkedList.add(TEST_DATA);
        assertEquals(linkedList.get(0), TEST_DATA);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void getFailedTest() {
        linkedList.get(0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void getFailedTest2() {
        linkedList.add(TEST_DATA);
        linkedList.get(1);
    }


    public void isEmptyTest() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(TEST_DATA);
        assertFalse(linkedList.isEmpty());
        linkedList.delete(0);
        assertTrue(linkedList.isEmpty());
    }


    public void clearTest() {
        assertEquals(linkedList.clean(), 0);
        linkedList.add(TEST_DATA);
        assertEquals(linkedList.clean(), 1);
        assertTrue(linkedList.isEmpty());
        assertEquals(linkedList.size(), 0);
    }


    public void containsTest() {
        linkedList.add(TEST_DATA);
        assertTrue(linkedList.contains(TEST_DATA));
        assertFalse(linkedList.contains(222L));
    }
}
