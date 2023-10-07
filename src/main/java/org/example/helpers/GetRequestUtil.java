package org.example.helpers;


import io.restassured.specification.RequestSpecification;
import org.example.response.UserResponse;

import java.util.List;

import static io.restassured.RestAssured.given;

public final class GetRequestUtil {
    public static <T> List<T> doGetReturnList(RequestSpecification specification,
                                              int httpStatusCode,
                                              int number,
                                              Class<T> clazz) {
        return given()
                .queryParam("page", number)
                .spec(specification)
                .when()
                .log().all()
                .get()
                .then().statusCode(httpStatusCode)
                .log().all()
                .extract().body()
                .jsonPath()
                .getList("data", clazz);
    }
}
