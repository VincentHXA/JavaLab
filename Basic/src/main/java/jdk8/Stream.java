package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "jkl");

        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println("空字符串数量为： " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("长度3的字符串数量为： " + count);

        List<String> fileted = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("非空列表：" + fileted);

        String merged = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + merged);

        List<Integer> nums = Arrays.asList(3, 2, 2, 5, 54, 123, 6);

        List<Integer> squared = nums.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("平方列表: " + squared);
    }
}
