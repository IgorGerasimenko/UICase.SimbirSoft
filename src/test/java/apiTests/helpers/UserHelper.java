package apiTests.helpers;

import apiTests.pojos.User;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserHelper {

    public static int getPageCount() {
        JsonPath jspath = given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath();

        int pageCount = jspath.getInt("total_pages");
        System.out.println("ответ метода 'users' разбит на " + pageCount + " страницы");
        return pageCount;
    }

    public static User findUser(String firstName, String lastName, int pageNumber) {
        List<User> users;
        users = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=" + pageNumber)
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", User.class);

        User searchResult = users.stream()
                .filter(p ->
                        firstName.equals(p.getFirstName()) &
                                lastName.equals(p.getLastName()))
                .findAny()
                .orElse(null);
        return searchResult;
    }
}
