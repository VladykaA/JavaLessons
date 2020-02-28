package com.functional_interface;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearnStream {
    public static void main(String[] args) {
        List<Man> men = Arrays.asList(
                new Man(23, "John"),
                new Man(10, "Jack"),
                new Man(23, "John"),
                new Man(14, "Ahmed")
        );

        Predicate<Man> predicate = m -> m.getAge() < 20;
        Predicate<Man> predicate1 = m -> m.getName().equals("Jack");

        List<Man> men1 = men
                .stream()
                .filter(predicate.or(predicate1))
                .collect(Collectors.toList());

        Stream<Man> manStream = men
                .stream()
                .filter(predicate.and(predicate1));

//        manStream.forEach(m -> System.out.println(m.getName()));

  /*      System.out.println(manStream.allMatch(m -> m.getAge() > 5));
        System.out.println(manStream.anyMatch(m -> m.getAge() > 5));*/

        Map<Integer, List<Man>> map =
                men.stream().collect(Collectors.groupingBy(m -> m.getAge() % 2));

//        System.out.println();

        class ForStream {
            private int age;
            private String name;

            public ForStream(int age, String name) {
                this.age = age;
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                ForStream forStream = (ForStream) o;
                return age == forStream.age &&
                        Objects.equals(name, forStream.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(age, name);
            }
        }

        Map<ForStream, Long> collect = men.stream()
                .collect(Collectors.groupingBy(
                        m -> new ForStream(m.getAge(), m.getName()), Collectors.counting()));

     /*   Map<AbstractMap.SimpleEntry<City, String>, Long> collect = people.stream()
                .map(Man::getAddress)
                .collect(Collectors.groupingBy(
                        a -> new AbstractMap.SimpleEntry<>(a.getCity(), a.getStreet()), Collectors.counting()));*/

//        System.out.println();
        
//                men.stream().map(m -> new Person(m.getAge(), m.getName())).filter(p -> p.getAge() > 20);

        Comparator<Man> comparator = Comparator.comparingInt(Man::getAge);

        Comparator<Man> manComparator = (m1, m2) -> Integer.compare(m1.getName().length(), m2.getName().length());

        men.stream().sorted(comparator.thenComparing(manComparator)).forEach(System.out::println);

    }
}

class Man {
    private int age;
    private String name;

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


