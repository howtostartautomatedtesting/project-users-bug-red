package api;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import utils.UserCreator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * PATCH http://users.bugred.ru/tasks/rest/fullupdateuser
 */
public class UpdateUserInfo {

    private static final String UPDATE_USER_INFO_URL = "http://users.bugred.ru/tasks/rest/fullupdateuser";

    private String userName = UserCreator.getUserName();
    private String userEmail = UserCreator.getEmail();
    private String userPassword = UserCreator.getPassword();

    @BeforeGroups("newUser")
    public void createNewUser() {
        WebDriver driver = new ChromeDriver();
        new HomePage(driver).openPage()
                .clickButtonLogin()
                .fillFormRegistrationAndClickButtonRegistration(userName, userEmail, userPassword);
        driver.quit();
    }

    @DataProvider(name = "invalidGender")
    public Object[] dataProviderValidGender() {
        return new Object[]{"", "-", "male", "Ж"};
    }

    @Test(groups = "newUser", dataProvider = "invalidGender")
    public void testUpdateUserInfoWithInvalidGender(String gender) throws IOException, ParseException, URISyntaxException {
        String birthday = UserCreator.getRandomDate();
        String startDate = UserCreator.getRandomDate();
        String hobby = UserCreator.getHobby();
        String inn = UserCreator.getINN();

        String errorMessageInvalidGender = getErrorMessage(" Значение ", gender, " некорректное,должна быть либо m либо f");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPatch httpPatch = new HttpPatch(UPDATE_USER_INFO_URL);
        List<NameValuePair> params = getQueryParameters(userEmail, userName, gender, birthday, startDate, hobby, inn);
        URI uri = new URIBuilder(httpPatch.getURI()).addParameters(params).build();
        httpPatch.setURI(uri);

        CloseableHttpResponse responsePatch = httpClient.execute(httpPatch);
        HttpEntity entity = responsePatch.getEntity();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(EntityUtils.toString(entity));

        assertEquals(jsonObject.get("message").toString(), errorMessageInvalidGender);

    }

    private String getErrorMessage(String startPart, String parameters, String endPart) {
        return startPart.concat(parameters).concat(endPart);
    }

    private List<NameValuePair> getQueryParameters
            (String email, String username, String gender, String birthday, String startDate, String hobby, String inn) {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("hobby", hobby));
        params.add(new BasicNameValuePair("name", username));
        params.add(new BasicNameValuePair("name1", "Name"));
        params.add(new BasicNameValuePair("surname1", "Surname"));
        params.add(new BasicNameValuePair("fathername1", "Father name"));
        params.add(new BasicNameValuePair("cat", "Cat"));
        params.add(new BasicNameValuePair("dog", "Dog"));
        params.add(new BasicNameValuePair("parrot", "Parrot"));
        params.add(new BasicNameValuePair("cavy", "Cavy"));
        params.add(new BasicNameValuePair("hamster", "Hamster"));
        params.add(new BasicNameValuePair("squirrel", "Squirrel"));
        params.add(new BasicNameValuePair("phone", "Phone"));
        params.add(new BasicNameValuePair("inn", inn));
        params.add(new BasicNameValuePair("adres", "Address"));
        params.add(new BasicNameValuePair("gender", gender));
        params.add(new BasicNameValuePair("birthday", birthday));
        params.add(new BasicNameValuePair("date_start", startDate));
        return params;
    }
}