package br.edu.enterprise;

public class salaryCalculator {

    public Double calculator(Employees employees) {
        Double basicSalary = employees.getBasicSalary();
        if (employees.getRole() == null)
            return 0.0;

        RoleEnum role = employees.getRole();
        return basicSalary * (basicSalary >= role.getLimit() ? role.getRateSuperior() : role.getLowerRate());
    }
}
