import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class PingTests extends BaseTest{

    private static final String RESOURCE = "/ping";

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

    //hay q cambiar examen.testng.xml el nombre de este archivo q es el q tiene q correr
}
