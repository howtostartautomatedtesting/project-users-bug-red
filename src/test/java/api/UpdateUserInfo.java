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
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.UserCreator;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * PATCH http://users.bugred.ru/tasks/rest/fullupdateuser
 */
public class UpdateUserInfo {

    private static final String CREATE_NEW_USER_URL = "http://users.bugred.ru/tasks/rest/doregister";
    private static final String UPDATE_USER_INFO_URL = "http://users.bugred.ru/tasks/rest/fullupdateuser";

    private String userName = UserCreator.getUserName();
    private String userEmail = UserCreator.getEmail();
    private String userPassword = UserCreator.getPassword();

    CloseableHttpClient httpClient;

    @BeforeGroups("newUser")
    public void createNewUser() throws IOException, ParseException {
        httpClient = HttpClientBuilder.create().build();

        RequestBuilder requestBuilderPost = RequestBuilder.post();
        RequestBuilder builder1 = requestBuilderPost.setUri(CREATE_NEW_USER_URL);
        RequestBuilder builder2 = builder1.addParameter("name", userName)
                .addParameter("email", userEmail)
                .addParameter("password", userPassword);

        HttpUriRequest httpPost = builder2.build();
        httpClient.execute(httpPost);
    }

    @DataProvider(name = "validGender")
    public Object[] dataProviderValidGender() {
        return new Object[]{"m", "f"};
    }

    @Test(groups = "newUser", dataProvider = "validGender")
    public void testUpdateUserInfoWithValidData(String gender) throws IOException, ParseException, URISyntaxException {
        String birthday = UserCreator.getRandomDate();
        String startDate = UserCreator.getRandomDate();
        String hobby = UserCreator.getHobby();
        String inn = UserCreator.getINN();

        System.out.println(userEmail);

        HttpPatch httpPatch = new HttpPatch(UPDATE_USER_INFO_URL);
        List<NameValuePair> params = getQueryParameters(userEmail, userName, gender, birthday, startDate, hobby, inn);
        URI uri = new URIBuilder(httpPatch.getURI()).addParameters(params).build();
        httpPatch.setURI(uri);

        CloseableHttpResponse responsePatch = httpClient.execute(httpPatch);
        HttpEntity entity = responsePatch.getEntity();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(EntityUtils.toString(entity));

        System.out.println(jsonObject);

        assertEquals(jsonObject.get("birthday").toString(), birthday);
        assertEquals(jsonObject.get("date_start").toString(), startDate);
        assertEquals(jsonObject.get("inn").toString(), inn);
        assertEquals(jsonObject.get("gender").toString(), gender);
        assertNotEquals(jsonObject.get("hobby").toString(), hobby);
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
