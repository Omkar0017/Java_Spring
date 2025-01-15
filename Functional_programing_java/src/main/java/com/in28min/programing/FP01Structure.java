package com.in28min.programing;

import java.util.List;

public class FP01Structure {

    public static final String BreakPattern = "************************";

    public static void main(String[] args) {
        List<Integer> integerList = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInListStructure(integerList);
        System.out.println(BreakPattern);
        printEvenNumbersInListStructure(integerList);
        System.out.println(BreakPattern);
        printOddNumbersInListStructure(integerList);

    }

    private static void printOddNumbersInListStructure(List<Integer> integerList) {
        for(int number:integerList){
            if(number%2 != 0){
                System.out.println(number);
            }
        }
    }

    private static void printEvenNumbersInListStructure(List<Integer> integers) {
        for(int i:integers){
            if(i%2 ==0){
                System.out.println(i);
            }
        }
    }

    private static void printAllNumbersInListStructure(List<Integer> integers) {
        for(int interger:integers){
            System.out.println(interger);
        }
    }
}
