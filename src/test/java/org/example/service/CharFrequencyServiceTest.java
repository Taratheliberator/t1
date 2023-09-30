package org.example.service;

// CharFrequencyServiceTest.java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharFrequencyServiceTest {
    @Autowired
    private CharFrequencyService service;

    @Test
    public void testComputeFrequency() {
        String input = "aaaaabcccc";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 5);
        expected.put('c', 4);
        expected.put('b', 1);

        assertEquals(expected, service.computeFrequency(input));
    }

    @Test
    public void testEmptyString() {
        String input = "";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        assertEquals(expected, service.computeFrequency(input));
    }

    @Test
    public void testVariousAsciiChars() {
        String input = "!@#^&*()_+";
        Map<Character, Integer> expected = input.chars()
                .distinct()
                .boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        assertEquals(expected, service.computeFrequency(input));
    }

    @Test(expected = NullPointerException.class)
    public void testNullInput() {
        service.computeFrequency(null);
    }



}
