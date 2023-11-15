package com.pluralsight;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FixedList<Integer> numbers = new FixedList<>(3);
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        numbers.add(43); // this line should fail
        System.out.println(numbers.getItems());
        System.out.println("Numbers size should be 3: "+numbers.getItems().size());

        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());
        dates.add(LocalDate.ofEpochDay(15)); // this line should fail
        System.out.println(dates.getItems());
        System.out.println("Dates size should be 2: "+dates.getItems().size());

        FixedList<String> text = new FixedList<>(1);
        text.add("hi again");
        text.add(LocalDate.now().toString()); // this line should fail
        System.out.println(text.getItems());
        System.out.println("Text size should be 1: "+text.getItems().size());

        FixedList<Character> letters = new FixedList<>(0);
        letters.add('h'); // this line should fail
        System.out.println(letters.getItems());
        System.out.println("Letters size should be 0: "+letters.getItems().size());

    }
}
