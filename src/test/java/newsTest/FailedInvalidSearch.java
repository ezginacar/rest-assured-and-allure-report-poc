package newsTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import methods.Helpers;
import methods.TestMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static utils.TestUtilities.*;
import static utils.TestUtilities.param;

public class FailedInvalidSearch {

    String endpoint = "/v2/everything";

    Response response ;

    Helpers helper = new Helpers();
    TestMethods testMethods = new TestMethods();


    @Before
    public void sendRequest(){

        setBaseURI();
        setBasePath(endpoint);
        setContentType();


        param.put("q","invalidsearch");
        param.put( "from", helper.getCurrentDate());

        param.put("sortBy", "publishedAt");
        param.put("apiKey", apiKey);
        param.put("pageSize", "3");
        param.put("page", "1");

        RequestSpecification request = setQueryParams(param);
        response = sendGETrequest(request);
    }


    @Test
    public void statusCodeShouldNot200() {
        int status =testMethods.getStatusCode(response);
        Assert.assertNotEquals(200, status);
    }
}
