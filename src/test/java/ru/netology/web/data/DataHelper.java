package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    private static Faker faker = new Faker(new Locale("en"));

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    private static String generationRandomLogin() {
        return faker.name().username();
    }

    private static String generationRandomPassword() {
        return faker.internet().password();
    }

    public static AuthInfo getRandomUser() {
        return new AuthInfo(generationRandomLogin(), generationRandomPassword());
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode generationRandomVerificationCode() {
        return new VerificationCode(faker.numerify("#####"));
    }

}