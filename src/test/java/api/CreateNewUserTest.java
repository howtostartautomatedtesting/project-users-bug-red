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


    @Test
    public void testCreateNewUserWithEmptyName() throws IOException {
        HttpPost request = new HttpPost("http://users.bugred.ru/tasks/rest/doregister");
        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair("name", ""));
        authParams.add(new BasicNameValuePair("email", userEmail));
        authParams.add(new BasicNameValuePair("password", userPassword));
        request.setEntity(new UrlEncodedFormEntity(authParams));
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        String entity = EntityUtils.toString(response.getEntity());
        Assert.assertTrue(entity.contains("\"message\":\"\\u043f\\u043e\\u043b\\u0435 \\u0444\\u0438\\u043e \\u044f" +
                "\\u0432\\u043b\\u044f\\u0435\\u0442\\u0441\\u044f \\u043e\\u0431\\u044f\\u0437\\u0430\\u0442" +
                "\\u0435\\u043b\\u044c\\u043d\\u044b\\u043c\""));
    }
}