package org.example.services;

import io.restassured.specification.RequestSpecification;
import org.example.helpers.ErrorRequestUtil;
import org.example.helpers.PostRequestUtil;
import org.example.helpers.Specification;
import org.example.request.ErrorData;
import org.example.request.UserData;
import org.example.response.ErrorResponse;
import org.example.response.LoginResponse;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.example.helpers.BaseUrl.AUTHORIZATION;

public final class LoginService {

    private RequestSpecification Specification() {
        return Specification.getReqSpec(AUTHORIZATION);
    }

    public LoginResponse successfulLoginUser(UserData user) {
        return PostRequestUtil.doPostReturnItem(user, HTTP_OK, Specification(), LoginResponse.class);
    }

    public ErrorResponse unsuccessfulLoginUser(ErrorData user) {
        return ErrorRequestUtil.getNegativeResponseWithPost(user, Specification(), HTTP_BAD_REQUEST);
    }
}
