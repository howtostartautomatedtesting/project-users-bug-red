package api;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import utils.UserCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * GET http://users.bugred.ru/tasks/rest/getuser
 */
public class GetUserInfo {
    private final String userName = UserCreator.getUserName();
    private final String userEmail = UserCreator.getEmail();
    private final String userPassword = UserCreator.getPassword();
    private final String expectedMessageUserNotBody = "Параметр email является обязательным!";
    JSONObject jsonObject;
    JSONParser jsonParser;

    @Test
    public void testGetUserInfoWithEmptyBody() throws IOException, ParseException, org.json.simple.parser.ParseException {
        HttpPost request = new HttpPost("http://users.bugred.ru/tasks/rest/doregister");
        List<NameValuePair> authParams = new ArrayList<>();
        authParams.add(new BasicNameValuePair("name", userName));
        authParams.add(new BasicNameValuePair("email", userEmail));
        authParams.add(new BasicNameValuePair("password", userPassword));
        request.setEntity(new UrlEncodedFormEntity(authParams));

        HttpGet httpGetRequest = new HttpGet("http://users.bugred.ru/tasks/rest/getuser?body=");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpGetRequest);
        String responseText = EntityUtils.toString(httpResponse.getEntity());

        jsonParser = new JSONParser();
        jsonObject = (JSONObject) jsonParser.parse(responseText);
        String responseMessage = jsonObject.get("message").toString();

        assertEquals(httpResponse.getCode(), 200);
        assertEquals(responseMessage, expectedMessageUserNotBody);

        HttpClientBuilder.create().build().close();
    }
}