package org.example;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //программа считывает название файла с указанием расширения
        String name = br.readLine();
        List<BigInteger> numbers = new ArrayList<>();
        //программа считывает числа из файла
        BufferedReader read = new BufferedReader(new FileReader(name));
        String s = read.readLine();
        String[] nums = s.split(" ");
        for (String num : nums) {
            numbers.add(new BigInteger(num));
        }
        System.out.println(getMin(numbers));
        System.out.println(getMax(numbers));
        System.out.println(getSum(numbers));
        System.out.println(getMult(numbers));
    }
    public static BigInteger getMin(List<BigInteger> numbers) {
        BigInteger mn = numbers.get(0);
        for (BigInteger num : numbers) {
            if(num.compareTo(mn) < 0) {
                mn = num;
            }
        }
        return mn;
    }
    public static BigInteger getMax(List<BigInteger> numbers) {
        BigInteger mx = numbers.get(0);
        for (BigInteger num : numbers) {
            if(num.compareTo(mx) > 0) {
                mx = num;
            }
        }
        return mx;
    }

    public static BigInteger getSum(List<BigInteger> numbers) {
        BigInteger sm = new BigInteger("0");
        for (BigInteger num : numbers){
            sm = sm.add(num);
        }
        return sm;
    }
    public static BigInteger getMult(List<BigInteger> numbers) {
        BigInteger mult = new BigInteger("1");
        for (BigInteger num : numbers){
            mult = mult.multiply(num);
        }
        return mult;
    }
}
