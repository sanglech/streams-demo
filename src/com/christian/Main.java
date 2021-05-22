package com.christian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code her
        List<String> bingoNumbers= Arrays.asList(
                "N40","N36",
                "B12","B6",
                "G53","G49","G60","G50","g45",
                "I26","I17","I29",
                "O71");
        bingoNumbers.stream()
                .map(String::toUpperCase)// same as s-> s.toUpperCase()
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        
        
        Stream<String> ioNumberStream= Stream.of("I26","I17","I29","071");
        Stream<String> inNumberStream= Stream.of("N40","N36","I26","I17","I29","071");
        Stream<String> concatStream = Stream.concat(ioNumberStream,inNumberStream);
        System.out.println("-------------");

        System.out.println(concatStream
                .distinct().
                peek(System.out::println)
                .count());

//        List<String>gNumbers=new ArrayList<>();
//
//        //Print G numbers
//        bingoNumbers.forEach(number->{
//            if(number.toUpperCase().startsWith("G")){
//                gNumbers.add(number);
//                //System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1,String s2)->s1.compareTo(s2));
//        gNumbers.forEach((String s)-> System.out.println(s));
    }
}
