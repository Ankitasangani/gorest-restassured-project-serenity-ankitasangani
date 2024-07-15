package com.gorest.userinfo;


import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

public class UserSteps {

    @Step("Get all user details")
    public ValidatableResponse getAllUsers() {
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then();
    }

    @Step("Creating user with name:{0}, email: {1}, gender: {2}, status: {3}")
    public ValidatableResponse createUser(String name, String email, String gender, String status) {

        UserPojo userPojo = UserPojo.getUserPojo(name, email, gender, status);

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 2633d0058d2069545c8073896cbd4e12533b9b68bab8bb0ef0b969588bd7f7af")
                .when()
                .body(userPojo)
                .post(EndPoints.GET_ALL_USERS)
                .then();
    }

    @Step("Getting the user information with name : {0}")
    public HashMap<String, Object> getUserInfoByUserID(int userId) {

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 2633d0058d2069545c8073896cbd4e12533b9b68bab8bb0ef0b969588bd7f7af")
                .pathParam("id", userId)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then().statusCode(200).extract().path("");
    }

    @Step("Updating user with name:{0}, email: {1}, gender: {2}, status: {3}")
    public ValidatableResponse updateUser(int userId, String name, String email, String gender, String status) {

        UserPojo userPojo = UserPojo.getUserPojo(name, email, gender, status);

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .pathParam("id", userId)
                .header("Authorization", "Bearer 2633d0058d2069545c8073896cbd4e12533b9b68bab8bb0ef0b969588bd7f7af")
                .when()
                .body(userPojo)
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Deleting user information with userId: {0}")
    public ValidatableResponse deleteUser(int userId) {
        return SerenityRest.given()
                .pathParam("id", userId)
                .header("Authorization", "Bearer 2633d0058d2069545c8073896cbd4e12533b9b68bab8bb0ef0b969588bd7f7af")
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }

    @Step("Getting user information with userId: {0}")
    public ValidatableResponse getUserById(int userId) {
        return SerenityRest.given()
                .pathParam("id", userId)
                .header("Authorization", "Bearer 2633d0058d2069545c8073896cbd4e12533b9b68bab8bb0ef0b969588bd7f7af")
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }

}
