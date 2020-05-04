package newsTest;

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

import static utils.TestUtilities.*;


public class FailedViewNewsAfter1MounthFromCurrentDate  {

    String endpoint = "/v2/everything";



    Helpers helper = new Helpers();
    TestMethods testMethods = new TestMethods();

    String permittedDate = helper.getOldDate(31);
    String requestedDate =helper.getOldDate(32);
    String meesage = "You are trying to request results too far in the past. Your plan permits you to request articles as far back as "
        + permittedDate +", but you have requested "
        +requestedDate+". To extend this please upgrade to a paid plan.";



    @Before
    public void sendRequest(){
        //users
        setBaseURI();
        setBasePath(endpoint);
        setContentType();




        param.put("q","music");
        param.put( "from", requestedDate);
        param.put("sortBy", "publishedAt");
        param.put("apiKey", TestUtilities.apiKey);
        param.put("pageSize", "3");
        param.put("page", "1");


        RequestSpecification request = setQueryParams(param);
        response = sendGETrequest(request);

    }

    @After
    public void finishTest(){
        param.clear();
        response = null;
    }


    @Test
    public void validateResponseMessage(){
       String actual= testMethods.gettingParamValue(response, "message");
        Assert.assertEquals(meesage, actual);
    }




}
