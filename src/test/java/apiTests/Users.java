package apiTests;

import apiTests.helpers.UserHelper;
import org.junit.Test;

import static apiTests.helpers.UserHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Users {

    @Test
    public void checkGeorgBluthEmailPattern() {
        boolean userWasFound = false;
        UserHelper.getPageCount();
        int pageCount = Integer.parseInt(UserHelper.pageCount);

        for (pageNumber = 1; pageNumber <= pageCount; pageNumber++) {
            findUser("George", "Bluth");

            if (searchResult == null) {
                System.out.println("На этой странице не найдено такого пользователя, поищу на следующей");

            } else {
                userWasFound = true;
                System.out.println("Пользователь найден, проверяю его email");
                assertEquals(searchResult.getEmail(), "george.bluth@reqres.in");
                break;
            }
        }
        assertTrue(userWasFound);
    }

    @Test
    public void checkMichaelLawsonEmailPattern() {
        boolean userWasFound = false;
        getPageCount();
        int pageCount = Integer.parseInt(UserHelper.pageCount);

        for (pageNumber = 1; pageNumber <= pageCount; pageNumber++) {
            findUser("Michael", "Lawson");

            if (searchResult == null) {
                System.out.println("На этой странице не найдено такого пользователя, поищу на следующей");
                continue;

            } else {
                userWasFound = true;
                System.out.println("Пользователь найден на странице " + pageNumber + ",проверяю его email");
                assertEquals(searchResult.getEmail(), "michael.lawson@reqres.in");
                break;
            }
        }
        assertTrue(userWasFound);
    }
}

