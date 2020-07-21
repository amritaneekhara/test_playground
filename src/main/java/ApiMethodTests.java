import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
 
public class ApiMethodTests {
 
    @Test
    void getTest() {
        //The base URI to be used
        RestAssured.baseURI = "https://postman-echo.com/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
 
        //Makes calls to the server using Method type.
        Response response = httpRequest.queryParam("foo1","bar1").queryParam("foo2", "bar2").get("/get");
 
        //Checks the Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
    
    @Test
    void getTestData() {
        //The base URI to be used
        RestAssured.baseURI = "https://postman-echo.com/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
        
        //Makes calls to the server using Method type.
        Response response = httpRequest.queryParam("foo1","bar1").queryParam("foo2", "bar2").get("/get");
 
        //Checks the Status Code
        JsonPath newData = response.jsonPath();
        String urlname = newData.get("url");
        Assert.assertEquals(urlname, "https://postman-echo.com/get?foo1=bar1&foo2=bar2");
    }
    
    @Test
    void postTestData() {
        //The base URI to be used
        RestAssured.baseURI = "https://postman-echo.com/";
 
        //Define the specification of request. Server is specified by baseURI above.
        RequestSpecification httpRequest = RestAssured.given();
        
        //Makes calls to the server using Method type.
        Response response = httpRequest.queryParam("foo1","bar1").queryParam("foo2", "bar2").post("/post");
 
        //Checks the Status Code
        JsonPath newData = response.jsonPath();
        String urlname = newData.get("url");
        Assert.assertEquals(urlname, "https://postman-echo.com/post");
    }
}