package com.gorest.crudtest;

import com.gorest.testbase.TestBase;
import com.gorest.userinfo.UserSteps;
import com.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class UserCRUDTestWithSteps extends TestBase {

    static String name = TestUtils.getRandomValue() + "Garud Mehrotra";
    static String gender = "male";
    static String status = "active";
    String email = TestUtils.getRandomValue() + "mehrotra_garud@erdman.example";

    static int userId;
    @Steps
    UserSteps userSteps;

    @Title("Get all Users Details")
    @Test
    public void test003() {
        ValidatableResponse response = userSteps.getAllUsers().statusCode(200);
    }


    @Title("This will create a new user")
    @Test
    public void test001() {
        ValidatableResponse response = userSteps.createUser(name, email, gender, status).statusCode(201);
        userId = response.log().all().extract().path("id");
        System.out.println(userId);
    }

    @Title("Verify if the user was added to the application")
    @Test
    public void test002() {
        HashMap<String, Object> userMap = userSteps.getUserInfoByUserID(userId);

    }

    @Title("Update the user information and verify the updated information")
    @Test
    public void test004() {
        name = name + "Updated";
        ValidatableResponse response = userSteps.updateUser(userId, name, email, gender, status).statusCode(200);

    }

    @Title("Delete the user and verify if the user is deleted")
    @Test
    public void test005() {

        userSteps.deleteUser(userId).statusCode(204);

        userSteps.getUserById(userId).statusCode(404);
    }
}
