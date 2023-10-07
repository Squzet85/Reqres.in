package org.example.helpers;
import io.restassured.specification.RequestSpecification;;
import org.example.BaseBodyEntity;
import org.example.response.ErrorResponse;

import static io.restassured.RestAssured.given;

public final class ErrorRequestUtil {

    public static ErrorResponse getNegativeResponseWithPost(BaseBodyEntity baseBodyEntity, RequestSpecification specification, int statusCode) {
        return given()
                .spec(specification)
                .body(baseBodyEntity)
                .when()
                .post()
                .then()
                .statusCode(statusCode)
                .extract().body().as(ErrorResponse.class);
    }

    public static <T> T getNegativeResponseWithPost(BaseBodyEntity baseBodyEntity,RequestSpecification specification, int statusCode, Class<T> clazz) {
        return given()
                .spec(specification)
                .body(baseBodyEntity)
                .when()
                .post()
                .then()
                .statusCode(statusCode)
                .extract().body().as(clazz);
    }
}
