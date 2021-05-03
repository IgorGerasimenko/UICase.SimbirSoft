package apiTests.helpers;

import apiTests.pojos.User;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserHelper {
    public static String pageCount;
    public static int pageNumber;
    public static List<User> users;
    public static User searchResult;


    public static void getPageCount() {
        JsonPath jspath = given()
                .when()
                .get("https://reqres.in/api/users?page=1")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .jsonPath();

        pageCount = jspath.getString("total_pages");
        System.out.println("ответ метода 'users' разбит на " + pageCount + " страницы");
    }

    public static void findUser(String firstName, String lastName) {
        users = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=" + pageNumber)
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", User.class);

        searchResult = users.stream()
                .filter(p ->
                        firstName.equals(p.getFirstName()) &
                                lastName.equals(p.getLastName()))
                .findAny()
                .orElse(null);
    }
}
