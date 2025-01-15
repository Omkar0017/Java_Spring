package com.in28min.programing;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));

    }

    private static void print(Integer integer){
        System.out.println(integer);
    }

    private static void printAllNumbersInListFunctional(List<Integer> integers) {
        integers.forEach(FP01Functional::print); // :: is method reference
    }
}
