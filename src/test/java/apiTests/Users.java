package apiTests;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;


import apiTests.pojos.UserPojo;
import io.restassured.http.ContentType;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class Users {

    @Test
    public void getUsers (){
        List<UserPojo> users = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", UserPojo.class);


                assertThat(users)
                        .extracting(UserPojo::getEmail)
                        .contains("george.bluth@reqres.in");




    }

//        when().
//                 get("https://reqres.in/api/users")
//                .then()
//                .statusCode(200)
//                .assertThat(Arrays.asList("data"), hasItems(endsWith("z"), endsWith("o")))
//                .assertThat().body("page", equalTo("1") );
////                .assertThat().body("email", equalTo("george.bluth@reqres.in") );



}
