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
    public void getUserInfoWrongEmail() throws IOException {

        String userEmail = "vaknlnlndimplahotnk12";
        final Content postResult = Request.Get("http://users.bugred.ru/tasks/rest/getuser/?email=" + userEmail )
                .execute().returnContent();
        String entity = postResult.asString();
        //System.out.println(entity);
        Assert.assertTrue(entity.contains("{\"type\":\"error\",\"message\":\"\\u0412\\u044b \\u0432\\u0432\\u0435\\u043b\\u0438 \\u043d\\u0435\\u043f\\u0440\\u0430\\u0432\\u0438\\u043b\\u044c\\u043d\\u044b\\u0439 email\"}"));
    }
}
