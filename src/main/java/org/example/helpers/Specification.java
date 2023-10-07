package org.example.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Specification {
    public static RequestSpecification getReqSpec(String URL) {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(URL)
                .setContentType(ContentType.JSON)
                .build();
        log.info("Сформирована спецификация для запроса");
        return requestSpecification;
    }
}
