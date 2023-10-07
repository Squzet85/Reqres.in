package org.example.helpers;

import io.restassured.specification.RequestSpecification;
import org.example.BaseBodyEntity;

import static io.restassured.RestAssured.given;


public class PostRequestUtil {

    public static void doPostReturnItem(BaseBodyEntity baseBodyEntity,
                                        int httpStatusCode,
                                        RequestSpecification specification) {
        given()
                .spec(specification)
                .body(baseBodyEntity)
                .when()
                .log().all()
                .post().then()
                .statusCode(httpStatusCode)
                .log().all();
    }

    public static <T> T doPostReturnItem(BaseBodyEntity baseBodyEntity,
                                         int httpStatusCode,
                                         RequestSpecification specification,
                                         Class<T> clazz) {
        return given()
                .spec(specification)
                .body(baseBodyEntity)
                .when()
                .log().all()
                .post().then()
                .statusCode(httpStatusCode)
                .log().all()
                .extract().body().as(clazz);
    }
}
