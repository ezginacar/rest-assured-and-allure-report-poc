package methods;



import io.restassured.response.Response;

import java.util.List;

public class TestMethods {

    List<String> list;

    public int getStatusCode(Response response){
       return response.getStatusCode();
    }

    public int checkAmountWithGivenParam(Response response, String path){

        list = response.jsonPath().getList(path);
        return list.size();

    }

    public String gettingParamValue(Response response, String path){

        return response.jsonPath().getString(path);

    }





}
