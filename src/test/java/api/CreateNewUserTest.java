package api;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * POST http://users.bugred.ru/tasks/rest/doregister
 */
public class CreateNewUserTest {
    private final String userName = UserCreator.getUserName();
    private final String userEmail = UserCreator.getEmail();
    private final String userPassword = UserCreator.getPassword();
    private final String inCorrectEmail = "123mail.ru";

    @Test
    public void testCreateNewUserWithInCorrectEmail() throws IOException {
        HttpPost request = new HttpPost("http://users.bugred.ru/tasks/rest/doregister");
        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair("name", userName));
        authParams.add(new BasicNameValuePair("email", inCorrectEmail));
        authParams.add(new BasicNameValuePair("password", userPassword));
        request.setEntity(new UrlEncodedFormEntity(authParams));
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        String entity = EntityUtils.toString(response.getEntity());
        System.out.println(entity);
        Assert.assertTrue(entity.contains("\"message\":\" \\u041d\\u0435\\u043a\\u043e\\u0440" +
                "\\u0435\\u043a\\u0442\\u043d\\u044b\\u0439  email " + inCorrectEmail));


    }

}