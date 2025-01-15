package com.in28min.programing;

import java.util.List;

import static com.in28min.programing.FP01Structure.BreakPattern;

public class FP01Excercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring","Spring boot","API","Microservices",
                "AWS","PCF","Azure","Docker","Kubernetes");
        System.out.println("Print only Odd Numbers");
        exercise01(numbers);
        System.out.println(BreakPattern);
        System.out.println("Print Courses Individually");
        exercise02(courses);
        System.out.println(BreakPattern);
        System.out.println("Print course containing Spring");
        exercise03(courses);
        System.out.println(BreakPattern);
        System.out.println("Print Course containing more than 4 letters");
        exercise04(courses);
        System.out.println(BreakPattern);




    }

    private static void exercise04(List<String> courses) {
        courses.stream().filter(course -> course.length()>=4).
                forEach(System.out::println);
    }

    private static void exercise03(List<String> courses) {
        courses.stream().filter(course -> course.contains("Spring")).
                forEach(System.out::println);
    }

    private static void exercise02(List<String> courses) {
        courses.forEach(System.out::println);
    }

    private  static  void exercise01(List<Integer> integers){
        integers.stream().filter(integer -> integer%2 !=0)
                .forEach(System.out::println);
    }
}


