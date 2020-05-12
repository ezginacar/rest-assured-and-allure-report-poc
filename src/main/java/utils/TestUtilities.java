package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestUtilities {

    public static String mainURL = "https://newsapi.org";
    public static String apiKey ="fe8d0fb23729413ca5f8d6386e134b24";
    public static Response response ;

    public static  Map<String, String> param = new HashMap<String,String>();

    public static void setBaseURI (){

        RestAssured.baseURI = mainURL;
    }

    public static void setBasePath(String path) {
        RestAssured.basePath = path;
    }

    public static void setContentType() {
        given().contentType(ContentType.JSON);
    }


    public static Response sendGETrequest(RequestSpecification request){
        return request.when().get();
    }

    public static RequestSpecification setQueryParams(Map<String, String> params){
       RequestSpecification request =  given().queryParams(params);
       return request;
    }


}
