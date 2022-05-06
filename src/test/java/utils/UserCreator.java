package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserCreator {
    private static String randomString = RandomStringUtils.randomAlphabetic(8);
    private static String userName = randomString;
    private static String email = randomString + "@gmail.com";
    private static String password = randomString;

    public static String getUserName() {
        return userName;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getHobby() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static String getINN() {
        return RandomStringUtils.randomNumeric(12);
    }

    public static String getRandomDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate randDate = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        return dateFormat.format(randDate);
    }
}
