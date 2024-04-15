package org.personal.myList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class MyArrayListTests {

    // for now just testing with Integer
    private static MyList<Integer> testList;

    @BeforeAll
    static void initializeTests() {
        // since we're using the order feature, the add test will populate the list for the remove test
        testList = new MyArrayList<Integer>(10);
    }

    @Test
    @Order(10)
    void AddElementsTest() {
        // make sure testList was initialized
        assertNotNull(testList);

        // make sure testList is empty
        assertTrue(testList.isEmpty());

        // make sure we can't access parts of the list that haven't been allocated yet.
        try {
            testList.get(1);
            fail("MyArrayList should have thrown an index out of bounds exception even for valid indexes within the inner array");
        } catch (IndexOutOfBoundsException ioobe) {
            assertEquals(0, ioobe.getMessage().compareTo("Index 1 is outside the current bounds of the list"));
        }

        // add elements to the list
        for (int i = 0; i < 10; ++i) {
            assertTrue(testList.add(i));
        }

        // check the elements
        for (int i = 0; i < 10; ++i) {
            Integer element = testList.get(i);
            System.out.println(element);
            assertNotNull(element);
            assertEquals(i, element.intValue());
        }

        // check that the list resizes
        int newElement = 28;
        assertTrue(testList.add(28));
        Integer lastElement = testList.get(10);
        assertEquals(newElement, lastElement.intValue());
    }

    @Test
    @Order(20)
    void RemoveTest() {
        assertEquals(0,0);
    }
}