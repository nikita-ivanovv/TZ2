package org.example;

import org.example.App;
import org.junit.jupiter.api.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testGetMin() {
        //проверка работы GetMin
        List<BigInteger> numbers = Arrays.asList(new BigInteger("-54321"), new BigInteger("-46"),
                new BigInteger("6"), new BigInteger("12345123456789"));
        assertEquals(new BigInteger("-54321"), App.getMin(numbers));
        //проверка работы GetMin, если есть элемент-строка
        List<BigInteger> numbers2 = Arrays.asList(new BigInteger("-54321"), new BigInteger("word"));
        assertThrows(IllegalArgumentException.class, () -> App.getMin(numbers2));
    }
    @Test
    public void testGetMax() {
        //проверка работы GetMax
        List<BigInteger> numbers = Arrays.asList(new BigInteger("-54321"), new BigInteger("-46"),
                new BigInteger("6"), new BigInteger("12345123456789"));
        assertEquals(new BigInteger("12345123456789"), App.getMax(numbers));
    }
    @Test
    public void testGetSum() {
        //проверка работы GetSum
        List<BigInteger> numbers = Arrays.asList(new BigInteger("-54321"), new BigInteger("-46"),
                new BigInteger("6"), new BigInteger("12345123456789"));
        assertEquals(new BigInteger("12345123402428"), App.getSum(numbers));
    }
    @Test
    public void testGetMult() {
        //проверка работы GetMult
        List<BigInteger> numbers = Arrays.asList(new BigInteger("-543"), new BigInteger("-46"),
                new BigInteger("6"), new BigInteger("123456"));
        assertEquals(new BigInteger("18502103808"), App.getMult(numbers));
    }
    //генерация массива для проверки времени выполнения функций на нем
    private List<BigInteger> generateArray(int size) {
        List<BigInteger> testArr = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            testArr.add(BigInteger.valueOf(i+1));
        }
        return testArr;
    }
    @Test
    public void testGetMinTime() {
        //время выполнения GetMin
        for(int i = 100; i<=100000; i*=10) {
            List<BigInteger> numbers = generateArray(i);
            long start = System.nanoTime();
            App.getMin(numbers);
            long end = System.nanoTime();
            System.out.println("Время работы getMin для " + i + " элементов: " + (end - start) + " ns");
        }
    }
    @Test
    public void testGetMaxTime() {
        //время выполнения GetMax
        List<BigInteger> numbers = generateArray(100000);
        long start = System.nanoTime();
        App.getMax(numbers);
        long end = System.nanoTime();
        System.out.println("Время работы getMax: "  + (end - start) + " ns");
    }
    @Test
    public void testGetSumTime() {
        //время выполнения GetSum
        List<BigInteger> numbers = generateArray(100000);
        long start = System.nanoTime();
        App.getSum(numbers);
        long end = System.nanoTime();
        System.out.println("Время работы getSum: "  + (end - start) + " ns");
    }
    @Test
    public void testGetMultTime() {
        //время выполнения GetMult
        List<BigInteger> numbers = generateArray(100000);
        long start = System.nanoTime();
        App.getMult(numbers);
        long end = System.nanoTime();
        System.out.println("Время работы getMult: "  + (end - start) + " ns");
    }
    //обваливающийся тест
    @Timeout(value = 100000000, unit = TimeUnit.NANOSECONDS)@Test
    void timeTest() throws InterruptedException {
        Thread.sleep(100000000);
    }
}


