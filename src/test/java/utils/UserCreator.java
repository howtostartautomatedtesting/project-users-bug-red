package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class UserCreator {
/*
    private static String randomString = RandomStringUtils.randomAlphabetic(8);
    private static String userName=randomString;
    private static String email=randomString+"@gmail.com";
    private static String password=randomString;
*/

    public static String getUserName(){
        return RandomStringUtils.randomAlphabetic(8);
    }
    public static String getEmail(){
        return RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
    }
    public static String getPassword(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}
