package com.functional_interface.StreamHomeWork;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManService {

    private LinkedList<Man> manList = new LinkedList<>(Arrays.asList(
            new Man("Vasyl", "Kovbasa", 23, 0,
                    new Address("Ukraine", "Lvov", "Abrykosova")),
            new Man("Ganz", "Schtreibrecher", 31, 1,
                    new Address("Germany", "Koln", "Bismarck")),
            new Man("Marek", "Gusakivskiy", 27, 5,
                    new Address("Poland", "Krakov", "Pilsutskogo")),
            new Man("John", "Smith", 43, 2,
                    new Address("USA", "New-York", "5-th ave")),
            new Man("Vasyl", "Salo", 27, 2,
                    new Address("Ukraine", "Ternopil", "Slyvova")),
            new Man("Moisey", "Perelman", 54, 5,
                    new Address("USA", "Los-Angeles", "15-th ave")),
            new Man("Ganz", "Shulberg", 43, 0,
                    new Address("Austria", "Vienna", "Central"))
    ));

    public void selectAllMen() {
        manList.forEach(System.out::println);
    }

    public void selectAllAddresses() {
        manList.stream().map(Man::getAddress).collect(Collectors.toList()).forEach(System.out::println);
    }

    public void selectAllMenFirstLastChKidWhereAgeOver(int value) {
        Predicate<Man> predicate = m -> m.getAge() >= value;
        manList.stream()
                .filter(predicate)
                .collect(Collectors.toList())
                .forEach(man -> System.out.println(man.getFirstName() +
                                " " + man.getLastName() +
                                " " + man.getKids()
                        )
                );
    }

    public void updateManFirstLastNamesKindsWhereCountryIs(String country, String firstName, String lastName, int kids) {

        Predicate<Man> predicate = man -> man.getAddress().getCountry().equals(country);
        manList.stream().filter(predicate).forEach(man -> {
                    man.setFirstName(firstName);
                    man.setLastName(lastName);
                    man.setKids(kids);
                }
        );

        manList.stream().filter(predicate).forEach(System.out::println);
    }

    public void selectManFirstNLastNStreetWhereCountryAndStreetOrAge(String country, String street, int age) {
        Predicate<Man> predicateCountry = man -> man.getAddress().getCountry().equals(country);
        Predicate<Man> predicateStreet = man -> man.getAddress().getStreet().equals(street);
        Predicate<Man> predicateAge = man -> man.getAge() >= age;

        manList.stream().filter(predicateCountry.and(predicateStreet).or(predicateAge)).forEach(man ->
                System.out.println(man.getFirstName() +
                        " " + man.getLastName() +
                        " " + man.getAddress().getStreet()
                )
        );
    }

    public void selectAllMenGroupByKinds() {
        Map<Integer, Long> map = manList.stream().collect(Collectors.groupingBy(Man::getKids, Collectors.counting()));
        System.out.println(map);
    }


    public void selectAllMenGroupByKindsAndAge() {
        Map<Integer, Long> map = manList.stream().collect(Collectors.groupingBy(Man::getKids,
                Collectors.mapping(Man::getAge, Collectors.counting()))
        );
        System.out.println(map);
    }


}
