package ro.siit.aut.gr4.exam.test.functional;

import org.testng.Assert;
import org.testng.annotations.Test;
import ro.siit.aut.gr4.exam.test.constants.Constants;
import ro.siit.aut.gr4.exam.test.model.Greeting;
import ro.siit.aut.gr4.exam.test.services.ApiOperations;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Solution5Test {

    ApiOperations apiOperations = new ApiOperations();

    @Test
    public void testHelloApiResponse() {
        String response = apiOperations.getStringJsonContent(
                Constants.CLIENT_QE_URL + "Donald");

        Assert.assertNotNull(response);
    }

    @Test
    public void testGreetingContentWithNameGiven() {
        String name = "Vasile";

        Greeting greeting = apiOperations.getGreeting(Constants.CLIENT_QE_URL, name);
        System.out.println(greeting);
        Assert.assertTrue(greeting.getContent().contains(name));
    }

    @Test
    public void testGreetingContentWithNoNameGiven() {
        String visitor = "visitor";
        Greeting greeting = apiOperations.getGreeting(Constants.VISITOR_URL, "");
        System.out.println(greeting);
        Assert.assertTrue(greeting.getContent().contains(visitor));
    }

    @Test
    public void testGreetingContentIncompleteURL() {
        String visitor = "visitor";
        Greeting greeting = apiOperations.getGreeting(Constants.VISITOR_Q_URL, "");
        System.out.println(greeting);
        Assert.assertTrue(greeting.getContent().contains(visitor));
    }

    @Test
    public void testGreetingIdIncrement() {
        String visitor = "visitor";
        Greeting greeting = apiOperations.getGreeting(Constants.VISITOR_Q_URL, "");
        Greeting greeting2 = apiOperations.getGreeting(Constants.VISITOR_Q_URL, "");
        boolean isNextAutoIncrement = false;
        if (greeting.getId() + 1 == greeting2.getId()) {
            isNextAutoIncrement = true;
        }
        Assert.assertTrue(isNextAutoIncrement);
    }

    @Test
    public void testDate() {
        String visitor = "visitor";
        Greeting greeting = apiOperations.getGreeting(Constants.VISITOR_Q_URL, "");

        String dateNow = LocalDate.now().toString();
        System.out.println(dateNow);
        String greetingDate = greeting.getDate().substring(0, 10);
        System.out.println(greetingDate);
        Assert.assertEquals(greetingDate, dateNow);
    }
}
