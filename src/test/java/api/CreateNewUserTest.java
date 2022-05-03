package api;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    private final String exoectedMessageEmptyName = "поле фио является обязательным";


    @Test
    public void testCreateNewUserWithEmptyName() throws IOException, ParseException {
        HttpPost request = new HttpPost("http://users.bugred.ru/tasks/rest/doregister");
        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair("name", ""));
        authParams.add(new BasicNameValuePair("email", userEmail));
        authParams.add(new BasicNameValuePair("password", userPassword));
        request.setEntity(new UrlEncodedFormEntity(authParams));
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        String entity = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(entity);
        String message = jsonObject.get("message").toString();
        Assert.assertEquals(message, exoectedMessageEmptyName);
    }
}