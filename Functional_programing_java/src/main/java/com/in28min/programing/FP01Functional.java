package com.in28min.programing;

import java.util.List;

import static com.in28min.programing.FP01Structure.BreakPattern;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListFunctional(numbers);
        System.out.println(BreakPattern);
        printEvenNumbersInListFunctional(numbers);
        System.out.println(BreakPattern);
        printOddNumberInListFunctional(numbers);


    }

    private static void printOddNumberInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(integer -> integer%2 != 0)
                .forEach(System.out::println);
    }

    private static boolean isEven(int number){
        return number%2 ==0;
    }
    private static void printEvenNumbersInListFunctional(List<Integer> integers) {

//        integers.stream().filter(FP01Functional::isEven)
//                .forEach(System.out::println);
        integers.stream().filter(integer -> integer%2==0)
                .forEach(System.out::println);
    }

//    private static void print(Integer integer){
//        System.out.println(integer);
//    }

    private static void printAllNumbersInListFunctional(List<Integer> integers) {
//        integers.forEach(FP01Functional::print); // :: is method reference
        integers.forEach(System.out::println);
    }

}
