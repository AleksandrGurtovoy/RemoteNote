package rest;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;

public class RestTest {

    @Test
    public void authUser_getLogin_code200() {
        get("/authorizeUser?login=admin").then().statusCode(200);
    }

}
