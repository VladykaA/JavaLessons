package com.functional_interface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LearnFI {
    public static void main(String[] args) {
        /*Calculatable c = new Calculatable() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };*/

        Calculatable c1 = (a, b) -> a + b;
        c1 = (a, b) -> a + b + 1;

        print((a, b) -> a + b + 1);

        Convertable<String, Integer> convertable = s -> Integer.parseInt(s);

        convertable.convert("45");
    }

    public static void print(Calculatable calculatable) {

    }
}

class CommonFI {
    public static void main(String[] args) {
        Function<String, Integer> function = s -> Integer.parseInt(s);

        Consumer<String> consumer = s -> System.out.println(s);

        Supplier<Integer> supplier = () -> 5;

        Conv conv = new Conv() {
            @Override
            public void convert(int value) {

            }
        };

        Conv conv1 = value -> {

        };

    }
}

@FunctionalInterface
interface Calculatable {
    public abstract int sum(int a, int b);

    default void print() {
        System.out.println("Hello");
    }

    static void foo() {
        System.out.println("World");
    }

}

@FunctionalInterface
interface Convertable<T, F> {
    F convert(T value);
}

interface Conv {
    void convert(int value);
}
