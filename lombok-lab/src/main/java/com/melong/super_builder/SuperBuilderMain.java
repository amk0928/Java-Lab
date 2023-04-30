package com.melong.super_builder;

import com.melong.super_builder.model.Person;
import com.melong.super_builder.model.Programmer;

public class SuperBuilderMain {
    public static void main(String[] args) {
        Person person = Person.builder().name("melong").age(30).build();

        Programmer programmer = Programmer.builder().major("backend").build();

    }
}
