package methods;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class TestMethods {

    public void checkStatusWithGiven(Response response, int expectedStatus){
        int actualStatus =  response.getStatusCode();
        Assert.assertEquals(expectedStatus ,actualStatus);
    }

    public int checkAmountWithGivenParam(Response response, String path){

        List<String> list = response.jsonPath().getList(path);

        return list.size();

    }

    public String gettingParamValue(Response response, String path){

        return response.jsonPath().getString(path);

    }


}
