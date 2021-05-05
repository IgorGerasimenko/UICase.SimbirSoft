package apiTests;

import apiTests.helpers.UserHelper;
import apiTests.pojos.User;
import org.junit.Assert;
import org.junit.Test;

import static apiTests.helpers.UserHelper.*;
import static org.junit.Assert.*;

public class UsersTests {

    @Test
    public void checkGeorgBluthEmailPattern() {
        int pageCount = UserHelper.getPageCount();

        for (int pageNumber = 1; pageNumber <= pageCount; pageNumber++) {
            User searchResult = findUser("George", "Bluth", pageNumber);

            if (searchResult == null) {
                System.out.println("На этой странице не найдено такого пользователя, поищу на следующей");

            } else {
                System.out.println("Пользователь найден, проверяю его email");
                assertEquals(searchResult.getEmail(), "george.bluth@reqres.in");
                return;
            }
        }
        Assert.fail("что-то пошло не так, скорее всего пользователь не был найден");
    }

    @Test
    public void checkMichaelLawsonEmailPattern() {
        int pageCount = UserHelper.getPageCount();

        for (int pageNumber = 1; pageNumber <= pageCount; pageNumber++) {
            User searchResult = findUser("Michael111", "Lawson", pageNumber);

            if (searchResult == null) {
                System.out.println("На этой странице не найдено такого пользователя, поищу на следующей");

            } else {
                System.out.println("Пользователь найден, проверяю его email");
                assertEquals(searchResult.getEmail(), "michael.lawson@reqres.in");
                return;
            }
        }
        Assert.fail("что-то пошло не так, скорее всего пользователь не был найден");
    }

}

