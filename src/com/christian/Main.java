package com.christian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
        System.out.println("-----CONCAT STREAM--------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        System.out.println("------Collect Stream--------");
//        List<String> sortedGNumbers= bingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s->s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers= bingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add,ArrayList::addAll);

        for (String s: sortedGNumbers){
            System.out.println(s);
        }

        System.out.println("------------------------------");
        Employee emp1= new Employee("John Doe", 20);
        Employee emp2= new Employee("Mary Sue", 40);
        Employee emp3= new Employee("Bert Mack", 50);
        Employee emp4= new Employee("Sally Song", 25);
        Employee emp5= new Employee("Christian San", 30);

        Department hr= new Department("Human Resources");
        Department accounting= new Department("Accounting");

        hr.addEmployee(emp1);
        hr.addEmployee(emp2);
        hr.addEmployee(emp3);

        accounting.addEmployee(emp4);
        accounting.addEmployee(emp5);

        List<Department>departments= new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);


        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                    .forEach(System.out::println);

        //Group employees by age for all departments
        Map<Integer,List<Employee>> groupByAge=departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee-> employee.getAge()));

        System.out.println("GROUP BY AGE: "+groupByAge);


        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2)-> e1.getAge()<e2.getAge() ? e1:e2)
                .ifPresent(System.out::println);

        //Without terminal operation it will not execute
        Stream.of("ABC","AC","BAA","CCCC","XY","ST")
                .filter(s->{
                    System.out.println(s);
                    return s.length()==3;
                });


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
