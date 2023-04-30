package com.melong.super_builder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class Person {
    private String name;
    private int age;
}
