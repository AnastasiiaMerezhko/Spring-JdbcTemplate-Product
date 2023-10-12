package org.example.app.utils.Validator;

public class IdValidator {

    private final static String ID_RGX = "[0-9]+";

    public static boolean isIdValid(String id) {
        return id.isEmpty() || !id.matches(ID_RGX);
    }
}
