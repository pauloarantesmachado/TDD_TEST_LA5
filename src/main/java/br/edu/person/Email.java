package br.edu.person;

import lombok.Getter;

@Getter
public class Email {
    private Integer id;
    private String email;

    public Email(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

}
