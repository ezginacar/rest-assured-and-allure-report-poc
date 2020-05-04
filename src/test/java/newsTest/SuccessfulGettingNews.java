package newsTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import methods.Helpers;
import methods.TestMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtilities;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.SocketHandler;

import static java.lang.String.valueOf;
import static utils.TestUtilities.*;

public class SuccessfulGettingNews {

    String endpoint = "/v2/everything";

    Response response ;

    Helpers helper = new Helpers();
    TestMethods testMethods = new TestMethods();


    @Before
    public void sendRequest(){

        setBaseURI();
        setBasePath(endpoint);
        setContentType();


        param.put("q","covid");
        param.put( "from", helper.getCurrentDate());
        param.put("sortBy", "publishedAt");
        param.put("apiKey", apiKey);
        param.put("pageSize", "3");
        param.put("page", "1");


        RequestSpecification request = setQueryParams(param);
        response = sendGETrequest(request);
    }

    @After
    public void finishTest(){
        param.clear();
        response =null;
    }

    @Test
    public void statusCodeIs200() {
        testMethods.checkStatusWithGiven(response, 200);
    }



    @Test
    public void shownPageSizeValidation(){
        String actual =valueOf( testMethods.checkAmountWithGivenParam(response, "articles.source"));
        String expected = param.get("pageSize");

        Assert.assertEquals(expected,actual);


    }


}
