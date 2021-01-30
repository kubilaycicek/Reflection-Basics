package com.kubilaycicek.model;

public class Person {
    private String name;

    private static int numberOfPeople = 0;

    public Person(String name){
        this.name=name;
        numberOfPeople++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printPerson(Person person) {
        System.out.println(person.getName());
    }
}
