import org.apache.commons.lang3.RandomStringUtils;

public class CreatorNewUsers {
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
}
