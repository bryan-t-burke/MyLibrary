package org.personal.myMap;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyHashMapTests {

    @Test
    void PerformanceTest() {
        Map<Integer, String> map = new HashMap<>();
        Instant addMapStart = Instant.now();
        for (int i = 0; i < 1000000; ++i) {
            map.put(i, String.valueOf(i));
        }
        Instant addMapEnd = Instant.now();

        MyMap<Integer, String> myMap = new MyHashMap<>();
        Instant addMyMapStart = Instant.now();
        for (int i = 0; i < 1000000; ++i) {
            myMap.put(i, String.valueOf(i));
        }
        Instant addMyMapEnd = Instant.now();

        long addMapDuration = addMapEnd.toEpochMilli() - addMapStart.toEpochMilli();
        long addMyMapDuration = addMyMapEnd.toEpochMilli() - addMyMapStart.toEpochMilli();
        // expectation is that myMap will be slower, but if it's not then that won't hurt the asserts
        long addTolerance = addMyMapDuration - addMapDuration;
        assertTrue(addTolerance < 200, "addTolerance: " + addTolerance);


        Instant queryMapStart = Instant.now();
        for (int i = 0; i < 1000000; ++i) {
            map.containsKey(i);
        }
        Instant queryMapEnd = Instant.now();

        Instant queryMyMapStart = Instant.now();
        for (int i = 0; i < 1000000; ++i) {
            myMap.containsKey(i);
        }
        Instant queryMyMapEnd = Instant.now();

        long queryMapDuration = queryMapEnd.toEpochMilli() - queryMapStart.toEpochMilli();
        long queryMyMapDuration = queryMyMapEnd.toEpochMilli() - queryMyMapStart.toEpochMilli();
        // expectation is that myMap will be slower, but if it's not then that won't hurt the asserts
        long queryTolerance = queryMyMapDuration - queryMapDuration;
        System.out.println("queryTolerance: " + queryTolerance);
        assertTrue(queryTolerance < 10, "tolerance: " + queryTolerance);
    }
}
