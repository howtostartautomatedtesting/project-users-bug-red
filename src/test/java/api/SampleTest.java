package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

/**
 *  instruction https://www.baeldung.com/integration-testing-a-rest-api
 */
public class SampleTest {

    @Test
    public void testGetUrl() throws IOException {
        HttpUriRequest request = new HttpGet( "http://users.bugred.ru/");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request    );
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), 200);
    }
}
