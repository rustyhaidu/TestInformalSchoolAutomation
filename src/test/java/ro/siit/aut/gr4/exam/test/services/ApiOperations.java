package ro.siit.aut.gr4.exam.test.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import ro.siit.aut.gr4.exam.test.constants.Constants;
import ro.siit.aut.gr4.exam.test.model.Greeting;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ApiOperations {

    public String getStringJsonContent(String URLRequest) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(URLRequest);
        HttpResponse httpResponse;
        String jsonContent = "";
        try {
            httpResponse = httpclient.execute(httpGet);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            // Assert.assertEquals(200, statusCode);

            //String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
            //System.out.println("Response was: " + statusCode+ " -" + reasonPhrase);
            InputStream bodyAsInputStream = httpResponse.getEntity().getContent();
            jsonContent = IOUtils.toString(bodyAsInputStream);
            httpclient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonContent;
    }


    public Greeting getGreeting(String URL, String name) {
        Greeting greeting;
        String jsonData;
        jsonData = getStringJsonContent(URL + name);

        if (!jsonData.equals("")) {
            greeting = null;
            ObjectMapper om = new ObjectMapper();
            try {
                greeting = om.readValue(jsonData, Greeting.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return greeting;
        }
        return null;


    }
}
