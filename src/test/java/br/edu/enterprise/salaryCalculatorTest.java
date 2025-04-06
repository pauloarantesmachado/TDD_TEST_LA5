package br.edu.enterprise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class salaryCalculatorTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarCalculoSalarioDesenvolvedor(String name, String email, Double baseSalary, RoleEnum roleEnum, Double expectedSalary) {
        Employees employees = new Employees(name, email, baseSalary, roleEnum);
        salaryCalculator cut = new salaryCalculator();
        Double finalSalary = cut.calculator(employees);
        Assertions.assertEquals(expectedSalary, finalSalary);
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, null, 0.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, RoleEnum.DEVELOPER, 900.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 4000.0, RoleEnum.DEVELOPER, 3200.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, RoleEnum.DEVELOPER, 2400.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, RoleEnum.DBA, 850.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 2000.0, RoleEnum.DBA, 1500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, RoleEnum.DBA, 2250.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, RoleEnum.TESTER, 850.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 2000.0, RoleEnum.TESTER, 1500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, RoleEnum.TESTER, 2250.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, RoleEnum.MANAGER, 800.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 5000.0, RoleEnum.MANAGER, 3500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 6000.0, RoleEnum.MANAGER, 4200.0)
        );
    }
}
