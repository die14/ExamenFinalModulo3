import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;
/*
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
*/

public class BaseTest {

    public RequestSpecification request;

    @BeforeClass
    @Parameters ("baseUrl")
    public void SetupRestAssured(@Optional String baseUrl){
        if (baseUrl ==null){
            baseUrl = "http://localhost:9000";
        }
        RestAssured.baseURI = baseUrl;

        System.out.println(String.format("Running on %s environment", baseUrl));
    }

    @BeforeMethod
    public void before(){
        request = RestAssured.given();
    }

}
