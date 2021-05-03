package apiTests;

import apiTests.pojos.User;
import com.sun.istack.NotNull;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.with;
import static org.junit.Assert.*;

public class Users {
    String pageCount;
    int pageNumber;
    List<User> users;
    User result;



    public void getPageCount() {
        JsonPath jspath = given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath();

        pageCount = jspath.getString("total_pages");
        System.out.println("method 'users' have a " + pageCount + " pages");
    }

    public void findUser (String firstName, String lastName) {
        users = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=" + pageNumber)
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", User.class);

        result = users.stream()
                .filter(p ->
                        firstName.equals(p.getFirstName()) &
                                lastName.equals(p.getLastName()))
                .findAny()
                .orElse(null);
    }


    @Test
    public void checkGeorgBluthEmailPattern(){
        getPageCount();
        int pageCnt = Integer.parseInt(pageCount);
        for(pageNumber = 1;pageNumber <= pageCnt; pageNumber++) {
            findUser("George", "Bluth");

            if(result == null) {
                pageNumber++;
                System.out.println("На этой странице не найдено такого пользователя, поищу на следующей");
            } else  {
                System.out.println("Пользователь найден, проверяю его email");
                assertEquals(result.getEmail(),"george.bluth@reqres.in" );
                break;
            }
        }
    }

    @Test
    public void checkMichaelLawsonEmailPattern(){
        getPageCount();
        int pageCnt = Integer.parseInt(pageCount);
        for(pageNumber = 1;pageNumber <= pageCnt; pageNumber++) {
            findUser("Michael", "Lawson1");

            if(result == null) {
                System.out.println("На этой странице не найдено такого пользователя, поищу на следующей");
                continue;

            }else  {
                System.out.println("Пользователь найден на странице " + pageNumber + ",проверяю его email");
                assertEquals(result.getEmail(),"michael.lawson@reqres.in" );
                break;
            }
        }
    }
}

