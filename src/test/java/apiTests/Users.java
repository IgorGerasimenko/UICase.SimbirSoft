package apiTests;

import apiTests.pojos.UserPojo;
import io.restassured.http.ContentType;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

public class Users {

    @Test
    public void checkGeorgBluthEmailPattern (){
        List<UserPojo> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", UserPojo.class);
                UserPojo result = users.stream()
                .filter(p -> {
                    if ("george.bluth@reqres.in".equals(p.getEmail()) &
                            "George".equals(p.getFirst_Name()) &
                            "Bluth".equals(p.getLast_Name()))
                    {
                        return true;
                    }
                        return false;
                }).findAny()
                .orElse(null);
         assertNotNull(result);
    }

    @Test
    public void checkMichaelLawsonEmailPattern  (){
        List<UserPojo> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", UserPojo.class);
        UserPojo result = users.stream()
                .filter(p -> {
                    if ("michael.lawson@reqres.in".equals(p.getEmail()) &
                            "Michael".equals(p.getFirst_Name()) &
                            "Lawson".equals(p.getLast_Name()))
                    {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);
         assertNotNull(result);
    }
}


