package br.edu.enterprise;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class Employees {
    private String name;
    private String email;
    @Getter
    private Double BasicSalary;
    @Getter
    private RoleEnum role;
}
