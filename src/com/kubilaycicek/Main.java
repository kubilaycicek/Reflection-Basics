package com.kubilaycicek;

import com.kubilaycicek.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        /*
         If you are using smoething that is inherited, replace..

            getDeclaredField -> getField
            getDeclaredMethod -> getMethod
         */

        Person person = new Person("Kubilay");
        //System.out.println(p.name); //Error, not accessible

        try {
            Field field = person.getClass().getDeclaredField("name");
            field.setAccessible(true);
            System.out.println(field.get(person));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        /*
        ...
         */

        // System.out.println(Person.numberOfPeople); //Error, not accessible

        try {
            Field field = Person.class.getDeclaredField("numberOfPeople");
            field.setAccessible(true);
            System.out.println(field.get(null));


        } catch (Exception exception) {
            exception.printStackTrace();
        }

        /*
         ...
         */

        System.out.println(person.getName());
        try {
            Method method = person.getClass().getMethod("getName");
            System.out.println(method.invoke(person));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        /*
         ...
         */

        person.setName("Kubilay93");
        System.out.println(person.getName());

        try {
            Method method = person.getClass().getDeclaredMethod("setName", String.class);
            method.invoke(person, "Kubilay93");
            System.out.println(person.getName());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        /*
         ...
         */

        Person.printPerson(person);
        try {
            Method method = person.getClass().getDeclaredMethod("printPerson", Person.class);
            method.invoke(null, person);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Person other = new Person("Jhon");
        Person.printPerson(other);
        try{
            Constructor<Person> personConstructor = Person.class.getDeclaredConstructor(String.class);
            other=personConstructor.newInstance("Jhon");
            Person.printPerson(other);

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }
}
