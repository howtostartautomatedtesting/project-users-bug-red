package api;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 *  GET http://users.bugred.ru/tasks/rest/getuser
 */
public class GetUserInfo {
    @Test
    public void getUserInfo() throws IOException {

        String userEmail = "vadimplahotnk12@gmail.com";
        final Content postResult = Request.Get("http://users.bugred.ru/tasks/rest/getuser/?email=" + userEmail )
                .execute().returnContent();
        String entity = postResult.asString();
        Assert.assertTrue(entity.contains("{\"name\":\"Vadim123\",\"avatar\":\"http:\\/\\/users.bugred.ru\\/" +
                "\\/tmp\\/default_avatar.jpg\",\"email\":\"" + userEmail + "\",\"password\":" +
                "\"263fec58861449aacc1c328a4aff64aff4c62df4a2d50b3f207fa89b6e242c9aa778e7a8baeffef85b6ca6d2e7dc16ff0a760d59c13c238f6bcdc32f8ce9cc62\"" +
                ",\"birthday\":0,\"gender\":\"\",\"date_start\":0,\"hobby\":\"\"}"));
    }
}
