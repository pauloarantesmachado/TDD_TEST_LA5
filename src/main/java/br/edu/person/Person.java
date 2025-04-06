package br.edu.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> email;
}
