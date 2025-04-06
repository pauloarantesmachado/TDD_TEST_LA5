package br.edu.person;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonDAO {
    private static final Pattern LETTER_PATTERN = Pattern.compile("^\\p{L}+$");

    protected List<String> isValidToInclude(Person person)
    {
        List<String> errors = new ArrayList<String>();
        if(!isValidName(person.getName())){
            errors.add("NAME INVALID");
        }
        if(!isValidAge(person.getAge())){
            errors.add("AGE INVALID");
        }

        if(!hasValidEmails(person.getEmail())){
            errors.add("EMAIL INVALID");
        }
        return errors;
    }

    public void save(Person person){
        if(!isValidToInclude(person).isEmpty()){
            for (String error : isValidToInclude(person)) {
                System.out.println(error);
            }
            throw  new RuntimeException("Error to register in DataBase");
        }
        // save in data Base
    }


    private Boolean isValidName(String name) {
        return name != null
                && hasAtLeastTwoValidParts(name.trim());
    }

    private boolean hasAtLeastTwoValidParts(String trimmedName) {
        if (trimmedName.isEmpty()) {
            return false;
        }

        String[] parts = trimmedName.split("\\s+");
        return parts.length >= 2
                && allPartsContainOnlyLetters(parts);
    }

    private boolean allPartsContainOnlyLetters(String[] parts) {
        for (String part : parts) {
            if (!LETTER_PATTERN.matcher(part).matches()) {
                return false;
            }
        }
        return true;
    }


    private Boolean isValidAge(int age) {
        return age >= 1 && age <= 200;
    }


    private Boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern emailPattern = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
        return emailPattern.matcher(email).matches();
    }


    private Boolean hasValidEmails(List<Email> emails) {
        if (emails == null || emails.isEmpty()) {
            return false;
        }
        for (Email email : emails) {
            if (!isValidEmail(email.getEmail())) {
                return false;
            }
        }
        return true;
    }

}
