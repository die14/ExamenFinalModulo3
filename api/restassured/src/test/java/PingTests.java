import org.testng.annotations.Test;
import static org.hamcrest.core.IsEqual.equalTo;

public class PingTests extends BaseTest{

    //private static final String RESOURCE = "/ping";
    private static final String statusURL = "/v1/examen/status";
    private static final String randomNameURL = "/v1/examen/randomName";
    private static final String sameNameURL = "/v1/examen/sameName";
    private static final String updateNameURL = "/v1/examen/updateName";
/*
    @Test
    public void Ping_Tests(){
        request
                .get(String.format("%s", RESOURCE))
                .then()
                .statusCode(200)
                .header("Access-Control-Allow-Origin", equalTo("http://localhost"))
                .body("id", equalTo(3),
                        "response", equalTo("pong"));
    }
 */

    @Test
    public void Status_Tests(){
        request
                .get(String.format("%s", statusURL))
            .then()
                .statusCode(200);
    }

    @Test
    public void randomName_Tests(){
        request
                .auth()
                .preemptive()
                .basic("testuser", "testpass")
                .get(String.format("%s", randomNameURL))
            .then()
                .statusCode(200);
    }

    @Test
    public void sameName_Tests(){
        request
                .body("{\"name\":\"Stone Cold\"}")
                .post(String.format("%s", sameNameURL))
            .then()
                .statusCode(200);
    }

    @Test
    public void updateName_Tests(){
        request
                .body("{\"name\":\"Stone Cold\"}")
                .put(String.format("%s", updateNameURL))
            .then()
                .statusCode(200);
    }

}
