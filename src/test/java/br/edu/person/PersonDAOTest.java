package br.edu.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PersonDAOTest {

    PersonDAO personDAO = new PersonDAO();

    @ParameterizedTest
    @MethodSource("provideInputToCorrectCase")
    void isValidToInclude_WhenDataIsCorrect_ShouldEmptyList(int id,String name, int age, int idEmail, String email)
    {
        Person person = new Person(id,name,age,List.of(new Email(idEmail,email)));
        List<String> listError = personDAO.isValidToInclude(person);
        Assertions.assertTrue(listError.isEmpty());
        Assertions.assertDoesNotThrow(() -> personDAO.save(person));
    }

    private static Stream<Arguments> provideInputToCorrectCase() {
        return Stream.of(
                Arguments.of(1,"Jon Kennedy",30,1,"nome1@lp2.com"),
                Arguments.of(2, "Maria Silva", 10, 5, "nome5@lp2.com"),
                Arguments.of(3, "Carlos Souza", 20, 6, "nome6@lp2.com"),
                Arguments.of(4, "João Santos", 151, 7, "nome7@lp2.com")

        );
    }

    @ParameterizedTest
    @MethodSource("provideInputToCorrectCaseError")
    void isValidToInclude_WhenDataIsNotCorrect_ShouldReturnEmptyList(int id,String name, int age, Integer idEmail, String email)
    {
        Person person = new Person(id,name,age,List.of(new Email(idEmail,email)));
        Assertions.assertThrows(RuntimeException.class,() -> personDAO.save(person));
    }

    private static Stream<Arguments> provideInputToCorrectCaseError() {
        return Stream.of(
                Arguments.of(1,"Jon",202,null,null),
                Arguments.of(1,null,202,null,null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputToNotCorrectCaseName")
    void isValidToInclude_WhenNameIsNotCorrect_ShouldReturnListWithErrorName(int id,String name, int age, int idEmail, String email)
    {
        Person person = new Person(id,name,age,List.of(new Email(idEmail,email)));
        List<String> listError = personDAO.isValidToInclude(person);
        String valueError = listError.get(0);

        Assertions.assertFalse(listError.isEmpty());
        Assertions.assertEquals("NAME INVALID",valueError);

    }

    private static Stream<Arguments> provideInputToNotCorrectCaseName() {
        return Stream.of(
                Arguments.of(1,"Jon_Kennedy",30,1,"nome1@lp2.com"),
                Arguments.of(2, "Maria ", 10, 5, "nome5@lp2.com"),
                Arguments.of(3, "Carlos Souza1", 20, 6, "nome6@lp2.com"),
                Arguments.of(4, "João S@ntos", 151, 7, "nome7@lp2.com"),
                Arguments.of(5, "JoãoSantos", 151, 7, "nome7@lp2.com"),
                Arguments.of(6, "Joy", 151, 7, "nome7@lp2.com"),
                Arguments.of(6, "", 151, 7, "nome7@lp2.com")

        );
    }

    @ParameterizedTest
    @MethodSource("provideInputToNotCorrectCaseAge")
    void isValidToInclude_WhenAgeIsNotCorrect_ShouldReturnListWithErrorAge(int id,String name, int age, int idEmail, String email)
    {
        Person person = new Person(id,name,age,List.of(new Email(idEmail,email)));
        List<String> listError = personDAO.isValidToInclude(person);
        String valueError = listError.get(0);

        Assertions.assertFalse(listError.isEmpty());
        Assertions.assertEquals("AGE INVALID",valueError);
    }

    private static Stream<Arguments> provideInputToNotCorrectCaseAge() {
        return Stream.of(
                Arguments.of(1,"Jon Kennedy",0,1,"nome1@lp2.com"),
                Arguments.of(2, "Maria Silva",-1, 5, "nome5@lp2.com"),
                Arguments.of(3, "Carlos Souza", 201, 6, "nome6@lp2.com")
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputToNotCorrectCaseEmail")
    void isValidToInclude_WhenEmailIsNotCorrect_ShouldReturnListWithErrorEmail(int id,String name, int age, Integer idEmail, String email){
        Person person = new Person(id,name,age,List.of(new Email(idEmail,email)));
        Person person2 = new Person(id,name,age,null);
        Person person3 = new Person(id,name,age,new ArrayList<>());
        List<String> listError = personDAO.isValidToInclude(person);
        List<String> listError2 = personDAO.isValidToInclude(person2);
        List<String> listError3 = personDAO.isValidToInclude(person3);

        String valueError = listError.get(0);
        String valueError2 = listError2.get(0);
        String valueError3 = listError3.get(0);

        Assertions.assertFalse(listError.isEmpty());
        Assertions.assertFalse(listError2.isEmpty());
        Assertions.assertEquals("EMAIL INVALID",valueError);
        Assertions.assertEquals("EMAIL INVALID",valueError2);
        Assertions.assertEquals("EMAIL INVALID",valueError3);

    }

    private static Stream<Arguments> provideInputToNotCorrectCaseEmail() {
        return Stream.of(
                Arguments.of(1,"Jon Kennedy",30,null,null),
                Arguments.of(2, "Maria Silva", 10, 5, "nome@lp2,com"),
                Arguments.of(3, "Maria Silva", 10, 5, "nomelp2com"),
                Arguments.of(3, "Maria Silva", 10, 5, "nomelp 2com"),
                Arguments.of(3, "Maria Silva", 10, 5, "")
        );
    }

}
